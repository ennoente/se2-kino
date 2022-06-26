package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlen;

import de.uni_hamburg.informatik.swt.se2.kino.fachwerte.Geldbetrag;

import javax.swing.*;

public class BezahlWerkzeugUI {
    private JFrame _frame;
    private JPanel _panel;
    private JDialog _dialog;
    private JButton _submitButton;
    private JButton _cancelButton;
    private JLabel _betragLabel;
    private JLabel _restBetragLabel;
    private JLabel _bezahlterBetragLabel;
    private JTextField _uebergebenerBetrag;

    public BezahlWerkzeugUI()
    {
        _frame = new JFrame("Bezahl deine Plätze!");
        _panel = new JPanel();
    }

    public JButton getSubmitButton()
    {
        return _submitButton;
    }

    public JButton getCancelButton()
    {
        return _cancelButton;
    }

    public JTextField getUebergebenerBetragFeld()
    {
        return _uebergebenerBetrag;
    }

    public void setBetrag(Geldbetrag betrag)
    {

    }

    public void setRestbetrag(Geldbetrag betrag)
    {

    }
}
