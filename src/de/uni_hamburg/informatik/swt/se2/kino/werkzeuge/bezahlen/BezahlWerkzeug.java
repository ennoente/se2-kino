package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlen;

import de.uni_hamburg.informatik.swt.se2.kino.fachwerte.Geldbetrag;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BezahlWerkzeug {
    private BezahlWerkzeugUI _ui;

    public BezahlWerkzeug()
    {
        _ui = new BezahlWerkzeugUI();
    }

    /**
     * Führt den Bezahlvorgang zu einem oder mehreren Plätzen durch.
     * @return
     */
    public boolean fuehreBezahlungDurch(Geldbetrag zuZahlenderBerag)
    {

    }

    public void aktualisiereBetraege()
    {

    }

    private void registriereUIAktionen()
    {
        _ui.getSubmitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
}
