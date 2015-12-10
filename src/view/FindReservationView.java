package view;

import javax.swing.*;

/**
 * Created by Olaleo on 10-12-2015.
 */
public class FindReservationView {
    private MainView mainView;
    private JPanel contentPane;
    private JTextField textField1;
    private JTextField textField2;
    private JButton findReservationButton;
    private JScrollBar scrollBar1;

    public FindReservationView(MainView mainView)
    {
        this.mainView = mainView;
    }

    public JPanel getContentPane()
    {
        return contentPane;
    }
}
