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
                int[] comparer = new int[]{i,j};

                SeatButton seat;
                if(compare(selected,comparer)){
                    seat = new SeatButton(false,true,new int[]{i,j});
                }
                else if (theater.getSeats()[i][j]&& !compare(selected,comparer))
                {
                    seat = new SeatButton(true, false, new int[]{i, j});
                }
                else
                {
                    seat = new SeatButton(false, false, new int[]{i, j});
                }
                        seat.setSize(20, 20);
                        seat.setLocation(25 * i, 25 * j);
                        seat.addActionListener(e -> {
                            seat.flipSelection();
                            updateSelected(seat);
                            System.out.println(selected.size());
                        });
                        add(seat);
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
        {
            if(selected.size()>0){
            boolean isFound = false;
            int k = 0;
            while (!isFound) {
                if (compare(selected.get(k), seat.getPlace())) {
                    selected.remove(k);
                    isFound = true;
                }
                if (k < selected.size()) {
                    k++;
                    if(k==selected.size()){break;}
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
        selected = r.getSeats();
        drawSeats(show.getTheater(),r);
    }

    public boolean compare(int[] a, int[] b)
    {
        if(a.length==b.length) {
            for (int i=0 ; i<a.length; i++) {
                if(a[i]!=b[i]) {
                    return false;
                }
            }
            return true;
        }
        else{return false;}

    }

    public boolean compare(ArrayList<int[]> a ,int[] b){
        for(int i =0;i<a.size();i++){
         if(compare(a.get(i),b)) {
                return true;
            }
        }
        return false;
    }

}
