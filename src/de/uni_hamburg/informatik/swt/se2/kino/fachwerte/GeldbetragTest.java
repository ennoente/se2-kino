package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GeldbetragTest
{

    @Before public void setUp() throws Exception
    {
    }

    @Test public void testSelectEurocentSameReferences()
    {
        Geldbetrag betrag1 = Geldbetrag.select(100);
        Geldbetrag betrag2 = Geldbetrag.select(100);
        Geldbetrag betrag3 = Geldbetrag.select(101);

        assertEquals(betrag1, betrag2);
        assertNotEquals(betrag1, betrag3);
    }

    @Test public void testSelectEuroAndCentSameReferences()
    {
        Geldbetrag betrag1 = Geldbetrag.select(100, 10);
        Geldbetrag betrag2 = Geldbetrag.select(100, 10);
        Geldbetrag betrag3 = Geldbetrag.select(101, 10);

        assertEquals(betrag1, betrag2);
        assertNotEquals(betrag1, betrag3);
    }

    @Test public void testSelectSameReferences()
    {
        Geldbetrag betrag1 = Geldbetrag.select(100, 10);
        Geldbetrag betrag2 = Geldbetrag.select(10010);

        assertEquals(betrag1, betrag2);
    }

    @Test public void testParse()
    {
        assertEquals(Geldbetrag.select(100, 10), Geldbetrag.parse("100,10€"));

        assertEquals(Geldbetrag.select(-100, 10), Geldbetrag.parse("-100,10€"));

        assertEquals(Geldbetrag.select(10), Geldbetrag.parse("0,10€"));

        assertEquals(Geldbetrag.select(0), Geldbetrag.parse(""));
    }

    @Test public void testToEurocent()
    {
        assertEquals(100, Geldbetrag.select(100).toEurocent());
        assertEquals(10110, Geldbetrag.select(101, 10).toEurocent());
    }

    @Test public void testToString()
    {
        assertEquals("100,10€", Geldbetrag.select(100, 10).toString());
        assertEquals("-1,50€", Geldbetrag.select(-1, 50).toString());
        assertEquals("-2,05€", Geldbetrag.select(-2, 05).toString());
        assertEquals("-2,05€", Geldbetrag.select(-2, 005).toString());
        assertEquals("-0,05€", Geldbetrag.select(0, -5).toString());
    }
}
