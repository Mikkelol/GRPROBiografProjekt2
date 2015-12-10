package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Olaleo on 10-12-2015.
 */
public class ReserveView extends JComponent {
    private MainView mainView;
    private JPanel contentPane;
    private JTextField textField1;
    private JTextField textField2;
    private JButton saveReservationButton;
    private JButton findReservationButton;
    private JButton cancelButton;

    public ReserveView(MainView m)
    {
        mainView = m;
        initialize();
    }

    public void initialize()
    {
        cancelButton.addActionListener(e -> {
            mainView.changeViewToShowView();
        });
    }

    public JPanel getContentPane()
    {
        return contentPane;
    }
}
