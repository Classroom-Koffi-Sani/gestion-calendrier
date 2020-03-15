/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier_prof;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author delaCruz
 */
public class MainController implements Initializable {

    @FXML
    private BorderPane content;
    @FXML
    private JFXButton profbtn;
    @FXML
    private VBox centerBox;

    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void manageProfs(MouseEvent event) throws IOException {
        Parent manageProfs = LoaderImpl.load("profs");
        centerBox.getChildren().clear();
        centerBox.getChildren().add(manageProfs);
        content.setRight(null);
    }

    @FXML
    private void program(MouseEvent event) throws IOException {
        Parent program = LoaderImpl.load("program");
//        Parent classes = LoaderImpl.load("classes");
        centerBox.getChildren().clear();
        centerBox.getChildren().add(program);
//        content.setRight(classes);
        
    }
    
    
    @FXML
    private void infos(MouseEvent event) throws IOException {
        Parent infos = LoaderImpl.load("infos");
        centerBox.getChildren().clear();
        centerBox.getChildren().add(infos);
        content.setRight(null);
    }


}
