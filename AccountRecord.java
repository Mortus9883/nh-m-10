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
    private static Double Score;

    public AccountRecord(String Username, String Password, Double Score) {
        this.Username = Username;
        this.Password = Password;
        this.Score = Score;
    }

    public static Double getScore() {
        return Score;
    }
    
}
