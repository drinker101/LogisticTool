package tool.view;

import javafx.fxml.FXML;
import tool.MainApp;

/**
 * Created by Madman on 02.03.17.
 */
public class RootLayoutController {

    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }

}
