package tool.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tool.MainApp;
import tool.model.Location;

import java.io.IOException;

/**
 * Created by Madman on 03.03.17.
 */

public class LocationEditDialogController {

    private MainApp mainApp;
    @FXML
    private LocationOverviewController locationOverviewController;
    private Stage dialogStage;
    private Location location;
    private boolean onClicked = false;

    @FXML
    private TextField geoLocationField;
    @FXML
    private TextField locationNameField;


    public void setDialogStage(Stage dialogStage) {

        this.dialogStage = dialogStage;
    }

    public void setLocation(Location location) {
        this.location = location;


        geoLocationField.setText(location.getGeoPlace());
        locationNameField.setText(location.getLocationName());
    }

    public boolean isOnClicked(){
        return onClicked;
    }


    @FXML
    private void handleCreate() {

        if (isInputValid()){
            location.setGeoPlace(geoLocationField.getText());
            location.setLocationName(locationNameField.getText());

            onClicked = true;
            dialogStage.close();
        }

    }

    private boolean isInputValid() {

        //TO DO
        return true;
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }


}
