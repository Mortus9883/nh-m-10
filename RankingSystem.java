/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userauthapp;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Windows 10
 */
public class RankingSystem extends JFrame implements ActionListener {
    JTextField ranktext;
    JTextArea show;
    JButton top5,backButton;
    public RankingSystem() {
        setTitle("Ranking");
        setSize(300, 150);
        JTextArea show=new JTextArea();
        show.setEditable(false);
        JScrollPane scrollPane=new JScrollPane(show);
        
        
        
        top5=new JButton("TOP 5");
        backButton=new JButton("Back");
        add(backButton);
        add(top5);

        top5.addActionListener(this);
        backButton.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        try(BufferedReader file=new BufferedReader(new FileReader("user.txt"))){
            String line;
            
            StringBuilder text=new StringBuilder("Ranking\n");
            while ((line = file.readLine()) != null){
                String[] inForm=line.split(",");
                text.append(inForm[2]).append("\n");
            }
            show.setText(text.toString());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RankingSystem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RankingSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        add(scrollPane,BorderLayout.CENTER);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == top5) {
            new Top_5();
            dispose();
        } else if(e.getSource()== backButton){
            new RegisterForm();
            dispose();
        }
    }
}
