/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userauthapp;

import java.util.logging.Logger;

/**
 *
 * @author Windows 10
 */
public class Top_5System implements Comparable<Top_5System> {
    private String user;
    private String password;
    private Double score;

    public Top_5System(String user,Double score) {
        this.user = user;
        this.password = password;
        this.score = score;
    }
    @Override
    public int compareTo(Top_5System x){
        return this.score.compareTo(x.score);
    }
    @Override
    public String toString(){
        return user+" "+score;
    }
}
