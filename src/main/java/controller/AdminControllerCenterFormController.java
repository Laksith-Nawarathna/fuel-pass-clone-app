package controller;

import javafx.application.Platform;
import javafx.scene.layout.AnchorPane;

public class AdminControllerCenterFormController {

    public AnchorPane pneAdminControlCenter;

    public void initialize(){
        Platform.runLater(pneAdminControlCenter::requestFocus);
    }
}
