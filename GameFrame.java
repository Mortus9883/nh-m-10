/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flappybirdeasyver;

import static flappybirdeasyver.Method.record;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Windows 10
 */
public class GameFrame extends JFrame {
    public GameFrame() {
        int boardWidth = 360;
        int boardHeight = 640;
        setSize(boardWidth, boardHeight);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);

        FlappyBird flappyBird = new FlappyBird();
        
        add(flappyBird);
        pack();
        requestFocus();
        setVisible(true);
        pack();
    }

}
