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
        test = new JLabel("lel");
        test.setSize(100,10);
        ArrayList<Show> shows= mainView.getShows();
        //JLabel nameJLabel = new JLabel(shows.get(0).getFilm());
        //System.out.println(mainView.getShows().get(0).getFilm());
    }

    public void drawShow(Show show, Graphics g,int x, int y)
    {
        g.drawString(show.getFilm(),x,y);
        System.out.println(show.getFilm());
        JLabel jLabel = new JLabel(show.getFilm());
        jLabel.setLocation(x,y);
        jLabel.paint(g);
    }

    public void drawShows(ArrayList<Show> shows,Graphics g)
    {
        for (Show s: shows)
        {
            drawShow(s, g, 100, 100);
        }
    }



    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        //test.paint(g);
        drawShows(mainView.getShows(),g);
    }
}
