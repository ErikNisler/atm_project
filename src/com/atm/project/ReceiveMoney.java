package com.atm.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.atm.project.Overview.*;

public class ReceiveMoney implements ActionListener {

    private JFrame jFrame = new JFrame("Receive money");

    Integer CURRENT_CASH, X, Y = 0;
    static Integer RESULT;

    String USER;

    JLabel receivePersonLabel = new JLabel("From who?");
    JLabel cashLabel = new JLabel("How much?");

    JTextField receivePersonField = new JTextField();
    static JTextField cashField = new JTextField();

    JButton receiveMoney = new JButton("Receive");
    JButton cancel = new JButton("Cancel");

    public void showWindow(){
        jFrame.setSize(new Dimension(400, 50));
        jFrame.setMinimumSize(new Dimension(400, 180));
        jFrame.setLayout(null);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("ATM-sign.png");
        jFrame.setIconImage(icon.getImage());

        jFrame.add(receivePersonLabel);
        jFrame.add(cashLabel);
        jFrame.add(receivePersonField);
        jFrame.add(cashField);
        jFrame.add(receiveMoney);
        jFrame.add(cancel);

        receivePersonLabel.setBounds(10, 20, 200, 30);
        receivePersonLabel.setFont(new Font("Arial", Font.PLAIN, 15));

        cashLabel.setBounds(10, 60, 200, 30);
        cashLabel.setFont(new Font("Arial", Font.PLAIN, 15));

        receivePersonField.setBounds(100,24,80,20);
        cashField.setBounds(100,64,80,20);

        receiveMoney.setBounds(40, 100, 110, 30);
        receiveMoney.setFont(new Font("Arial", Font.CENTER_BASELINE, 12));
        receiveMoney.addActionListener(this);

        cancel.setBounds(220, 100, 110, 30);
        cancel.setFont(new Font("Arial", Font.CENTER_BASELINE, 12));
        cancel.addActionListener(this);
        cashField.setText("");
        receivePersonField.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == receiveMoney) {
            if (cashField.getText().isEmpty() || receivePersonField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(jFrame, "Fill in!",
                        "Error!", JOptionPane.ERROR_MESSAGE);
                cashField.setText("");
                receivePersonField.setText("");

            } else
                try {
                    USER = receivePersonField.getText();
                    CURRENT_CASH = Integer.parseInt(cashField.getText());

                        JOptionPane.showMessageDialog(jFrame, "Money received!",
                                "Info", JOptionPane.INFORMATION_MESSAGE);

                        transactionHistory.addToList(CURRENT_CASH + " was received by user " + USER);

                        cashField.setText("");
                        receivePersonField.setText("");

                        X = START_CASH;
                        Y = CURRENT_CASH;
                        RESULT = X + Y;
                        START_CASH = RESULT;
                        updateCashByReceive();

                        jFrame.dispose();

                } catch (NumberFormatException numberFormatException) {
                    JOptionPane.showMessageDialog(jFrame, "Input is not a number!",
                            "Error!", JOptionPane.ERROR_MESSAGE);
                }

        }
            if (e.getSource() == cancel) {
                jFrame.dispose();
            }


    }
}