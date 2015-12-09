package view;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Olaleo on 01-12-2015.
 */
public class ShowView extends JComponent
{
    JButton chooseShow;
    view.MainView mainView;

    public ShowView(view.MainView m)
    {
        mainView = m;


    }

    public void initialize()
    {
        chooseShow = new JButton("Show");
        chooseShow.setSize(100,100);
        chooseShow.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                mainView.changeView();
            }
        });
        add(chooseShow);
    }



}
