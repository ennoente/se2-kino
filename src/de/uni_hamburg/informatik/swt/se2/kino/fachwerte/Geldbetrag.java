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

    public static Geldbetrag select(int eurocent)
    {
        if (!UNIVERSUM.containsKey(eurocent))
        {
            UNIVERSUM.put(eurocent, new Geldbetrag(eurocent));
        }

        return UNIVERSUM.get(eurocent);
    }

    public static Geldbetrag select(int euro, int cent)
    {
        return Geldbetrag.select(euro * 100 + cent);
    }

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

    public int toEurocent()
    {
        return _eurocent;
    }

    @Override
    public String toString()
    {
    	String vorzeichen = "";
    	
    	if (Math.signum(_eurocent) == -1.0)
    		vorzeichen = "-";
    	
        return vorzeichen + Math.abs(_eurocent / 100) + "," + String.format("%02d", Math.abs(_eurocent) % 100) + "€";
    }
}
