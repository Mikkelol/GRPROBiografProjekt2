package view;

import model.Customer;
import model.Reservation;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Olaleo on 10-12-2015.
 */
public class FindReservationView {
    private MainView mainView;
    private JPanel contentPane;
    private JTextField nameTextField;
    private JTextField numberTextField;
    private JButton findReservationButton;
    private JScrollBar scrollBar1;
    private FindReservationInformation findReservationInformation1;

    public FindReservationView(MainView mainView)
    {
        this.mainView = mainView;
        findReservationButton.addActionListener(e -> {
            findReservationInformation1.changeReservationList(mainView.getReservationList(new Customer(nameTextField.getText(), numberTextField.getText())));
        });
    }

    public JPanel getContentPane()
    {
        return contentPane;
    }

    public void changeReservationList(ArrayList<Reservation> reservations)
    {
        findReservationInformation1.changeReservationList(reservations);
    }

    private void createUIComponents()
    {
        findReservationInformation1 = new FindReservationInformation();
        // TODO: place custom component creation code here
    }
}
