/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier_prof;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import lombok.Data;

/**
 *
 * @author delaCruz
 */
@Data
public class Loader {
    Parent parent;
    
    public Loader(String file) throws IOException{
        parent = load(file);
    }
    
    public  Parent load(String file) throws IOException{
        return FXMLLoader.load(getClass().getResource(file+".fxml"));
    }
}
