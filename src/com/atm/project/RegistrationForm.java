package com.atm.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class RegistrationForm implements ActionListener {

    static Object inputCard;
    static String inputName;
    static int inputPin;
    static HashMap<Integer,String> userInfo = new HashMap<>();

    private JFrame jFrame = new JFrame("Registration");

    JLabel heading = new JLabel("Registration");
    JLabel cardno = new JLabel("Card no.");
    JLabel fullName = new JLabel("Fullname");
    JLabel pin = new JLabel("PIN");

    static JTextField cardnoField = new JTextField();
    static JTextField fullNameField = new JTextField();
    static JTextField pinField = new JTextField();

    JButton registration = new JButton("Registration");
    JButton cancel = new JButton("Cancel");

    public void setJFrame(){
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
        jFrame.add(cardnoField);
        jFrame.add(fullNameField);
        jFrame.add(pinField);
        /**adding buttons*/
        jFrame.add(registration);
        jFrame.add(cancel);

        /**setting labels*/
        heading.setBounds(120,40,200,30);
        heading.setFont(new Font("Arial", Font.PLAIN, 30));

        cardno.setBounds(50,100,200,30);
        cardno.setFont(new Font("Arial", Font.PLAIN, 15));

        fullName.setBounds(50,130,200,30);
        fullName.setFont(new Font("Arial", Font.PLAIN, 15));

        pin.setBounds(50,160,200,30);
        pin.setFont(new Font("Arial", Font.PLAIN, 15));

        /**setting textfields*/
        cardnoField.setBounds(110,105,200,20);
        fullNameField.setBounds(110,135,200,20);
        pinField.setBounds(110,165,200,20);

        registration.setBounds(50,200,110,30);
        registration.setFont(new Font("Arial", Font.CENTER_BASELINE, 12));
        registration.addActionListener(this);

        cancel.setBounds(200,200,110,30);
        cancel.setFont(new Font("Arial", Font.CENTER_BASELINE, 12));
        cancel.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registration){
            try {
                    inputPin = Integer.parseInt(pinField.getText());
                    inputName = fullNameField.getText();
                    inputCard = cardnoField.getText();
                    userInfo.put(inputPin,inputName);

                if (cardnoField.getText().isEmpty() || fullNameField.getText().isEmpty() || pinField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(jFrame, "Fill in!",
                            "Error!", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    jFrame.dispose();
                    LoginForm loginForm = new LoginForm();
                    loginForm.setjFrame();
                    System.out.println(userInfo.toString());
                }
            }
            catch (NumberFormatException n){
                userInfo.clear();
                JOptionPane.showMessageDialog(jFrame, "Invalid format!",
                        "Error!", JOptionPane.ERROR_MESSAGE);
            }

        } if (e.getSource() == cancel){
            jFrame.dispose();
        }
    }
}
