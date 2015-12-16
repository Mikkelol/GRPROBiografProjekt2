package view;

import exceptions.CustomerException;
import model.Reservation;
import model.Show;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Olaleo on 10-12-2015.
 */
public class ReserveView extends JComponent {
    private MainView mainView;
    private JPanel contentPane;
    private JTextField nameField;
    private JTextField numberField;
    private JButton saveReservationButton;
    private JButton findReservationButton;
    private JButton cancelButton;
    private JLabel showNameJLabel;
    private JLabel showTimeJLabel;
    private JLabel showTheaterJLabel;
    private SeatMatrix seatMatrix1;
    private Show currentShow;
    public ArrayList<int[]> oldSeats;

    public ReserveView(MainView m) {
        mainView = m;
        $$$setupUI$$$();
        initialize();
    }

    public void changeShow(Show show) {
        seatMatrix1.changeShow(show);
        nameField.setText("Name");
        numberField.setText("Number");
        showNameJLabel.setText(show.getFilm());
        showTimeJLabel.setText(Integer.toString(show.getTime()));
        showTheaterJLabel.setText(show.getTheater().getIdentifier());
        currentShow = show;
    }

    public void changeShow(Show show, Reservation r) {
        seatMatrix1.changeShow(show, r);
        showNameJLabel.setText(show.getFilm());
        showTimeJLabel.setText(Integer.toString(show.getTime()));
        showTheaterJLabel.setText(show.getTheater().getIdentifier());
        nameField.setText(r.getCustomer().getName());
        numberField.setText(r.getCustomer().getNumber());
        currentShow = show;
    }

    public void initialize() {
        cancelButton.addActionListener(e -> {
            mainView.changeViewToShowView();
        });

        saveReservationButton.addActionListener(e -> {
            if (seatMatrix1.getSelected().size() > 0) {
                try {
                    String name = nameField.getText();
                    String number = numberField.getText();
                    ArrayList<int[]> selectedSeats = seatMatrix1.getSelected();
                    mainView.saveReservation(currentShow, name, number, selectedSeats);
                    mainView.changeViewToShowView();
                } catch (CustomerException e1) {
                    JOptionPane.showMessageDialog(getContentPane(), e1.getMessage());
                }
            }
        });
        findReservationButton.addActionListener(e -> {
            String name = nameField.getText();
            String number = numberField.getText();
            Show s = currentShow;
            Reservation r = mainView.findReservation(name, number, s);
            if (r != null) {
                mainView.changeViewToReserveView(s, r);
            } else {
                JOptionPane.showMessageDialog(mainView.getContentPane(), "Customer has not made a reservation. Check your spelling");
            }
        });
    }

    public JPanel getContentPane() {
        return contentPane;
    }

    private void createUIComponents() {
        seatMatrix1 = new SeatMatrix();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        contentPane = new JPanel();
        contentPane.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 5, new Insets(0, 0, 0, 0), -1, -1));
        showNameJLabel = new JLabel();
        showNameJLabel.setText("ShowName");
        contentPane.add(showNameJLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        showTimeJLabel = new JLabel();
        showTimeJLabel.setText("ShowTime");
        contentPane.add(showTimeJLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        showTheaterJLabel = new JLabel();
        showTheaterJLabel.setText("ShowTheater");
        contentPane.add(showTheaterJLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nameField = new JTextField();
        nameField.setText("Name");
        contentPane.add(nameField, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        numberField = new JTextField();
        numberField.setText("Number");
        contentPane.add(numberField, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        saveReservationButton = new JButton();
        saveReservationButton.setText("Save reservation");
        contentPane.add(saveReservationButton, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        findReservationButton = new JButton();
        findReservationButton.setText("Find Reservation");
        contentPane.add(findReservationButton, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cancelButton = new JButton();
        cancelButton.setText("Cancel");
        contentPane.add(cancelButton, new com.intellij.uiDesigner.core.GridConstraints(1, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Screen");
        contentPane.add(label1, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 5, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        contentPane.add(seatMatrix1, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 5, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }
}
