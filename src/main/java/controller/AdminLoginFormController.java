package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class AdminLoginFormController {

    private static int attempts = 3;
    public PasswordField txtPassword;

    private static final String ADMIN_PASSWORD = "123";
    public AnchorPane pneAdminLogin;


    public void txtPasswordOnAction(ActionEvent actionEvent) throws IOException {
        if(!txtPassword.getText().equals(ADMIN_PASSWORD)){
           /* new Alert(Alert.AlertType.ERROR,"Wrong...!").showAndWait();
            txtPassword.requestFocus();*/

            if(attempts == 0){
                new Alert(Alert.AlertType.ERROR,"You have reached maximum number of attempts").showAndWait();
                Platform.exit();
                return;
            }

            URL resource = this.getClass().getResource("/audio/Security Breach-freeringtonesfree.mobi.mp3");
            Media media = new Media(resource.toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();

            Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong...! You have "+ attempts + " more attempts\nTry Again...!");
            attempts--;

            InputStream resourceAsStream = this.getClass().getResourceAsStream("/images/accessDenied.jpg");
            Image image = new Image(resourceAsStream);
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(48);
            imageView.setFitHeight(48);
            alert.setGraphic(imageView);

            alert.setHeaderText("Invalid Login Crediantial");
            alert.setTitle("Access Denied");
            alert.setWidth(500);
            alert.showAndWait();
            mediaPlayer.dispose();
            txtPassword.requestFocus();

            return;
        }

        URL resource = this
                .getClass().getResource("/view/AdminControllerCenterForm.fxml");
        AnchorPane adminContainer = FXMLLoader.load(resource);

        AnchorPane pneContainer = (AnchorPane) pneAdminLogin.getParent();
        pneContainer.getChildren().clear();
        pneContainer.getChildren().add(adminContainer);
    }

    public void initialize(){
        Platform.runLater(txtPassword::requestFocus);
    }
}
