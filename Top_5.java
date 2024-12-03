/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flappybirdeasyver;

import static flappybirdeasyver.Method.recordModifier;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
    public Top_5() throws IOException {
        setTitle("TOP 5");
        setSize(400, 400);
        setLayout(new GridLayout(3,1));
        Top5text=new JTextArea();
        Top5text.setEditable(false);
        JScrollPane scrollPane=new JScrollPane();
        scrollPane.setViewportView(Top5text);
        backButton=new JButton("Back");

        backButton.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        ArrayList<Top_5System> top5=new ArrayList<>();
        try(BufferedReader file=new BufferedReader(new FileReader("users.txt"))){
            String line;
            StringBuilder text2 =new StringBuilder();
            while ((line = file.readLine()) != null) {
                String[] inForm = line.split(",");
                Double score = Double.parseDouble(inForm[2]);
                 top5.add(new Top_5System(inForm[0],score,inForm[0],inForm[1],score));
            }
            Collections.sort(top5);
            int k=5;
            int Medal=0;
            for(Top_5System i:top5){
                i.getMedal();
                int placeForM=5;
                int LengthUser=placeForM-i.getUser().length();
                String space="";
                for(int j=0;j<LengthUser;j++){
                    space+=" ";
                }
                k--;
                Medal++;
                if(k==0) break;
                text2.append(i+space+Medal).append("\n");
            }
            Top5text.setText(text2.toString());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RankingSystem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RankingSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        try(FileOutputStream medal=new FileOutputStream("ranking.txt",true)){
            for(Top_5System j:top5){
                String Record=j+" "+j.getMedal();
                medal.write(Record.getBytes());
                medal.write(System.lineSeparator().getBytes());
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Top_5.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(RankingSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        add(scrollPane,BorderLayout.CENTER);
        add(backButton);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            new RankingSystem();
            dispose();
        }
    }
}
