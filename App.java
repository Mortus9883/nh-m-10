/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flappybirdeasyver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Windows 10
 */
import javax.swing.*;

public class App {
    public static String n=null;
    public static void main(String[] args) throws Exception {
        int run=0;
        try {
            File file1=new File("D:\\rank.txt");
            if(file1.createNewFile()){
                System.out.println("ok");
            }
            else{
                System.out.println("hello");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file=new File("D:\\newfile.txt");
            if(file.createNewFile()){
                System.out.println("ok");
            }
            else{
                System.out.println("are you ready,enter your stupid name pls");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        FileWriter non=new FileWriter("D:\\rank.txt",true);
        BufferedReader q=new BufferedReader(new FileReader("D:\\rank.txt"));
        BufferedWriter v=new BufferedWriter(non);
        Scanner sc=new Scanner(System.in); 
        int access=Integer.parseInt(sc.nextLine());
        while(access==0){
        String name=sc.nextLine();
        String pass=sc.nextLine();
        boolean os=true;
        String s;
        String l;
        String read="D:\\newfile.txt";
        try {
            FileWriter writer=new FileWriter("D:\\newfile.txt",true);
            BufferedWriter b=new BufferedWriter(writer);
            BufferedReader r=new BufferedReader(new FileReader(read));
            while((s=r.readLine())!=null&&(l=r.readLine())!=null){
                    int ol=1;
                    String j;
                    while((j=q.readLine())!=null){
                        if(j.equals(name)){
                            ol=0;
                        }
                    }
                    if(ol==1){
                        v.write(name);
                        v.newLine();
                        v.write(String.valueOf(0.0));
                        v.newLine();
                    }
                if(s.equals(name)&& l.equals(pass)){
                    os=false;
                }
                else if(s.equals(name)&& !l.equals(pass)){
                    os=false;
                    System.out.println("seem someone faster than you,stupid");
                }
            }
            if(os==true){
                b.write(name);
                b.newLine();
                b.write(pass);
                b.newLine();
                access=1;
            }
            b.close();
        } catch (IOException ex) {
        }
        }
        int accesspass=0;
        v.close();
        while(accesspass==0){
        
        String fr="D:\\newfile.txt";
        try {
            n=sc.nextLine();
            String p=sc.nextLine();
            BufferedReader r=new BufferedReader(new FileReader(fr));
            String ok;
            String ok1;
            BufferedWriter b=new BufferedWriter(non);
            while((ok=r.readLine())!=null&& (ok1=r.readLine())!=null){
                if(ok.equals(n)&&ok1.equals(p)){

                    
                    System.out.println("access pass,you are getting less stupid");
                    run=1;
                    accesspass=1;
                    break;
                }
                else if(ok.equals(n)&& !ok1.equals(p)){
                    System.out.println("sorry,but you dumb,go die");
                }
                else{
                    System.out.println("sorry");
                }
            }
            System.out.println(run);
        } catch (Exception e) {
        }
        }
        if(run==1){
        int boardWidth = 360;
        int boardHeight = 640;
        rank player=new rank(n,0.0,0,"");
                rank.b.put(n,player);
        JFrame frame = new JFrame("Flappy Bird");
        // frame.setVisible(true);
		frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FlappyBird flappyBird = new FlappyBird();
        frame.add(flappyBird);
        frame.pack();
        flappyBird.requestFocus();
        frame.setVisible(true);
        String m;
        FileWriter lp=new FileWriter("D:\\rank.txt");
        BufferedReader lq=new BufferedReader(new FileReader("D:\\rank.txt"));
        BufferedWriter z=new BufferedWriter(lp);
    while((m=q.readLine())!=null){
        m=q.readLine();
        String c=q.readLine();
        rank player2=new rank(m,Double.parseDouble(c),0,"");
        rank.b.put(m,player2);
        rank.a.add(player2);
    }
    Collections.sort(rank.a);
    for(rank i:rank.a){
        z.write(i.getName());
        z.newLine();
        z.write(String.valueOf(i.getScore()));
        z.newLine();
    }
    z.close();
    }
    }
}