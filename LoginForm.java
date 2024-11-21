/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flappybirdeasyver;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Windows 10
 */
class LoginForm extends JFrame implements ActionListener {
    static JTextField usernameField;
    static JPasswordField passwordField;
    JButton loginButton;
    public String password;
    public LoginForm() {
        setTitle("Login");
        setSize(300, 150);
        setLayout(new GridLayout(3, 2));


        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");

        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(loginButton);

        loginButton.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (User(username, password)) {
            JOptionPane.showMessageDialog(this, "Success login");
            RegisterForm.run=true;
            if(RegisterForm.run==true){
                try(BufferedReader Player = new BufferedReader(new FileReader("users.txt"))){
                    String PInfor;
                    while((PInfor=Player.readLine())!=null){
                        String[] Infor=PInfor.split(",");
                        Method.recordModifier.put(Infor[0],new AccountRecord(Infor[0],Infor[1],Double.parseDouble(Infor[2])));
                    }
                } catch (IOException ex) {
                    Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                new GameFrame();
                dispose();
            }   
        } else {
            JOptionPane.showMessageDialog(this, "User not exist");
        }
    }

    private boolean User(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(",");
                System.out.println(userDetails.length);
                if (userDetails[0].equals(username) && userDetails[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error during login.");
        }
        return false;
    }
}