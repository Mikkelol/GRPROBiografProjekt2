package view;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Olaleo on 01-12-2015.
 */
public class ShowViewOld extends JComponent
{
    private JButton chooseShow;
    private MainView mainView;

    public ShowViewOld(view.MainView m)
    {
        mainView = m;
        initialize();



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
                //mainView.changeView();
            }
        });
        add(chooseShow);
    }



}
