package controller;

import db.InMemoryDB;
import db.User;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import util.Navigation;
import util.Routes;

import java.io.IOException;
import java.net.URL;

public class RegisterFormController {
    public AnchorPane pneRegisterForm;
    public TextField txtNIC;
    public Label lblNICStatus;
    public Button btnRegister;
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtAddress;

    private void setDisablecmp(boolean disable){
        txtFirstName.setDisable(disable);
        txtLastName.setDisable(disable);
        txtAddress.setDisable(disable);
        btnRegister.setDisable(disable);
    }

    public void initialize(){
        Platform.runLater(txtNIC::requestFocus);
        txtNIC.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldText, String currentText) {

                setDisablecmp(true);

                if(currentText.isBlank()){
                    lblNICStatus.setText("Please enter valid NIC number to proceed");
                    lblNICStatus.setTextFill(Color.BLACK);
                }
                else {
                    if(isValidNIC(currentText)){
                        lblNICStatus.setText("Valid NIC ✔");
                        lblNICStatus.setTextFill(Color.GREEN);
                        setDisablecmp(false);
                        txtFirstName.requestFocus();
                    }else{
                        lblNICStatus.setText("Invalid NIC X");
                        lblNICStatus.setTextFill(Color.RED);
                    }
                }

            }
        });
    }

    public static boolean isValidNIC(String input){
        if(input.length() != 10) return false;
        if (!(input.endsWith("v") || input.endsWith("V"))) return false;
        //input = 123456789v
        if (!input.substring(0,9).matches("\\d+")) return false;
        return true;
    }

    public void lblLoginHereOnMouseClicked(MouseEvent mouseEvent) throws IOException {
       /* URL resource = this.getClass().getResource("/view/LoginForm.fxml");
        AnchorPane loginForm = FXMLLoader.load(resource);
        AnchorPane pneContainer = (AnchorPane) pneRegisterForm.getParent();
        pneContainer.getChildren().clear();
        pneContainer.getChildren().add(loginForm);
        AnchorPane.setLeftAnchor(loginForm,0.0);
        AnchorPane.setRightAnchor(loginForm,0.0);
        AnchorPane.setTopAnchor(loginForm,0.0);
        AnchorPane.setBottomAnchor(loginForm,0.0);*/

        Navigation.navigation(Routes.LOGIN);
    }

    public void btnRegisterOnAction(ActionEvent actionEvent) throws IOException {
        if (txtFirstName.getText().isBlank()) {
            new Alert(Alert.AlertType.ERROR,"First Name must be filled !").showAndWait();
            txtFirstName.requestFocus();
            return;

        } else if (!isName(txtFirstName.getText())) {
            new Alert(Alert.AlertType.ERROR,"First name is invalid. Enter a valid First name").showAndWait();
            txtFirstName.requestFocus();
            return;
        }else if (!isName(txtLastName.getText())) {
            new Alert(Alert.AlertType.ERROR,"Last name is invalid. Enter a valid Last name").showAndWait();
            txtLastName.requestFocus();
            return;
        }
        else if (txtAddress.getText().isBlank()) {
            new Alert(Alert.AlertType.ERROR,"Address must be filled !").showAndWait();
            txtAddress.requestFocus();
        } else if (txtAddress.getText().trim().length() < 3) {
            new Alert(Alert.AlertType.ERROR,"Enter a valid Address").showAndWait();
            txtAddress.requestFocus();
            return;
        } else{
            User user = new User(txtNIC.getText(), txtFirstName.getText(),
                    txtLastName.getText(), txtAddress.getText());
            boolean result = InMemoryDB.registerUser(user);

            if(result){
                new Alert(Alert.AlertType.INFORMATION, "You have successfully registered. " +
                        "You will be redirected to Login Page").showAndWait();
                lblLoginHereOnMouseClicked(null);
            }
            else{
                new Alert(Alert.AlertType.ERROR,"NIC is already used. Check your NIC").showAndWait();
                return;
            }



            /*URL login = this.getClass().getResource("/view/LoginForm.fxml");
            AnchorPane loginForm = FXMLLoader.load(login);
            AnchorPane pneContainer = (AnchorPane) pneRegisterForm.getParent();
            pneContainer.getChildren().clear();
            pneContainer.getChildren().add(loginForm);
            AnchorPane.setLeftAnchor(loginForm,0.0);
            AnchorPane.setRightAnchor(loginForm,0.0);
            AnchorPane.setTopAnchor(loginForm,0.0);
            AnchorPane.setBottomAnchor(loginForm,0.0);*/
        }
    }

    public boolean isName(String input){
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            if(!Character.isLetter(aChar) && aChar != ' ') return false;
        }
        return true;
    }
}
