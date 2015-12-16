package view;

import exceptions.CustomerException;
import model.Customer;
import model.Reservation;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Olaleo on 10-12-2015.
 */
public class FindReservationView {
    private MainView mainView;
    private JPanel contentPane;
    private JTextField nameTextField;
    private JTextField numberTextField;
    private JButton findReservationButton;
    private FindReservationInformation findReservationInformation1;
    private JButton cancelButton;

    public FindReservationView(MainView mainView) {
        this.mainView = mainView;
        $$$setupUI$$$();
        findReservationButton.addActionListener(e -> {
            try {
                findReservationInformation1.changeReservationList(mainView.getReservationList(new Customer(nameTextField.getText(), numberTextField.getText())));
            } catch (CustomerException e1) {
                JOptionPane.showMessageDialog(mainView.getContentPane(), e1.getMessage());
            }
            mainView.changeViewToFindReservationView();
        });
        cancelButton.addActionListener(e -> {
            mainView.changeViewToShowView();
        });
    }


    public JPanel getContentPane() {
        return contentPane;
    }

    public void resetTextFields() {
        nameTextField.setText("Name");
        numberTextField.setText("Number");
    }

    public void resetFindReservationInformation() {
        findReservationInformation1.removeAll();
    }


    public void changeReservationList(ArrayList<Reservation> reservations) {
        findReservationInformation1.changeReservationList(reservations);

    }

    private void createUIComponents() {
        findReservationInformation1 = new FindReservationInformation(mainView);
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
        contentPane.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 4, new Insets(0, 0, 0, 0), -1, -1));
        nameTextField = new JTextField();
        nameTextField.setText("Name");
        contentPane.add(nameTextField, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        numberTextField = new JTextField();
        numberTextField.setText("Number");
        contentPane.add(numberTextField, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        findReservationButton = new JButton();
        findReservationButton.setText("Find Reservation");
        contentPane.add(findReservationButton, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        contentPane.add(findReservationInformation1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, new Dimension(1000, 300), null, null, 0, false));
        cancelButton = new JButton();
        cancelButton.setText("Cancel");
        contentPane.add(cancelButton, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }
}
