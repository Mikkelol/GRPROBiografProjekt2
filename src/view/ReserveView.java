package view;

import model.Show;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Olaleo on 10-12-2015.
 */
public class ReserveView extends JComponent {
    private MainView mainView;
    private JPanel contentPane;
    private JTextField nameField;
    private JTextField numberField;
    private JButton saveReservationButton;
    private JButton findReservationButton;
    private JButton cancelButton;
    private JLabel showNameJLabel;
    private JLabel showTimeJLabel;
    private JLabel showTheaterJLabel;
    private SeatMatrix seatMatrix1;
    private Show currentShow;

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
        currentShow = show;
    }



    public void initialize()
    {
        cancelButton.addActionListener(e -> {
            mainView.changeViewToShowView();
        });
        saveReservationButton.addActionListener(e -> {
            String name = nameField.getText();
            String number = numberField.getText();
            ArrayList<int[]> selectedSeats = seatMatrix1.getSelected();
            mainView.saveReservation(currentShow, name, number, selectedSeats);

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
