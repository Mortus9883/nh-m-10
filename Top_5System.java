/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flappybirdeasyver;

import java.util.logging.Logger;

/**
 *
 * @author Windows 10
 */
public class Top_5System extends AccountRecord implements Comparable<Top_5System> {
    private String user;
    private String password;
    private Double score;

    public Top_5System(String user,Double score,String Username,String password,Double Score) {
        super(Username,password,score);
        this.user = user;
        this.password = password;
        this.score = score;
    }
    public void setMedal(){
        super.setLegendaryMedal("Glorious Medal");
    }
    public String getMedal(){
        return super.getLegendaryMedal();
    }
    @Override
    public int compareTo(Top_5System x){
        return x.score.compareTo(this.score);
    }

    public String getUser() {
        return user;
    }
    
    @Override
    public String toString(){
        return user+" "+score;
    }
}

