package tool.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ChoiceBoxListCell;
import javafx.scene.layout.AnchorPane;
import tool.MainApp;
import tool.model.Location;

import java.io.IOException;
import java.util.logging.Handler;

/**
 * Created by Madman on 02.03.17.
 */
public class LocationOverviewController {

    @FXML
    private AnchorPane locationPane;
    @FXML
    private Accordion locationAccordion;
    @FXML
    private Button editButton;
    @FXML
    private AnchorPane l1;
    @FXML
    private TitledPane T1;
    @FXML
    private Button testButton;
    @FXML
    private ScrollPane locationScrollPane;
    @FXML
    private ChoiceBox productChoiceBox;




    private MainApp mainApp;
    //private boolean onClicked = false;

    public LocationOverviewController() {

    }

    @FXML
    private void initialize(){

    }

    public void setMainApp(MainApp mainApp){

        this.mainApp=mainApp;

    }

    @FXML
    public void handleNewLocation(){

        Location tempLocation = new Location();
        boolean onClicked = mainApp.showLocationEditDialog(tempLocation);
        if(onClicked) {
            createLocationPane(tempLocation);

        }
    }

    @FXML
    private void handleLocationEdit(ActionEvent event){



    }

    @FXML
    public void handleDeleteLocationPane(ActionEvent event) {
        TitledPane tempPane = locationAccordion.getExpandedPane();
        locationAccordion.getPanes().removeAll(tempPane);



    }

    @FXML
    public void handleDeleteProductRow(ActionEvent event){

    }
    public void handleDeleteProductRow(ChoiceBox selectedChoiceBox){



    }


    @FXML
    public void createLocationPane(Location tempLocation){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/LocationItem.fxml"));
            loader.setController(this);
            TitledPane locationItemPane =  (TitledPane) loader.load();
            locationItemPane.setText(tempLocation.getLocationName());
            productChoiceBox.setItems(FXCollections.observableArrayList("Insert product","Delete product"));
            productChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    //System.out.println(productChoiceBox.getItems().get((Integer) newValue));
                    String selectedChoice =productChoiceBox.getItems().get((Integer) newValue).toString();
                    System.out.printf(selectedChoice);

                    if (selectedChoice =="Insert product"){


                    } else if (selectedChoice == "Delete product") {

                        handleDeleteProductRow(productChoiceBox);

                    }



                }
            });

            locationAccordion.getPanes().add(locationItemPane);
            locationAccordion.setExpandedPane(locationItemPane);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
