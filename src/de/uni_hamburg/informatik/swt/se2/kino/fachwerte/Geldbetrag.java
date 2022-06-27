package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import java.util.HashMap;

public class Geldbetrag
{
    private final int _eurocent;
    private static final HashMap<Integer, Geldbetrag> UNIVERSUM = new HashMap<>();

    private Geldbetrag(int eurocent)
    {
        _eurocent = eurocent;
    }

    /**
     * Returns a @Geldbetrag object from the @UNIVERSUM pool of possible @Geldbetrag objects.
     * If none exists, a new one is created and added to the pool.
     *
     * @param eurocent The amount of Euro Cents
     * @return A @Geldbetrag object depicting the eurocents passed via argument
     */
    public static Geldbetrag select(int eurocent)
    {
        if (!UNIVERSUM.containsKey(eurocent))
        {
            UNIVERSUM.put(eurocent, new Geldbetrag(eurocent));
        }

        return UNIVERSUM.get(eurocent);
    }

    /**
     * Returns a @Geldbetrag object from the @UNIVERSUM pool of possible @Geldbetrag objects.
     * If none exists, a new one is created and added to the pool.
     *
     * @param euro The amount of Euros
     * @param cent The amount of Cents
     * @return A @Geldbetrag object depicting the eurocents passed via argument
     *
     * @require !(Math.signum(euro) == -1.0 and Math.signum(cent) == -1.0)
     * @require !(Math.signum(euro) == 1.0 and Math.signum(cent) == -1.0)
     * 
     */
    public static Geldbetrag select(int euro, int cent)
    {
    	assert !((Math.signum(euro) == -1.0) && (Math.signum(cent) == -1.0)): "vorbedingung verletzt";
    	assert !((Math.signum(euro) == 1.0) && (Math.signum(cent) == -1.0)): "vorbedingung verletzt";

    	int vorzeichen = 1;
    	if (Math.signum(euro) < 0 || Math.signum(cent) < 0)
    	{
    		vorzeichen = -1;
    	}
    	
    	int eurocent = vorzeichen * (Math.abs(euro * 100) + Math.abs(cent));

        return Geldbetrag.select(eurocent);
    }

    /**
     * Parses a String depicting a human-readable amount of money, e.g.: "3,50"
     * for 3 euros with 50 cents.
     *
     * @param geldString The human-readable string
     * @return A @Geldbetrag object depicting the appropriate money
     */
    public static Geldbetrag parse(String geldString)
    {
       if (geldString.equals(""))
       {
           Geldbetrag.select(0);
       }

        String filteredString = geldString.replaceAll("[^0-9-,]*", "");
        String[] splitString = filteredString.split(",");

        int euro = Integer.parseInt(splitString[0]);
        int cent = 0;

        if (filteredString.contains(","))
        {
            String centString = splitString[1].length() < 2 ? splitString[1] + "0" : splitString[1];
            cent = Integer.parseInt(centString);
        }

        return Geldbetrag.select(euro, cent);
    }

    /**
     * Returns the amount of cents stored in this object.
     *
     * @return The amount of cents
     */
    public int toEurocent()
    {
        return _eurocent;
    }

    /**
     * Converts the money that this object depicts into a human-readable string.
     *
     * @return The money depicted by this object
     */
    @Override
    public String toString()
    {
    	String vorzeichen = "";

    	if (Math.signum(_eurocent) == -1.0)
    		vorzeichen = "-";

        return vorzeichen + Math.abs(_eurocent / 100) + "," + String.format("%02d", Math.abs(_eurocent) % 100) + "€";
    }
}
