package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Olaleo on 10-12-2015.
 */
public class ShowView extends JComponent{
    private MainView mainView;
    private JButton findReservationButton;
    private JScrollBar scrollBar1;
    private JPanel contentPane;


    public ShowView(MainView mainView)
    {
        this.mainView = mainView;
        initialize();

    }

    public void initialize()
    {
        findReservationButton.addActionListener(e -> {
            mainView.changeViewToFindReservationView();
        });
    }


    public JPanel getContentPane()
    {
        return contentPane;
    }
}
