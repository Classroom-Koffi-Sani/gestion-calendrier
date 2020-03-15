/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier_prof;

import javafx.scene.layout.Pane;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author delaCruz
 */
@EqualsAndHashCode(callSuper=false)
@Data
public class Professeur  extends Pane{
    private String nom;
    private String telephone;
    private String matière;
}
