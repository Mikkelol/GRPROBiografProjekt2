package view;

import javax.swing.*;

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

    public void drawShows()
    {
        mainView.getShows();

        // dato show tidspunkt
    }


    public JPanel getContentPane()
    {
        return contentPane;
    }
}
