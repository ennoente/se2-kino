package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlen;

import de.uni_hamburg.informatik.swt.se2.kino.fachwerte.Geldbetrag;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BezahlWerkzeug
{
    private Geldbetrag _zuZahlenderBetrag;
    private Geldbetrag _bezahlterBetrag;
    private Geldbetrag _restBetrag;
    private final BezahlWerkzeugUI _ui;

    private boolean _esWurdeBezahlt = false;

    public BezahlWerkzeug()
    {
        _ui = new BezahlWerkzeugUI();
        registriereUIAktionen();
    }

    /**
     * Führt den Bezahlvorgang zu einem oder mehreren Plätzen durch.
     * @return
     */
    public boolean fuehreBezahlungDurch(Geldbetrag zuZahlenderBetrag)
    {
        _zuZahlenderBetrag = zuZahlenderBetrag;
        aktualisiereBetraege();
        aktualisiereButtons();
        _ui.show();
        return _esWurdeBezahlt;
    }

    private void aktualisiereBetraege()
    {
        _ui.setZuZahlenderBetrag(_zuZahlenderBetrag);
        _bezahlterBetrag = _ui.getUebergebenerBetrag();
        _restBetrag = Geldbetrag.select(_zuZahlenderBetrag.toEurocent() - _bezahlterBetrag.toEurocent());
        _ui.setRestbetrag(_restBetrag);
    }

    private void aktualisiereButtons()
    {
        if (_restBetrag.toEurocent() < 0) {
            _ui.enableSubmitButton();
        } else {
            _ui.disableSubmitButton();
        }
    }

    private void registriereUIAktionen()
    {
        _ui.getSubmitButton().addActionListener(new ActionListener()
        {
            @Override public void actionPerformed(ActionEvent e)
            {
                _esWurdeBezahlt = true;
                _ui.close();
            }
        });

        _ui.getCancelButton().addActionListener(new ActionListener()
        {
            @Override public void actionPerformed(ActionEvent e)
            {
                _esWurdeBezahlt = false;
                _ui.close();
            }
        });

        _ui.getUebergebenerBetragFeld().addActionListener(new ActionListener()
        {
            @Override public void actionPerformed(ActionEvent e)
            {
                aktualisiereBetraege();
                aktualisiereButtons();
            }
        });
    }
}
