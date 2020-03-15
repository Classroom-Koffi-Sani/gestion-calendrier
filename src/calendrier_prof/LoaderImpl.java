/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier_prof;

import java.io.IOException;
import javafx.scene.Parent;

/**
 *
 * @author delaCruz
 */
public class LoaderImpl {
    public static Parent load(String file) throws IOException{
        return new Loader(file).getParent();
    }
}
