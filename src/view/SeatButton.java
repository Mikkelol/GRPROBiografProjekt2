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

    @Override
    public void paintComponent(Graphics graphics) {

        if (!isReserved && !isSelected) {

            graphics.setColor(freeColor);

        } else if (isReserved) {

            graphics.setColor(reservedColor);

        } else {

            graphics.setColor(selectedColor);

        }

        graphics.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(graphics);

    }

    public void flipSelection() {

        this.isSelected = !isSelected;

    }

    public void flipReservation() {

        this.isReserved = !isReserved;

    }

}