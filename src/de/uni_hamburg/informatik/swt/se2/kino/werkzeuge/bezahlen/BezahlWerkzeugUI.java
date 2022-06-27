package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlen;

import de.uni_hamburg.informatik.swt.se2.kino.fachwerte.Geldbetrag;

import javax.swing.*;
import java.awt.*;

public class BezahlWerkzeugUI
{
    private JFrame _frame;
    private JPanel _panel;
    private JDialog _dialog;
    private JButton _submitButton;
    private JButton _cancelButton;
    private JLabel _zuZahlenderBetragLabel;
    private JLabel _uebergebenerBetragLabel;
    private JLabel _restBetragLabel;
    private JTextField _uebergebenerBetragFeld;

    /**
     * Initializes the UI.
     */
    public BezahlWerkzeugUI()
    {
        erstelleDialog();
    }

    /**
     * Creates the dialog necessary for paying.
     */
    private void erstelleDialog()
    {
        _frame = new JFrame("Bezahl deine Plätze!");
        _dialog = new JDialog(_frame, "Bezahl deine Plätze!");
        _panel = new JPanel();
        _cancelButton = new JButton("Abbrechen");
        _submitButton = new JButton("OK");
        _zuZahlenderBetragLabel = new JLabel(" Zu zahlender Betrag: ");
        _uebergebenerBetragLabel = new JLabel("Uebergebener Betrag: ");
        _uebergebenerBetragFeld = new JTextField("0,00");
        _restBetragLabel = new JLabel("Restbetrag: ");

        _dialog.setModal(true);
        _dialog.setSize(400, 200);
        _dialog.add(_panel);
        _panel.setLayout(new BoxLayout(_panel, BoxLayout.Y_AXIS));
        _panel.add(_zuZahlenderBetragLabel);
        _panel.add(_uebergebenerBetragLabel);
        _panel.add(_uebergebenerBetragFeld);
        _panel.add(_restBetragLabel);
        _panel.add(_submitButton);
        _panel.add(_cancelButton);
    }

    /**
     * Closes the dialog.
     */
    public void close()
    {
        _frame.dispose();
    }

    /**
     * Shows the dialog.
     */
    public void show()
    {
        _uebergebenerBetragFeld.setText("");
        _dialog.setVisible(true);
    }

    /**
     * Enables the submit button.
     */
    public void enableSubmitButton()
    {
        _submitButton.setEnabled(true);
    }

    /**
     * Disables the submit button.
     */
    public void disableSubmitButton()
    {
        _submitButton.setEnabled(false);
    }

    /**
     * Returns the submit button.
     *
     * @return The submit button
     */
    public JButton getSubmitButton()
    {
        return _submitButton;
    }

    /**
     * Returns the cancel button.
     *
     * @return The cancel button
     */
    public JButton getCancelButton()
    {
        return _cancelButton;
    }

    /**
     * Returns the already payed amount.
     *
     * @return The already paid amount
     */
    public Geldbetrag getUebergebenerBetrag()
    {
        return Geldbetrag.parse(getUebergebenerBetragFeld().getText());
    }

    /**
     * Returns the JTextField for the payment input.
     *
     * @return The JTextField for the payment input
     */
    public JTextField getUebergebenerBetragFeld()
    {
        return _uebergebenerBetragFeld;
    }

    /**
     * Sets the amount to be payed.
     *
     * @param betrag The amount to be payed
     */
    public void setZuZahlenderBetrag(Geldbetrag betrag)
    {
        _zuZahlenderBetragLabel.setText("Zu zahlen: " + betrag);
    }

    /**
     * Sets the amount that is refunded to the user.
     *
     * @param betrag The amount that is refunded to the user.
     */
    public void setRestbetrag(Geldbetrag betrag)
    {
        _restBetragLabel.setText("Restbetrag: " + betrag);
    }
}
