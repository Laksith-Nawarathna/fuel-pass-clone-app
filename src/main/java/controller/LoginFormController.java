package controller;

import db.InMemoryDB;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import util.Navigation;
import util.Routes;

import java.io.IOException;

public class LoginFormController {
    public TextField txtNICNumber;
    public Label lblRegisterHere;
    public Label lblNICNumberStatus;
    public Button btnLogin;

    public void lblRegisterHereOnMouseClicked(MouseEvent mouseEvent) throws IOException {

        Navigation.navigation(Routes.REGISTRATION);

    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {

        String nic = txtNICNumber.getText();
        if(!RegisterFormController.isValidNIC(txtNICNumber.getText()) ||
                InMemoryDB.findUser(txtNICNumber.getText())==null){
            new Alert(Alert.AlertType.ERROR,"Please enter a valid NIC").showAndWait();
            txtNICNumber.requestFocus();
        }else{
            Navigation.navigation(Routes.DASHBOARD);
        }
    }
}
