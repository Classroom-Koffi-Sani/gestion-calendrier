/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier_prof;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author delaCruz
 */
public class appController implements Initializable {
    
    private Label label;
    @FXML
    private Pane destination;
    @FXML
    private VBox source;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    ImageView imageView = new ImageView();
    @FXML
    private void handleImageDragDetected(MouseEvent event) {
        Dragboard db = source.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb = new ClipboardContent();
        String target = event.getTarget().toString();
//        String id = source.getChildren().get(0).toString();
//        String target  = event.getTarget().toString();
//        System.out.println(id + "\n" + target);
        ObservableList<Node> childrens = source.getChildren();
        for(Node child : childrens){
            String desc = child.toString();
            System.out.println(desc);
            if (target.equals(desc)){
                imageView = (ImageView) child;
                break ;
            }
        }
        
//        cb.put(imageView.getImage());
        imageView.setOnDragDone(end ->{
            
        });
        db.setContent(cb);
        event.consume();
    }

    @FXML
    private void handleImageDragOver(DragEvent event) {
        if(event.getDragboard().hasImage()){
            event.acceptTransferModes(TransferMode.MOVE);
        }
    }

    @FXML
    private void handleImageDragDropped(DragEvent event) {
        ImageView imageView = new ImageView(event.getDragboard().getImage());
        destination.getChildren().add(imageView);
//        source.getChildren().remove(this.imageView);
    }

    
}
