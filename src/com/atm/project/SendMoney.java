package com.atm.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.atm.project.Overview.*;

public class SendMoney implements ActionListener{
    private JFrame jFrame = new JFrame("Send money");

    static Integer RESULT;

    Integer CURRENT_CASH, X, Y = 0;

    String USER;

    JLabel personToSendLabel = new JLabel("Who?");
    JLabel cashLabel = new JLabel("How much?");

    JTextField personToSendField = new JTextField();
    JTextField cashField = new JTextField();

    JButton sendMoney = new JButton("Send");
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

        jFrame.add(personToSendLabel);
        jFrame.add(cashLabel);
        jFrame.add(personToSendField);
        jFrame.add(cashField);
        jFrame.add(sendMoney);
        jFrame.add(cancel);

        personToSendLabel.setBounds(10, 20, 200, 30);
        personToSendLabel.setFont(new Font("Arial", Font.PLAIN, 15));

        cashLabel.setBounds(10, 60, 200, 30);
        cashLabel.setFont(new Font("Arial", Font.PLAIN, 15));

        personToSendField.setBounds(100,24,80,20);
        cashField.setBounds(100,64,80,20);

        sendMoney.setBounds(40, 100, 110, 30);
        sendMoney.setFont(new Font("Arial", Font.CENTER_BASELINE, 12));
        sendMoney.addActionListener(this);

        cancel.setBounds(220, 100, 110, 30);
        cancel.setFont(new Font("Arial", Font.CENTER_BASELINE, 12));
        cancel.addActionListener(this);
        cashField.setText("");
        personToSendField.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sendMoney) {
                if (cashField.getText().isEmpty() || personToSendField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(jFrame, "Fill in!",
                            "Error!", JOptionPane.ERROR_MESSAGE);
                    cashField.setText("");
                    personToSendField.setText("");

                } else
                    try {
                    USER = personToSendField.getText();
                    CURRENT_CASH = Integer.parseInt(cashField.getText());

                if (CURRENT_CASH > START_CASH) {
                    JOptionPane.showMessageDialog(jFrame, "You can't send cash you don't have!",
                            "Not enough cash!", JOptionPane.ERROR_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(jFrame, "Money send!",
                            "Info", JOptionPane.INFORMATION_MESSAGE);
                    transactionHistory.addToList(CURRENT_CASH + " was sent to user " + USER);

                    cashField.setText("");
                    personToSendField.setText("");

                    X = START_CASH;
                    Y = CURRENT_CASH;
                    RESULT = X - Y;
                    START_CASH = RESULT;
                    updateCashBySend();

                    jFrame.dispose();
                }
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
