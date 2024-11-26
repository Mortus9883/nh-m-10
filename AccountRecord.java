/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flappybirdeasyver;

import java.util.ArrayList;

/**
 *
 * @author Windows 10
 */
public class AccountRecord {
    private String Username,Password;
    private Double Score;

    public AccountRecord(String Username, String Password, Double Score) {
        this.Username = Username;
        this.Password = Password;
        this.Score = Score;
    }

    public Double getScore() {
        return Score;
    }

    public void setScore(Double Score) {
        this.Score = Score;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }
    
    @Override
    public String toString(){
        return Username+","+Password+","+Score;
    }
}
