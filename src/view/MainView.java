package view;

import controller.Controller;
import model.Show;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Olaleo on 01-12-2015.
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
        setSize( 600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(showView.getContentPane());
        pack();
        setVisible(true);
    }

    public void changeViewToShowView()
    {
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

    public void changeViewToFindReservationView()
    {
        setContentPane(findReservationView.getContentPane());
        pack();
        setVisible(true);
    }

    public ArrayList<Show> getShows()
    {
        return controller.getShows();
    }






}


