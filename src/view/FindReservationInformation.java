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

    public FindReservationInformation()
    {

    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        drawReservationsInformations( g, reservations);
    }

    private void drawReservationsInformations(Graphics g, ArrayList<Reservation> reservations)
    {
        for (int i = 0; i < reservations.size(); i++)
        {
            drawReservation(g,reservations.get(i),20*i);
        }
    }

    private void drawReservation(Graphics g, Reservation reservation, int y)
    {
        g.drawString(reservation.getCustomer().getName(),10,y);
    }

    public void changeReservationList(ArrayList<Reservation> reservations)
    {
        this.reservations = reservations;
    }
}
