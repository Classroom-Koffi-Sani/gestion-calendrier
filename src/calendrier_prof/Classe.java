/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier_prof;

import javafx.scene.layout.Pane;
import lombok.Data;

/**
 *
 * @author delaCruz
 */
@Data
public class Classe {
    private String name;
    private Time time;
    private Course course;
    private String[] jours={"Lundi","Mardi","Mercredi","Jeudi","Vendredi"};
    
    public Classe(){
        
    }
    
    public void planCourse(){
        
    }
    
}
