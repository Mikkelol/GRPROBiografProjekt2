import controller.Controller;
import exceptions.IllegalTimeAndDateFormatException;
import exceptions.TheaterSizeException;
import view.*;

import javax.swing.*;
import java.sql.SQLException;

/**
 * Created by Olaleo on 01-12-2015.
 */
public class Main {
    public static void main(String[] args)
    {
        try
        {
            new MainView("EasyBook", new Controller());
        }
        catch (TheaterSizeException e)
        {
            JOptionPane.showMessageDialog(new JFrame(),e.getMessage());
            System.out.println(e.getStackTrace());
            System.exit(0);
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(new JFrame(),"Something went wrong with the database");
            System.out.println(e.getStackTrace());
            System.exit(0);
        }
        catch (IllegalTimeAndDateFormatException e)
        {
            JOptionPane.showMessageDialog(new JFrame(),e.getMessage());
            System.out.println(e.getStackTrace());
            System.exit(0);
        }


    }
}
