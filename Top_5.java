/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userauthapp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Windows 10
 */
public class Top_5 extends JFrame implements ActionListener {
    JTextField ranktext;
    JTextArea Top5text;
    JButton backButton;
    String username;
    public Top_5() {
        setTitle("TOP 5");
        setSize(300, 150);
        JTextArea show=new JTextArea();
        Top5text.setEditable(false);
        JScrollPane scrollPane=new JScrollPane(Top5text);
        backButton=new JButton("Back");
        add(backButton);

        backButton.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        ArrayList<Top_5System> top5=new ArrayList<>();
        try(BufferedReader file=new BufferedReader(new FileReader("user.txt"))){
            Scanner sc=new Scanner(file);
            StringBuilder text2=new StringBuilder("Ranking\n");
            while(sc.hasNextLine()){
                String[] inForm=sc.nextLine().split(",");
                Double score=Double.parseDouble(inForm[2]);
                top5.add(new Top_5System(inForm[0],score));
            }
            Collections.sort(top5);
            int k=5;
            for(Top_5System i:top5){
                k--;
                if(k==0) break;
                text2.append(i).append("\n");
            }
            Top5text.setText(text2.toString());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RankingSystem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RankingSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        add(scrollPane,BorderLayout.CENTER);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            new RankingSystem();
            dispose();
        }
    }
}

