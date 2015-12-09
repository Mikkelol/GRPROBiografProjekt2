package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Olaleo on 01-12-2015.
 */
public class MainView extends JFrame
{
    private ReserveView reserveView;
    private ShowView showView;

    public MainView(String title) throws HeadlessException
    {
        super(title);
        initialize();
    }


    public void initialize()
    {
        reserveView = new ReserveView();
        showView = new ShowView(this);
        setSize( 600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(showView);
        setVisible(true);
        //reserveView.addMainView(this);
        //reserveView.changeFilm("test");
    }

    public void changeView()
    {

        pack();
        setVisible(true);

    }



}


