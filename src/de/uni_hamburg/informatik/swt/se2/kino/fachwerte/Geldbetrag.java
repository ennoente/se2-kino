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

    public static Geldbetrag parse(String euroString)
    {
//        if (euroString.equals("")) {
//            Geldbetrag.select(0);
//        }

       String[] splitString = euroString.replace("€", "").split(",");
       int euro = Integer.parseInt("0" + splitString[0]);
       int cent = Integer.parseInt("0" + splitString[1]);

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
    	
        return vorzeichen + _eurocent / 100 + "," + String.format("%02d", Math.abs(_eurocent) % 100) + "€";
    }
}
