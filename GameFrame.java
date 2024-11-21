/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flappybirdeasyver;

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
    }
    
}
