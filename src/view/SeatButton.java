package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by scavenius on 12/10/15.
 * A representation of a seat in the theater, through a JButton
 */
public class SeatButton extends JButton {

    private Color freeColor = Color.GREEN;
    private Color reservedColor = Color.RED;
    private Color selectedColor = Color.BLUE;

    private boolean isReserved;
    private boolean isSelected;

    private int[] place;

    public SeatButton(boolean isReserved, boolean isSelected) {

        super();

        this.isReserved = isReserved;
        this.isSelected = isSelected;

    }

    public SeatButton(String text, boolean isReserved, boolean isSelected) {

        super(text);

        this.isReserved = isReserved;
        this.isSelected = isSelected;

    }

    public SeatButton(boolean isReserved, boolean isSelected, int[] place)
    {
        this.isReserved = isReserved;
        this.isSelected = isSelected;
        this.place = place;
    }

    @Override
    public void paintComponent(Graphics graphics) {

        if (!isReserved && !isSelected) {

            setBackground(freeColor);

        } else if (isReserved) {

            setBackground(reservedColor);

        } else {

            setBackground(selectedColor);

        }

        graphics.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(graphics);

    }

    public void flipSelection() {

        if (!isReserved)
        {
            this.isSelected = !isSelected;
        }
    }

    public void flipReservation() {

        this.isReserved = !isReserved;

    }

    @Override
    public boolean isSelected()
    {
        return isSelected;
    }

    @Override
    public String toString(){
        return isReserved+","+isSelected+","+ place[0]+","+ place[1];
    }
    public int[] getPlace() {return place;}
}