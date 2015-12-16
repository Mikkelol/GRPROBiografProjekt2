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

/* Method drawing the seatButtons in the reserve view. runs through every coordinate in the seat matrix of a Show's
   Theater if the coordinate is reserved it will be drawn red if its unreserved it will be drawn green. If a seat is
   in the ArrayList selected it will be drawn blue*/
    private void drawSeats(Theater theater)
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
                        });
                        add(seat);
            }
        }
    }

    //Method for selecting and deselecting buttons.
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

    //regular change show method draws the theater for the show without any selection made.
    public void changeShow(Show show)
    {
        selected = new ArrayList<>();
        drawSeats(show.getTheater());
    }
    /*changeShow method with a reservation adds a reservations seats to the selected array. Thereby making them selected
    * buttons instead of reserved buttons.*/
    public void changeShow(Show show, Reservation r)
    {
        selected = new ArrayList<int[]>();
        for(int[] i:r.getSeats()){
            selected.add(new int[]{i[0],i[1]});
        }
        drawSeats(show.getTheater());
    }
// two custom made equality confirming methods. Sinces there was problems with .equals and Array.equals.
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
