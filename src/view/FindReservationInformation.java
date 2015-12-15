package view;

import model.Reservation;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Olaleo on 14-12-2015.
 */
public class FindReservationInformation extends JComponent{

    private ArrayList<Reservation> reservations;
    private MainView mainView;

    public FindReservationInformation(MainView mainView)
    {
        this.mainView = mainView;
        reservations = new ArrayList<>();
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        if (reservations.size()<0)
        {
            //drawReservationsInformations(g, reservations);
        }
    }

    private void drawReservationsInformations( ArrayList<Reservation> reservations)
    {
        for (int i = 0; i < reservations.size(); i++)
        {
            //drawReservation(g,reservations.get(i),20*i);
            drawReservation(reservations.get(i), 20 * i);
        }
    }

    private void drawReservation( Reservation reservation, int y)
    {
        JLabel name = new JLabel(reservation.getCustomer().getName());
        name.setSize(100,20);
        name.setLocation(10,y);
        add(name);
        JLabel number = new JLabel(reservation.getCustomer().getNumber());
        number.setSize(70,20);
        number.setLocation(120,y);
        add(number);
        JLabel show = new JLabel(reservation.getShow().getFilm());
        show.setSize(100,20);
        show.setLocation(230,y);
        add(show);
        JLabel theater = new JLabel(reservation.getShow().getTheater().getIdentifier());
        theater.setSize(100,20);
        theater.setLocation(340,y);
        add(theater);
        JLabel date = new JLabel(reservation.getShow().getDate());
        date.setSize(100,20);
        date.setLocation(450,y);
        add(date);
        JLabel time = new JLabel(Integer.toString(reservation.getShow().getTime()));
        time.setSize(100,20);
        time.setLocation(560,y);
        add(time);
        JButton button = new JButton("Pick Reservation");
        button.setSize(140,20);
        button.setLocation(670,y);
        button.addActionListener(e -> {
            Reservation r = mainView.findReservation(name.getText(), number.getText(), reservation.getShow());
            mainView.changeViewToReserveView(reservation.getShow(), reservation);
        });
        add(button);
    }

    public void changeReservationList(ArrayList<Reservation> reservations)
    {
        this.reservations = reservations;
        drawReservationsInformations(reservations);

    }
}
