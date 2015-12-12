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
        g.drawString( Integer.toString(show.getTime()), 180, y);
        g.drawString( show.getTheater().getIdentifier(),230,y);
        JButton button = new JButton("Pick show");
        button.setSize(100,20);
        button.setLocation(300, y - 15);
        button.setVisible(true);
        //button.paintImmediately(200,y,20,20);
        add(button);
        //button.paintImmediately(200,y,20,20);

        //show.getFilm().length();
        //150

    }

    public void drawDate(Graphics g, String date, int x, int y)
    {
        g.drawString( date, x, y);

    }

    public void drawShows(ArrayList<Show> shows,Graphics g)
    {
        int q = 0;

        for (int i = 0; i < shows.size(); i++)
        {
            if (shows.get(i).equals(shows.get(0)))
            {
                drawDate( g, shows.get(i).getDate(), 10, 10 + 50 * q);
                q++;
            }
            else if (!shows.get(i).getDate().equals(shows.get(i-1).getDate()))
            {
                drawDate( g, shows.get(i).getDate(), 10, 10 + 20 * q);
                q++;
            }

            drawShow( shows.get(i), g, 15, 10 + 20 * q);
            q++;
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
