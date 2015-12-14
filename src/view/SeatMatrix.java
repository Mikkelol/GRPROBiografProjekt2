package view;

import model.Show;
import model.Theater;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Olaleo on 12-12-2015.
 */
public class SeatMatrix extends JComponent {





    public SeatMatrix()
    {

    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        //seatButton = new SeatButton(true,false);
        //seatButton.setSize(20,20);
        //add(seatButton);
    }

    public void drawSeats(Theater theater)
    {
        setMinimumSize(new Dimension(25*theater.getSeats().length,25*theater.getSeats()[0].length));
        for (int i = 0; i < theater.getSeats().length; i++)
        {
            for (int j = 0; j < theater.getSeats()[0].length; j++)
            {
                SeatButton seat = new SeatButton(false,false);
                seat.setSize(20,20);
                seat.setLocation( 25 * i, 25 * j );
                seat.addActionListener(e -> {
                    seat.flipSelection();
                    repaint();
                });
                add(seat);
            }
        }
    }

    public void changeShow(Show show)
    {
        drawSeats(show.getTheater());
    }
}
