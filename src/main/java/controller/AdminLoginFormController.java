package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import util.Navigation;
import util.Routes;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

public class AdminLoginFormController {
    private static int attempts = 3;

    public PasswordField txtPassword;

    private static final String ADMIN_PASSWORD = "123";
    //public AnchorPane pneAdminLoginForm;
    public AnchorPane pneAdminLogin;

    public void initialize(){
        Platform.runLater(txtPassword::requestFocus);
    }

    public void txtPasswordOnAction(ActionEvent actionEvent) throws IOException, URISyntaxException {
        if (!txtPassword.getText().equals(ADMIN_PASSWORD)){

            if (attempts == 0){
                new Alert(Alert.AlertType.ERROR, "Sorry, You have reached maximum number of attempts").showAndWait();
                Platform.exit();
                return;
            }

            URL resource = this.getClass().getResource("/audio/warningAlarm.mp3");
            Media media = new Media(resource.toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            //mediaPlayer.getVolume();
            mediaPlayer.play();

            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid Admin Password. You have " + attempts + " more attempts to try again.");
            attempts--;

            InputStream resourceAsStream = this.getClass().getResourceAsStream("/images/ictaLogo.jpg");
            Image image = new Image(resourceAsStream);
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(48);
            imageView.setFitHeight(48);
            alert.setGraphic(imageView);

            alert.setHeaderText("Invalid Login Credential");
            alert.setTitle("Access Denied");

            alert.showAndWait();
            mediaPlayer.dispose();
            txtPassword.requestFocus();
            return;
        }

        Navigation.navigation(Routes.CONTROL_CENTER);

        /*URL resource = this.getClass().getResource("/view/AdminControllerCenterForm.fxml");
        AnchorPane controlCenter = FXMLLoader.load(resource);
        AnchorPane pneContainer = (AnchorPane) pneAdminLogin.getParent();
        pneContainer.getChildren().clear();
        pneContainer.getChildren().add(controlCenter);
        AnchorPane.setLeftAnchor(controlCenter, 0.0);
        AnchorPane.setRightAnchor(controlCenter, 0.0);
        AnchorPane.setTopAnchor(controlCenter, 0.0);
        AnchorPane.setBottomAnchor(controlCenter, 0.0);*/
    }
}