/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier_prof;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author delaCruz
 */
public class ProfsController implements Initializable {

    @FXML
    private JFXListView<String> listCourses;
    @FXML
    private JFXButton add;
    @FXML
    private JFXButton reset;
    @FXML
    private JFXTextField surName;
    @FXML
    private JFXTextField firstName;
    @FXML
    private JFXTextField tel;
    @FXML
    private JFXTextField email;
    @FXML
    private HBox profInterface;
    
    private SimpleIntegerProperty countField = new SimpleIntegerProperty();
    @FXML
    private AnchorPane infosPane;


    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        llkqsl
        try {
            //Fill the list by the courses
            listCourses.getItems().addAll(Database.getMatieres());
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProfsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        listCourses.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        listCourses.setOnMouseClicked(mc->{
            if(countField.getValue() == 4){
                add.setDisable(false);
            }else{
                countField.addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        if(countField.getValue() == 4){
                            add.setDisable(false);
                        }else{
                            add.setDisable(true);
                        }
                    }
                });
            }
            if(validateInput()){
                add.setDisable(false);
            }else{
                add.setDisable(true);
            }
//            validateInput();
        });
        
//        surName.setOnInputMethodTextChanged(value);
        countField.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("old value " +oldValue + "new value " + newValue);
                System.out.println("Changed");
            }
        });
        
        Map<JFXTextField,Integer> tfDic = new HashMap<>();
        List<JFXTextField> textFields = new ArrayList() ;
        
        infosPane.getChildren().forEach(child ->{
            JFXTextField tf = (JFXTextField) child;
            tfDic.put(tf,0);
        });
        System.out.println(tfDic);
        
        tfDic.forEach((tf,nb) ->{
            tf.focusedProperty().addListener(new ChangeListener<Boolean>(){
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    boolean focusedValue = tf.focusedProperty().getValue();
                    String input = tf.textProperty().getValue();
                    if(!focusedValue){
                        checkOneInput(input, tf, tfDic);
                    }
                }

            });

        });
        
        
//        surName.textProperty().addListener(new ChangeListener<String>(){
//            @Override
//            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//                System.out.println("Text");
//                System.out.println(surName.focusedProperty());
//                System.out.println(surName.textProperty());
//            }
//            
//            
//        });
    }

    public void updateCounter(int modifier){
        switch(modifier){
            case 1:
                countField.setValue(countField.getValue() +1);
                break;
            default:
                countField.setValue(countField.getValue() -1);
                break;
        }
        
        if (countField.getValue() < 0) countField.setValue(0);
    }
    
    private void checkOneInput(String input,JFXTextField tf, Map dico){
        if( (int)(dico.get(tf))== 0){
            if(!input.trim().equals("")){
                updateCounter(1);
                dico.put(tf, 1);
            }
        }else{
            if(input.trim().equals("")){
                updateCounter(-1);
                dico.put(tf, 0);
            }
        }
    }

    //Save the teacher in the database
    @FXML
    private void addProfs(MouseEvent event) {
        List courses = listCourses.getSelectionModel().getSelectedItems();
        String profSurName = surName.getText();
        String profFirstName = firstName.getText();
        String profTel = tel.getText();
        String profEmail = email.getText();
        
        //Code for saving the prof in the database
        
        
        
    }
    
    private boolean validateInput(){
        if(firstName.getText().trim().equals("") || surName.getText().trim().equals("") || tel.getText().trim().equals("") || email.getText().trim().equals("") ){
            clearSelections();
            return false;
        }
        return true;
    }

    @FXML
    private void reset(MouseEvent event) {
        clearSelections();
        clearListSelection();
    }
    
    private void clearListSelection(){
        listCourses.getSelectionModel().clearSelection();
    }
    
    private void clearSelections(){
        firstName.clear();
        surName.clear();
        tel.clear();
        email.clear();
        add.setDisable(true);
    }
    
    
    
}
