/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier_prof;

import java.util.List;

/**
 *
 * @author delaCruz
 */
public class Day {
    private String name;
    private Course course;
    private int countHour;
    private  List<String> hoursChoosed;
    
    public String chooseTime(String time){
        if(countHour < 7){
            
            if(time.length() > 2){
                countHour +=2;
            }else{
                countHour ++;
            }
            
            hoursChoosed.add(time);
            return "Ajouté avec succès";
        }
        return "Heures saturées";
    }
}
