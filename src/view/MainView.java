package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Olaleo on 01-12-2015.
 */
public class MainView extends JFrame
{
    private ReserveView reserveView;
    private ShowView showView;
    private FindReservationView findReservationView;

    public MainView(String title) throws HeadlessException
    {
        super(title);
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
        setVisible(true);
    }

    public void changeViewToShowView()
    {
        setContentPane(showView.getContentPane());
        pack();
        setVisible(true);
    }

    public void changeViewToReserveView()
    {
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






}


