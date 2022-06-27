package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlen;

import de.uni_hamburg.informatik.swt.se2.kino.fachwerte.Geldbetrag;
import de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.ObservableSubwerkzeug;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BezahlWerkzeug extends ObservableSubwerkzeug {
    private BezahlWerkzeugUI _ui;

    private boolean _successful;

    public BezahlWerkzeug()
    {
        _ui = new BezahlWerkzeugUI();
        _successful = false;
    }

    /**
     * Führt den Bezahlvorgang zu einem oder mehreren Plätzen durch.
     * @return
     */
    public boolean fuehreBezahlungDurch(Geldbetrag zuZahlenderBerag)
    {
        _ui.getCancelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Return false
                _successful = false;
            }
        });
        _ui.getSubmitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _successful = true;
            }
        });
        _ui.show();

        return _successful;
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
