/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier_prof;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lombok.Data;

/**
 * FXML Controller class
 *
 * @author delaCruz
 */
@Data
public class TimeController implements Initializable {

    private ChoiceBox<String> choiceBox;
    @FXML
    private JFXButton add;
    
    private Stage stage;
    @FXML
    private JFXButton cancel;
    @FXML
    private ChoiceBox<?> courseChoiceBox;
    @FXML
    private ChoiceBox<String> timeChoiceBox;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        timeChoiceBox.getItems().addAll(Time.TIMES);
        
        courseChoiceBox.setOnAction(sc ->{
            timeChoiceBox.setOnAction(st ->{
                add.setDisable(false);
            });
        });
        
//👀🙄🙄     👍   stage = (Stage) choiceBox.getScene().getWindow();
    }    

    @FXML
    private void close(MouseEvent event) {
        //Getting the component source
        Parent eventComponent = (Parent) event.getSource();
        
        //Getting its stage
        stage = (Stage) eventComponent.getScene().getWindow();
        
        //Clear the selection if cancel button is pressed
        if(eventComponent == cancel){
            timeChoiceBox.getSelectionModel().clearSelection();
            courseChoiceBox.getSelectionModel().clearSelection();
        }
        stage.close();
    }
    
    

    
}
