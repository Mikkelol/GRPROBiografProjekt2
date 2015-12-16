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
    }

    public void drawShow(Show show,int x, int y)
    {
        JLabel filmNameJLabel = new JLabel(show.getFilm());
        filmNameJLabel.setSize(100,20);
        filmNameJLabel.setLocation(x,y);
        add(filmNameJLabel);
        JLabel filmTimeJLabel = new JLabel(Integer.toString(show.getTime()));
        filmTimeJLabel.setSize(100,20);
        filmTimeJLabel.setLocation(x+170,y);
        add(filmTimeJLabel);
        JLabel filmTheaterJLabel = new JLabel(show.getTheater().getIdentifier());
        filmTheaterJLabel.setSize(100,20);
        filmTheaterJLabel.setLocation(x+220,y);
        add(filmTheaterJLabel);


        JButton button = new JButton("Pick Show");
        button.setSize(100,20);
        button.setLocation(300, y);
        button.setVisible(true);
        button.addActionListener(e -> {
            mainView.changeViewToReserveView(show);
        });
        add(button);

    }

    public void drawDate( String date, int x, int y)
    {
        JLabel dateJLabel = new JLabel(date);
        dateJLabel.setSize(100,20);
        dateJLabel.setLocation(x,y);
        add(dateJLabel);
        JSeparator lineJSeparator = new JSeparator(SwingConstants.HORIZONTAL);
        lineJSeparator.setSize(300,1);
        lineJSeparator.setLocation(x,y + 20);
        add(lineJSeparator);



        //g.drawLine( x, y + 3, x + 400, y + 3);
    }

    public void drawColumnNames( int x, int y)
    {
        JLabel filmJLabel = new JLabel("film");
        filmJLabel.setSize(100,20);
        filmJLabel.setLocation(x,y);
        add(filmJLabel);
        JLabel timeJLabel = new JLabel("Time");
        timeJLabel.setSize(100,20);
        timeJLabel.setLocation( x + 170,y);
        add(timeJLabel);
        JLabel theaterJLabel = new JLabel("Theater");
        theaterJLabel.setSize(100,20);
        theaterJLabel.setLocation( x + 220,y);
        add(theaterJLabel);



    }

    public void changeShowList(ArrayList<Show> shows)
    {
        drawShows(shows);
    }

    /*draws the shows. A line with a date above followed by all shows on that date, a show is represented by its film,
    * time, Theater and a pick show button*/
    private void drawShows(ArrayList<Show> shows)
    {

        removeAll();

        int q = 0;

        for (int i = 0; i < shows.size(); i++)
        {
            if (shows.get(i).equals(shows.get(0)))
            {
                drawColumnNames( 15 ,  20 * q);
                q++;
                drawDate( shows.get(i).getDate(), 10, 20 * q);
                q++;
            }
            else if (!shows.get(i).getDate().equals(shows.get(i-1).getDate()))
            {
                drawDate( shows.get(i).getDate(), 10, 20 * q);
                q++;
            }

            drawShow( shows.get(i), 15,  20 * q);
            q++;
        }
        setMinimumSize(new Dimension(410, q*20 + 10));
    }


    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
    }

}
