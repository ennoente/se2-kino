package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import java.util.HashMap;

public class Geldbetrag {
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

    @Override
    public String toString()
    {
        return _eurocent / 100 + "," + _eurocent % 100 + "€";
    }
}
