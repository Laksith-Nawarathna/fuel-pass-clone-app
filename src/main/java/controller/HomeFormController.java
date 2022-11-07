package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import util.Navigation;
import util.Routes;

import java.io.IOException;
import java.net.URL;

public class HomeFormController {
    public AnchorPane pneContainer;
    public AnchorPane imgLogin;

    public void initialize() throws IOException {

        Platform.runLater(() -> {
            try {
                Navigation.navigation(Routes.WELCOME);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        /*URL resource = this.getClass().getResource("/view/WelcomeForm.fxml");
        AnchorPane welcomeForm = FXMLLoader.load(resource);
        pneContainer.getChildren().add(welcomeForm);

        AnchorPane.setLeftAnchor(welcomeForm,0.0);
        AnchorPane.setRightAnchor(welcomeForm,0.0);
        AnchorPane.setTopAnchor(welcomeForm,0.0);
        AnchorPane.setBottomAnchor(welcomeForm,0.0);*/

    }

    public void imgLogoOnMouseClicked(MouseEvent mouseEvent) throws IOException {

        pneContainer.getChildren().clear();
      /*  URL resource = this.getClass().getResource("/view/WelcomeForm.fxml");
        AnchorPane welcomeForm = FXMLLoader.load(resource);
        pneContainer.getChildren().add(welcomeForm);

        AnchorPane.setLeftAnchor(welcomeForm,0.0);
        AnchorPane.setRightAnchor(welcomeForm,0.0);
        AnchorPane.setTopAnchor(welcomeForm,0.0);
        AnchorPane.setBottomAnchor(welcomeForm,0.0);*/
        initialize();
    }

    public void imgLoginOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        /*pneContainer.getChildren().clear();
        URL resource = this.getClass().getResource("/view/AdminLoginForm.fxml");
        AnchorPane adminLoginForm = FXMLLoader.load(resource);
        pneContainer.getChildren().add(adminLoginForm);
        AnchorPane.setLeftAnchor(adminLoginForm,0.0);
        AnchorPane.setRightAnchor(adminLoginForm,0.0);
        AnchorPane.setTopAnchor(adminLoginForm,0.0);
        AnchorPane.setBottomAnchor(adminLoginForm,0.0);*/

        Navigation.navigation(Routes.ADMIN_LOGIN);
    }

    public void pneLoginOnKeyReleased(KeyEvent keyEvent) throws IOException {

        //System.out.println(keyEvent);
        if(keyEvent.getCode() == KeyCode.ENTER || keyEvent.getCode() == KeyCode.SPACE){
            imgLoginOnMouseClicked(null);
        }

    }
}
