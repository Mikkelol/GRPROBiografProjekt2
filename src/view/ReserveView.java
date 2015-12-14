package view;

import model.Show;

import javax.swing.*;

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
    private JLabel showNameJLabel;
    private JLabel showTimeJLabel;
    private JLabel showTheaterJLabel;
    private SeatMatrix seatMatrix1;

    public ReserveView(MainView m)
    {
        mainView = m;
        initialize();
    }

    public void changeShow(Show show)
    {
        seatMatrix1.changeShow(show);
        showNameJLabel.setText(show.getFilm());
        showTimeJLabel.setText(Integer.toString(show.getTime()));
        showTheaterJLabel.setText(show.getTheater().getIdentifier());
        saveReservationButton.removeAll();
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

    private void createUIComponents()
    {
        seatMatrix1 = new SeatMatrix();
        // TODO: place custom component creation code here
    }
}
