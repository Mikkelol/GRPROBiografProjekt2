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

    }

    public void drawShow(Show show, Graphics g,int x, int y)
    {
        g.drawString(show.getFilm(),x,y);
        g.drawString( Integer.toString(show.getTime()), x + 170, y);
        g.drawString( show.getTheater().getIdentifier(),x + 220,y);
        JButton button = new JButton("Pick Show");
        button.setSize(100,20);
        button.setLocation(300, y - 15);
        button.setVisible(true);
        button.addActionListener(e -> {
            mainView.changeViewToReserveView(show);
        });
        add(button);

    }

    public void drawDate(Graphics g, String date, int x, int y)
    {
        g.drawString( date, x, y);
        g.drawLine( x, y + 3, x + 400, y + 3);
    }

    public void drawColumnNames(Graphics g, int x, int y)
    {
        g.drawString( "Film", x , y);
        g.drawString( "Time", x + 170, y);
        g.drawString( "Theater", x + 220, y);
    }
    /*draws the shows. A line with a date above followed by all shows on that date, a show is represented by its film,
    * time, Theater and a pick show button*/
    public void drawShows(ArrayList<Show> shows,Graphics g)
    {
        int q = 0;

        for (int i = 0; i < shows.size(); i++)
        {
            if (shows.get(i).equals(shows.get(0)))
            {
                drawColumnNames( g, 15 , 10 + 20 * q);
                q++;
                drawDate( g, shows.get(i).getDate(), 10, 10 + 20 * q);
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
    }


    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        drawShows(mainView.getShows(),g);
    }
}
