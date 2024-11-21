/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flappybirdeasyver;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

/**
 *
 * @author Windows 10
 */
class RegisterForm extends JFrame implements ActionListener {
    // Components for registration form
    JTextField firstNameField, lastNameField, usernameField, emailField, phoneField;
    JPasswordField passwordField;
    JButton registerButton, loginButton,systemButton;
    public static boolean run=false;

    RegisterForm() {

        setTitle("New User Register");
        setSize(400, 400);
        setLayout(new GridLayout(4,4,10,80));

        firstNameField = new JTextField(10);
        lastNameField = new JTextField(10);
        usernameField = new JTextField(10);
        emailField = new JTextField(10);
        phoneField = new JTextField(10);
        passwordField = new JPasswordField(10);

        registerButton = new JButton("Register");
        loginButton = new JButton("Login");
        systemButton=new JButton("Ranking");
        add(new JLabel("First Name:"));
        add(firstNameField);
        add(new JLabel("Last Name:"));
        add(lastNameField);
        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(new JLabel("Email Address:"));
        add(emailField);
        add(new JLabel("Mobile Number:"));
        add(phoneField);
        add(registerButton);
        add(loginButton);
        add(systemButton);

        registerButton.addActionListener(this);
        loginButton.addActionListener(this);
        systemButton.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            registerUser();
        } else if (e.getSource() == loginButton) {
            new LoginForm();
            dispose();
        } else if(e.getSource()== systemButton){
            new RankingSystem();
            dispose();
        }
    }
    private void registerUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "pls enter your privacy thing");
            return;
        }
        Double score=0.0;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
            writer.write(username + "," + password+","+score);
            writer.newLine();
            JOptionPane.showMessageDialog(this, "Register successfully");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Something got wrong,guess why");
        }
    }
}

