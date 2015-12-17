package view;

import model.Customer;
import model.Reservation;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Olaleo on 14-12-2015.
 * the Window from where you can enter af name and a phone number and get a list of all the reservations a given customer
 * has made. Every reservation on the list then has the possibility to either delete a reservation og change it.
 */
public class FindReservationInformation extends JComponent{

    private MainView mainView;

    public FindReservationInformation(MainView mainView)
    {
        this.mainView = mainView;
    }


    private void drawReservationsInformations( ArrayList<Reservation> reservations)
    {
        int q = 0;
        for (int i = 0; i < reservations.size(); i++)
        {
            if (reservations.get(i).equals(reservations.get(0)))
                {
                    drawColumnNames(20*q);
                    q++;
                }
            drawReservation(reservations.get(i), 20 * q);
            q++;
        }
        setMinimumSize(new Dimension(1000, 20 * q  + 10));
    }

    private void drawColumnNames(int y)
    {
        JLabel name = new JLabel("Name");
        name.setSize(100,20);
        name.setLocation(10,y);
        add(name);
        JLabel number = new JLabel("Number");
        number.setSize(70,20);
        number.setLocation(120,y);
        add(number);
        JLabel show = new JLabel("Film");
        show.setSize(100,20);
        show.setLocation(230,y);
        add(show);
        JLabel theater = new JLabel("Theater");
        theater.setSize(100,20);
        theater.setLocation(340,y);
        add(theater);
        JLabel date = new JLabel("Date");
        date.setSize(100,20);
        date.setLocation(450,y);
        add(date);
        JLabel time = new JLabel("Time");
        time.setSize(100,20);
        time.setLocation(560,y);
        add(time);
        JSeparator lineJSeparator = new JSeparator(SwingConstants.HORIZONTAL);
        lineJSeparator.setSize(660,1);
        lineJSeparator.setLocation(10,y + 20);
        add(lineJSeparator);
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

        String stringTime = String.valueOf(reservation.getShow().getTime());

        while(stringTime.length() < 4) {

            stringTime = "0" + stringTime;

        }

        JLabel time = new JLabel(stringTime);
        time.setSize(100,20);
        time.setLocation(560,y);
        add(time);
        JButton pickReservationButton = new JButton("Pick Reservation");
        pickReservationButton.setSize(140,20);
        pickReservationButton.setLocation(670,y);
        pickReservationButton.addActionListener(e -> {
            mainView.changeViewToReserveView(reservation.getShow(), reservation);
        });
        add(pickReservationButton);
        JButton deleteReservationButton = new JButton("Delete Reservation");
        deleteReservationButton.setSize(150,20);
        deleteReservationButton.setLocation(820,y);
        deleteReservationButton.addActionListener(e -> {
            mainView.removeReservation(reservation);
            mainView.changeViewToFindReservationView(reservation.getCustomer());
        });
        add(deleteReservationButton);
    }

    public void changeReservationList(ArrayList<Reservation> reservations)
    {
        removeAll();
        drawReservationsInformations(reservations);

    }
}
