package view;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Olaleo on 01-12-2015.
 */
public class ReserveViewOld extends JComponent
{
    JButton saveReservation;
    JTextField name, number;
    JTextArea film;


    public ReserveViewOld()
    {

        saveReservation = new JButton("Reserve");
        saveReservation.setSize(100,100);
        //add(saveReservation);
        nameInit();
        numberInit();
        filmInit();



        setVisible(true);

    }

    public void nameInit()
    {
        name = new JTextField();
        name.setSize(150,30);
        name.setLocation(10,50);
        add(name);
    }

    public void numberInit()
    {
        number = new JTextField();
        number.setLocation(170,50);
        number.setSize(150, 30);
        add(number);
    }

    public void filmInit()
    {
        this.film = new JTextArea();
        this.film.setLocation(10,10);
        add(this.film);

    }

    public void changeFilm(String film)
    {
        this.film.setText(film);
        this.film.setSize(100, 20);
        //this.film.setColo(Color.gray);
        add(this.film);
    }




}
