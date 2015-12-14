package view;

import model.Reservation;
import model.Show;
import model.Theater;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Olaleo on 12-12-2015.
 */
public class SeatMatrix extends JComponent {

    private ArrayList<int[]> selected;

    public SeatMatrix()
    {
        selected = new ArrayList<>();

    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
    }

    private void drawSeats(Theater theater)
    {
        removeAll();

        //setMinimumSize(new Dimension(25*theater.getSeats().length,25*theater.getSeats()[0].length));
        for (int i = 0; i < theater.getSeats().length; i++)
        {
            for (int j = 0; j < theater.getSeats()[0].length; j++)
            {
                SeatButton seat;
                if (theater.getSeats()[i][j])
                {
                    seat = new SeatButton(true,false, new int[]{i,j});
                }
                else
                {
                    seat = new SeatButton(false,false, new int[]{i,j});
                }
                seat.setSize(20,20);
                seat.setLocation( 25 * i, 25 * j );
                seat.addActionListener(e -> {
                    seat.flipSelection();
                    updateSelected(seat);
                });
                add(seat);
            }
        }
    }

    private void drawSeats(Theater theater, Reservation r)
    {
        removeAll();


        for (int i = 0; i < theater.getSeats().length; i++)
        {
            for (int j = 0; j < theater.getSeats()[0].length; j++)
            {

                ArrayList<int[]> selectReservations = r.getSeats();
                int[] comparer = new int[]{i,j};
                    for(int k=0; k<selectReservations.size()-1;k++) {
                        SeatButton seat;
                        if (selectReservations.get(k) == comparer) {
                            seat = new SeatButton(false, true, new int[]{i, j});

                        } else if (theater.getSeats()[i][j]&& selectReservations.get(k) != comparer ) {
                            seat = new SeatButton(true, false, new int[]{i, j});
                        } else {
                            seat = new SeatButton(false, false, new int[]{i, j});
                        }
                        seat.setSize(20, 20);
                        seat.setLocation(25 * i, 25 * j);
                        seat.addActionListener(e -> {
                            seat.flipSelection();
                            updateSelected(seat);
                        });
                        add(seat);
                    }
            }
        }
    }

    private void updateSelected(SeatButton seat)
    {
        if (seat.isSelected())
        {
            selected.add( seat.getPlace());
        }
        else if (!seat.isSelected())
        {   if(selected.size()>0){
            boolean isFound = false;
            int k = 0;
            while (!isFound) {
                if (selected.get(k) == seat.getPlace()) {
                    selected.remove(k);
                    isFound = true;
                }
                if (k < selected.size() - 1) {
                    k++;
                } else {
                    break;
                }
            }
            }
        }
    }

    public ArrayList<int[]> getSelected()
    {
        return selected;
    }

    public void changeShow(Show show)
    {
        selected = new ArrayList<>();
        drawSeats(show.getTheater());
    }
    public void changeShow(Show show, Reservation r)
    {
        selected = new ArrayList<>();
        drawSeats(show.getTheater(),r);
    }
}
