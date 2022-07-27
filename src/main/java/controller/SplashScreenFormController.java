package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.Stack;

public class SplashScreenFormController {

    public Label lblStatus;
    public Rectangle pgbContainer;
    public Rectangle pgbLoad;

    public void initialize(){

        Timeline timeline = new Timeline();
        KeyFrame frame1 = new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblStatus.setText("Conecting with the database...");
                pgbLoad.setWidth(pgbLoad.getWidth() + 15);
            }
        });

        KeyFrame frame2 = new KeyFrame(Duration.millis(2000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblStatus.setText("Loading data...");
                pgbLoad.setWidth(pgbLoad.getWidth() + 75);
            }
        });

        KeyFrame frame3 = new KeyFrame(Duration.millis(3000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblStatus.setText("Setting up the UI...");
                pgbLoad.setWidth(pgbLoad.getWidth() + 150);
            }
        });

        KeyFrame frame4 = new KeyFrame(Duration.millis(4000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                try {
                    pgbLoad.setWidth(pgbContainer.getWidth());
                    Stage stage = new Stage();
                    stage.setTitle("National Fuel Pass App");
                    URL resource = this.getClass().getResource("/view/HomeForm.fxml");
                    Parent container = FXMLLoader.load(resource);
                    AnchorPane pneContainer = (AnchorPane) container.lookup("#pneContainer");
                    Navigation.init(pneContainer);
                    Scene scene = new Scene(container);
                    stage.setScene(scene);
                    stage.centerOnScreen();
                    stage.show();
                    lblStatus.getScene().getWindow().hide();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            }
        });

        timeline.getKeyFrames().addAll(frame1,frame2,frame3,frame4);
        timeline.playFromStart();

    }
}
