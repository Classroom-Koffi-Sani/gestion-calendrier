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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author delaCruz
 */
public class ProgramController implements Initializable {

    @FXML
    private HBox centerBox;
    @FXML
    private HBox top;
    @FXML
    private HBox week;
    @FXML
    private HBox bottom;
    @FXML
    private HBox profPicker;
    @FXML
    private ImageView addProf;
    @FXML
    private Label d_profName;
    @FXML
    private VBox day1;
    @FXML
    private Label dayTitle1;
    @FXML
    private VBox coursesList1;
    @FXML
    private VBox day2;
    @FXML
    private Label dayTitle2;
    @FXML
    private VBox coursesList2;
    @FXML
    private VBox day3;
    @FXML
    private Label dayTitle3;
    @FXML
    private VBox coursesList3;
    @FXML
    private VBox day4;
    @FXML
    private Label dayTitle4;
    @FXML
    private VBox coursesList4;
    @FXML
    private VBox day5;
    @FXML
    private Label dayTitle5;
    @FXML
    private VBox coursesList5;
    @FXML
    private VBox day6;
    @FXML
    private Label dayTitle6;
    @FXML
    private VBox coursesList6;
    
    private Label dayLabel;
    @FXML
    private JFXButton form1;
    @FXML
    private JFXButton form2;
    @FXML
    private JFXButton form3;
    @FXML
    private JFXButton form4;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleProfDragOver(DragEvent event) {
        if(event.getDragboard().hasImage()){
            event.acceptTransferModes(TransferMode.MOVE);
        }
    }
    
    @FXML
    private void handleProfDragDropped(DragEvent event) throws IOException{
//        System.out.println("Day label " + dayLabel);
        System.out.println("dropped");
        dayLabel = (Label) event.getSource();
//        System.out.println("Day label " + dayLabel);
    }

    @FXML
    private void handleProfDragDetected(MouseEvent event) {
        
        //Preparing the drag and drop option
        Dragboard db = addProf.startDragAndDrop(TransferMode.ANY);
        
        //Preparing the content manager of the draggable object
        ClipboardContent cb = new ClipboardContent();
        cb.putImage(addProf.getImage());
        
        //Setting the content manager to the draggable manager
        db.setContent(cb);
        
        //Prevent extending the event to the other component
        event.consume();
    }

    @FXML
    private void handleProfDragDone(DragEvent event) throws IOException {
        if(dayLabel != null){
            
            System.out.println("Done");

            //Getting the target area

            //Fetching its components
            String idOfTarget = dayLabel.getId();
            Node dayComponent =  week.lookup("#" + idOfTarget);
            dayLabel = null;

            //Checking the last index of the dayLabelId to match the courseList
            char courseListIdentifier = idOfTarget.charAt(idOfTarget.length()-1);
            String idOfCourse = "coursesList"+courseListIdentifier;
            Node courseListComponent = week.lookup("#" +idOfCourse);

            //Loading the time component
            Parent timeComponent = LoaderImpl.load("time");

            //Preparing the popup window for setting the date
            Stage timeChooser = new Stage();
            timeChooser.setScene(new Scene(timeComponent));
            timeChooser.initOwner(centerBox.getScene().getWindow());
            timeChooser.initModality(Modality.APPLICATION_MODAL);
            timeChooser.initStyle(StageStyle.UNDECORATED);
            timeChooser.showAndWait();

            //Finding the choicebox
            ChoiceBox timeChoiceBox = (ChoiceBox) timeChooser.getScene().lookup("#timeChoiceBox");
            ChoiceBox courseChoiceBox = (ChoiceBox) timeChooser.getScene().lookup("#courseChoiceBox");
            
            Stage stage = (Stage) timeChoiceBox.getScene().getWindow();
            
            //Planning a course

            //Getting the time choosed
            String timeChoosed = (String) timeChoiceBox.getSelectionModel().selectedItemProperty().get();
            String courseChoosed = (String) courseChoiceBox.getSelectionModel().selectedItemProperty().get();
            if(timeChoosed != null && courseChoosed != null){
                //Loading the course component
                Parent courseComponent = LoaderImpl.load("course");

                //Preparing the course list
                VBox coursesList = (VBox) courseListComponent;

                //Preparing the course
                VBox coursePlanned = (VBox) courseComponent;

                //Getting the direct root of the course component
                Pane pane = (Pane) coursePlanned.getChildren().get(0);

                //Getting the label designed for displaying the time
                Label timeLabel = (Label) pane.getChildren().get(1);

                //Setting the time choosed to the label
                timeLabel.setText(timeChoosed);

                //Adding the course planned to the course list
                coursesList.getChildren().add(coursePlanned);

            }else{
                //If the time was not set
                System.out.println("Null");
            }

        }

    }

    @FXML
    private void loadForm1Content(MouseEvent event) {
    }

    @FXML
    private void loadForm2Content(MouseEvent event) {
    }

    @FXML
    private void loadForm3Content(MouseEvent event) {
    }

    @FXML
    private void loadForm4Content(MouseEvent event) {
    }
    
}
