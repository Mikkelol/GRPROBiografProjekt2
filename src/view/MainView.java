package view;

import controller.Controller;
import exceptions.CustomerException;
import model.Customer;
import model.Reservation;
import model.Show;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Olaleo on 01-12-2015.
 * the Class in charge of switching between different views and communicating with the controller.
 */
public class MainView extends JFrame
{
    private ReserveView reserveView;
    private ShowView showView;
    private FindReservationView findReservationView;
    private Controller controller;

    public MainView(String title, Controller controller) throws HeadlessException
    {
        super(title);
        this.controller = controller;
        initialize();
    }


    public void initialize()
    {
        reserveView = new ReserveView(this);
        showView = new ShowView(this);
        findReservationView = new FindReservationView(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        changeViewToShowView();
    }

    public void changeViewToShowView()
    {
        showView.changeShowList(controller.getShows());
        setContentPane(showView.getContentPane());
        pack();
        setVisible(true);
    }

    public void changeViewToReserveView(Show show)
    {
        reserveView.changeShow(show);
        setContentPane(reserveView.getContentPane());
        pack();
        setVisible(true);
    }

    public void changeViewToReserveView(Show show, Reservation r)
    {
        reserveView.changeShow(show,r);
        setContentPane(reserveView.getContentPane());
        pack();
        setVisible(true);
    }

    public void changeViewToFindReservationView()
    {
        findReservationView.resetTextFields();
        setContentPane(findReservationView.getContentPane());
        pack();
        setVisible(true);
    }

    public void changeViewToFindReservationView(Customer customer)
    {
        findReservationView.resetTextFields();
        findReservationView.changeReservationList(getReservationList(customer));
        setContentPane(findReservationView.getContentPane());
        pack();
        setVisible(true);
    }

    public void resetFindReservationView()
    {
        findReservationView.resetFindReservationInformation();
    }

    public ArrayList<Reservation> getReservationList(Customer customer)
    {
        return controller.getReservationList(customer);
    }

    public ArrayList<Show> getShows()
    {
        return controller.getShows();
    }
    //passes on the save method call to controller
    public void saveReservation (Show s, String name, String number,ArrayList<int[]> selectedSeats) throws CustomerException
    {

            controller.saveReservation(s, name, number, selectedSeats);


    }


    // creates a customer so it can pass on the find reservation mothod call
    public Reservation findReservation(String name, String number, Show s) {

        try {
            Customer c = new Customer(name,number);
        return controller.findReservation(c,s);
        }

        catch(CustomerException e){
            return null;
        }
    }

    public void removeReservation(Reservation reservation)
    {
        controller.removeReservation(reservation);
    }
}


