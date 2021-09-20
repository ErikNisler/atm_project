package com.atm.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Overview extends LoginForm{

    static TransactionHistory transactionHistory = new TransactionHistory();

    private JFrame jFrame = new JFrame("Overview");

    static Integer START_CASH = 10000;
    static Integer UPDATE_CASH = 0;

    JLabel heading = new JLabel("Overview");
    JLabel fullName = new JLabel("Fullname");
    JLabel cashLabel = new JLabel("Cash");

    JButton sendMoneyButton = new JButton("Send money");
    JButton receiveMoneyButton = new JButton("Receive money");
    JButton transactionHistoryButton = new JButton("Transaction history");
    JButton saveHistoryButton = new JButton("Save to file");

    static JLabel currentCashLabel = new JLabel(String.valueOf(START_CASH));

    @Override
    public void setJFrame() {
        jFrame.setSize(new Dimension(600, 490));
        jFrame.setMinimumSize(new Dimension(400, 290));
        jFrame.setLayout(null);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("ATM-sign.png");
        jFrame.setIconImage(icon.getImage());

        JLabel infoCardLabel = new JLabel(String.valueOf(inputCard));
        JLabel infoNameLabel = new JLabel(inputName);


        /**adding labels*/
        jFrame.add(heading);
        jFrame.add(cardno);
        jFrame.add(fullName);
        jFrame.add(pin);
        jFrame.add(infoCardLabel);
        jFrame.add(infoNameLabel);
        jFrame.add(sendMoneyButton);
        jFrame.add(receiveMoneyButton);
        jFrame.add(transactionHistoryButton);
        jFrame.add(saveHistoryButton);
        jFrame.add(cashLabel);
        jFrame.add(currentCashLabel);

        /**adding buttons*/

        infoCardLabel.setBounds(100, 60, 200, 30);
        infoCardLabel.setFont(new Font("Arial", Font.PLAIN, 15));

        infoNameLabel.setBounds(100, 90, 200, 30);
        infoNameLabel.setFont(new Font("Arial", Font.PLAIN, 15));

        /**setting labels*/
        heading.setBounds(20, 20, 200, 30);
        heading.setFont(new Font("Arial", Font.PLAIN, 30));

        cardno.setBounds(20, 60, 200, 30);
        cardno.setFont(new Font("Arial", Font.PLAIN, 15));

        fullName.setBounds(20, 90, 200, 30);
        fullName.setFont(new Font("Arial", Font.PLAIN, 15));

        sendMoneyButton.setBounds(20, 190, 150, 30);
        sendMoneyButton.setFont(new Font("Arial", Font.CENTER_BASELINE, 12));
        sendMoneyButton.addActionListener(this);

        receiveMoneyButton.setBounds(20, 230, 150, 30);
        receiveMoneyButton.setFont(new Font("Arial", Font.CENTER_BASELINE, 12));
        receiveMoneyButton.addActionListener(this);

        transactionHistoryButton.setBounds(20, 270, 150, 30);
        transactionHistoryButton.setFont(new Font("Arial", Font.CENTER_BASELINE, 12));
        transactionHistoryButton.addActionListener(this);

        saveHistoryButton.setBounds(20, 310, 150, 30);
        saveHistoryButton.setFont(new Font("Arial", Font.CENTER_BASELINE, 12));
        saveHistoryButton.addActionListener(this);

        cashLabel.setBounds(20, 140, 200, 30);
        cashLabel.setFont(new Font("Arial", Font.PLAIN, 15));

        currentCashLabel.setBounds(70, 140, 200, 30);
        currentCashLabel.setFont(new Font("Arial", Font.PLAIN, 30));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sendMoneyButton) {
            SendMoney sendMoney = new SendMoney();
            sendMoney.showWindow();
        }
        if (e.getSource() == receiveMoneyButton){
            ReceiveMoney receiveMoney = new ReceiveMoney();
            receiveMoney.showWindow();
        }
        if (e.getSource() == transactionHistoryButton){
            transactionHistory.extractAll();
        }
        if (e.getSource() == saveHistoryButton){
            transactionHistory.saveToFile("output.txt");
        }
    }

    static void updateCashBySend(){
        UPDATE_CASH = SendMoney.RESULT;
        currentCashLabel.setText(String.valueOf(UPDATE_CASH));
    }

    static void updateCashByReceive(){
        UPDATE_CASH = ReceiveMoney.RESULT;
        currentCashLabel.setText(String.valueOf(UPDATE_CASH));

    }


}
