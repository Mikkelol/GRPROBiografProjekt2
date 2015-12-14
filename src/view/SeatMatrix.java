package view;

import model.Show;
import model.Theater;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Olaleo on 12-12-2015.
 */
public class SeatMatrix extends JComponent {

    private SeatButton[][] seatButtons;

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
        seatButtons = new SeatButton[theater.getSeats().length][theater.getSeats()[0].length];
        /*for (int i = 0; i < seatButtons.length; i++)
        {
            for (int j = 0; j < seatButtons[i].length; j++)
            {
                seatButtons[i][j] = new SeatButton(theater.getSpecificSeat(i,j),false);
                seatButtons[i][j].setSize(20,20);
                setLocation(10+i*20,10+j*20);
                seatButtons[i][j].setVisible(true);
                add(seatButtons[i][j]);
            }
        }*/

        for (int i = 0; i < theater.getSeats().length; i++)
        {
            for (int j = 0; j < theater.getSeats()[0].length; j++)
            {
                SeatButton seat = new SeatButton(false,false);
                seat.setSize(20,20);
                seat.setLocation(25*i,25*j);
                seat.addActionListener(e -> {
                    seat.flipSelection();
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
