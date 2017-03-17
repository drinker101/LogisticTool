package tool;/**
 * Created by Madman on 02.03.17.
 */

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tool.view.LocationEditDialogController;
import tool.view.LocationOverviewController;
import tool.view.RootLayoutController;

import tool.model.Location;
import java.io.IOException;


public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Logistic Tool");
        this.primaryStage.getIcons().add(new Image("file:resources/images/logo.png"));

        initRootLayout();
        showLocationOverview();

    }

    private void initRootLayout() {

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private void showLocationOverview() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/LocationOverview.fxml"));
            AnchorPane locationOverview = (AnchorPane) loader.load();


            rootLayout.setCenter(locationOverview);
            LocationOverviewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean showLocationEditDialog(Location location) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/LocationEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Location");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            LocationEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setLocation(location);


            dialogStage.showAndWait();

            return controller.isOnClicked();

        } catch (IOException e) {
            e.printStackTrace();
            return false;

        }


    }

    /**

    public LocationOverviewController getLocationOverview() {
        return
    }
     */

}
