import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        /*FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save QR Code");
        File file = new File(System.getenv("HOME"));
        //File file = new File(System.getProperty("user.home"));
        fileChooser.setInitialDirectory(file); //can use directory for file also
        fileChooser.setInitialFileName("qrcode");
        fileChooser.getExtensionFilters()
                .add(new FileChooser.ExtensionFilter("Text Files (*.txt)", "*.txt"));
        fileChooser.getExtensionFilters()
                .add(new FileChooser.ExtensionFilter("GIF files (*.gif)","*.gif"));
        fileChooser.getExtensionFilters()
                .add(new FileChooser.ExtensionFilter("JPEG files (*.jpeg | *.jpg)","*.jpeg","*.jpg"));

        fileChooser.showSaveDialog(primaryStage);*/
        URL resource = this.getClass().getResource("/view/SplashScreenForm.fxml");
        Parent container = FXMLLoader.load(resource);
        Scene scene = new Scene(container);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        scene.setFill(Color.TRANSPARENT);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();

    }
}
