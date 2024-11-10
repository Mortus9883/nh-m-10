/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flappybirdeasyver;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Windows 10
 */
public class rank implements Comparable<rank> {
    private String name;
private Double score;
   private Integer buff;
   private String medal;
   public static ArrayList<rank> a=new ArrayList<>();
   public static HashMap<String,rank> b=new HashMap<>();

    public rank(String name, Double score,Integer buff,String medal) {
        this.name = name;
        this.score = score;
        this.buff=buff;
        this.medal=medal;
    }
    public String getName() {
        return this.name;
    }

    public String getMedal() {
        return medal;
    }

    public Double getScore() {
        return score;
    }
    
    @Override
    public int compareTo(rank x){
        return this.score.compareTo(x.score);
    }
}
