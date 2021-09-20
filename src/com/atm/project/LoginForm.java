package com.atm.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends RegistrationForm implements ActionListener {

    private JFrame jFrame = new JFrame("Login");

    JLabel heading = new JLabel("Login");
    JLabel fullName = new JLabel("Fullname");
    JLabel pin = new JLabel("PIN");

    JButton registration = new JButton("Login");
    JButton cancel = new JButton("Cancel");

    public void setjFrame(){
        jFrame.setSize(new Dimension(400, 290));
        jFrame.setMinimumSize(new Dimension(400, 290));
        jFrame.setLayout(null);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("ATM-sign.png");
        jFrame.setIconImage(icon.getImage());


        /**adding labels*/
        jFrame.add(heading);
        jFrame.add(cardno);
        jFrame.add(fullName);
        jFrame.add(pin);
        /**adding textfields*/
        jFrame.add(fullNameField);
        jFrame.add(pinField);
        /**adding buttons*/
        jFrame.add(registration);
        jFrame.add(cancel);

        /**setting labels*/
        heading.setBounds(120,40,200,30);
        heading.setFont(new Font("Arial", Font.PLAIN, 30));

        fullName.setBounds(50,130,200,30);
        fullName.setFont(new Font("Arial", Font.PLAIN, 15));

        pin.setBounds(50,160,200,30);
        pin.setFont(new Font("Arial", Font.PLAIN, 15));

        /**setting textfields*/
        fullNameField.setBounds(110,135,200,20);
        pinField.setBounds(110,165,200,20);

        fullNameField.setText("");
        pinField.setText("");

        registration.setBounds(50,200,110,30);
        registration.setFont(new Font("Arial", Font.CENTER_BASELINE, 12));
        registration.addActionListener(this);

        cancel.setBounds(200,200,110,30);
        cancel.setFont(new Font("Arial", Font.CENTER_BASELINE, 12));
        cancel.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /**hashmap userInfo is filled*/
        if (e.getSource() == registration) {
            if (cardnoField.getText().isEmpty() || fullNameField.getText().isEmpty() || pinField.getText().isEmpty()){
                JOptionPane.showMessageDialog(jFrame, "Fill in!",
                        "Error!", JOptionPane.ERROR_MESSAGE);
                pinField.setText("");
                fullNameField.setText("");
            }
            if (userInfo.containsValue(fullNameField.getText()) && userInfo.containsKey(Integer.parseInt(pinField.getText()))){
                jFrame.dispose();
                Overview overview = new Overview();
                overview.setJFrame();
            } else {
                JOptionPane.showMessageDialog(jFrame, "Invalid statement!",
                        "Error!", JOptionPane.ERROR_MESSAGE);
                pinField.setText("");
                fullNameField.setText("");
            }
        }
        if (e.getSource() == cancel){
            jFrame.dispose();
        }
    }
}
