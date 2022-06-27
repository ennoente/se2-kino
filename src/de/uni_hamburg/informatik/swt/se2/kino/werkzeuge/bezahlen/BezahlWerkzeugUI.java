package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlen;

import de.uni_hamburg.informatik.swt.se2.kino.fachwerte.Geldbetrag;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BezahlWerkzeugUI {
    private JFrame _frame;
    private JDialog _dialog;

    /*
    private JButton _submitButton;
    private JButton _cancelButton;
    private JLabel _betragLabel;
    private JLabel _uebergebenerBetrag;
    private JLabel _restBetragLabel;
    private JTextField _uebergebenerBetragFeld;
    private JLabel _uebergebenerBetragEuroLabel;
    private JLabel _bezahlterBetragLabel;
     */
    private JLabel _zuZahlenLabel;
    private JLabel _betragLabel;
    private JLabel _gegebenLabeL;
    private JTextField _uebergebenerBetragFeld;
    private JLabel _restBetragLabel;
    private JLabel _restBetrag;
    private JButton _cancelButton;
    private JButton _submitButton;


    public BezahlWerkzeugUI()
    {
        JFrame frame = new JFrame("");
        _dialog = new JDialog(frame, "Bezahl deine Karten!", true);

        JPanel gridLayoutContainer = new JPanel();
        gridLayoutContainer.setLayout(new GridLayout(5, 2));

        _zuZahlenLabel = new JLabel("Zu zahlen:");
        //_betragLabel = new JLabel(zuZahlenderGeldbetrag.toString());
        _betragLabel = new JLabel("");
        _gegebenLabeL = new JLabel("Gegeben:");
        _uebergebenerBetragFeld = new JTextField("");
        _restBetragLabel = new JLabel("Rückgeld:");
        //_restBetragLabel = new JLabel("Restbetrag: 0€");
        _restBetrag = new JLabel("[rest]");
        _cancelButton = new JButton("Abbrechen");
        _submitButton = new JButton("OK!");

        gridLayoutContainer.add(_zuZahlenLabel);
        gridLayoutContainer.add(_betragLabel);
        gridLayoutContainer.add(_gegebenLabeL);
        gridLayoutContainer.add(_uebergebenerBetragFeld);
        gridLayoutContainer.add(_restBetragLabel);
        gridLayoutContainer.add(_restBetrag);
        gridLayoutContainer.add(_cancelButton);
        gridLayoutContainer.add(_submitButton);

        _dialog.add(gridLayoutContainer);
        _dialog.setSize(new Dimension(400, 400));
        _dialog.setLocation(400, 400);
        _dialog.setVisible(false);
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
        return _uebergebenerBetragFeld;
    }

    public void setBetrag(Geldbetrag betrag)
    {

    }

    public void setRestbetrag(Geldbetrag betrag)
    {

    }

    public void show() {
        _dialog.setVisible(true);
    }
}
