package view;

import model.Show;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Olaleo on 10-12-2015.
 */
public class ShowView extends JComponent{
    private MainView mainView;
    private JButton findReservationButton;
    private JScrollBar scrollBar1;
    private JPanel contentPane;
    private ShowInformation showInformation1;


    public ShowView(MainView mainView)
    {
        this.mainView = mainView;
        initialize();
        //showInformation1 = new ShowInformation(mainView);

    }

    public void initialize()
    {
        findReservationButton.addActionListener(e -> {
            mainView.changeViewToFindReservationView();
        });

    }

    public void drawShows()
    {

        ArrayList<Show> shows= mainView.getShows();

        JLabel nameJLabel = new JLabel(shows.get(0).getFilm());
        nameJLabel.setLocation(100,100);
        nameJLabel.setSize(100,100);
        nameJLabel.setVisible(true);

        // dato show tidspunkt
    }


    public JPanel getContentPane()
    {
        return contentPane;
    }

    private void createUIComponents()
    {
        showInformation1 = new ShowInformation(mainView);
        showInformation1.setVisible(true);




        // TODO: place custom component creation code here
    }
}
