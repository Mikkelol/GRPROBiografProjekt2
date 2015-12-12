package view;

import model.Show;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Olaleo on 10-12-2015.
 */
public class ShowInformation extends JComponent{

    private MainView mainView;
    private JLabel test;

    public ShowInformation(MainView mainView)
    {
        this.mainView = mainView;
        ArrayList<Show> shows= mainView.getShows();
        //JLabel nameJLabel = new JLabel(shows.get(0).getFilm());
        //System.out.println(mainView.getShows().get(0).getFilm());
    }

    public void drawShow(Show show, Graphics g,int x, int y)
    {


        g.drawString(show.getFilm(),x,y);

    }

    public void drawDate(Graphics g, String date, int x, int y)
    {
        g.drawString( date, x, y);
    }

    public void drawShows(ArrayList<Show> shows,Graphics g)
    {
        int q = 0;

        for (Show s: shows)
        {
            if (s.equals(shows.get(0)))
            {
                drawDate( g, s.getDate(), 10, 10 + 15 * q);
            }
        }




        /*for (int i = 0; i < shows.size(); i++)
        {
            drawShow(shows.get(i), g, 10, 10 + 15 * i);
        }*/



    }


    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        drawShows(mainView.getShows(),g);
    }
}
