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
    	_successful = false;
        _ui = new BezahlWerkzeugUI();
                
        _ui.getCancelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _successful = false;
                _ui.hide();
            }
        });
        _ui.getSubmitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _successful = true;
                _ui.hide();
            }
        });
    }

    /**
     * Führt den Bezahlvorgang zu einem oder mehreren Plätzen durch.
     * @return
     */
    public boolean fuehreBezahlungDurch(Geldbetrag zuZahlenderBerag)
    {
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
