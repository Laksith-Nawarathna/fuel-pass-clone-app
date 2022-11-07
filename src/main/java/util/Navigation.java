package util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

public class Navigation {
    private static AnchorPane pneContainer;

    public static void init(AnchorPane pneContainer){
        Navigation.pneContainer = pneContainer;
    }

    public static Object navigation(Routes route) throws IOException {
        pneContainer.getChildren().clear();
        URL resource = null;
        switch (route){
            case WELCOME:
                resource = Navigation.class.getResource("/view/WelcomeForm.fxml");
                break;
            case REGISTRATION:
                resource = Navigation.class.getResource("/view/RegisterForm.fxml");
                break;
            case LOGIN:
                resource = Navigation.class.getResource("/view/LoginForm.fxml");
                break;
            case ADMIN_LOGIN:
                resource = Navigation.class.getResource("/view/AdminLoginForm.fxml");
                break;
            case DASHBOARD:
                resource = Navigation.class.getResource("/view/UserDashboardForm.fxml");
                break;
            case CONTROL_CENTER:
                resource = Navigation.class.getResource("/view/AdminControllerCenterForm.fxml");
                break;
        }
        //Parent container = FXMLLoader.load(resource);
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        Parent container = fxmlLoader.load();
        pneContainer.getChildren().add(container);
        AnchorPane.setBottomAnchor(container,0.0);
        AnchorPane.setBottomAnchor(container,0.0);
        AnchorPane.setBottomAnchor(container,0.0);
        AnchorPane.setBottomAnchor(container,0.0);
        return fxmlLoader.getController();
    }

}
