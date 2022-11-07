package controller;

import db.InMemoryDB;
import db.User;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.Optional;

public class AdminControllerCenterFormController {

    public AnchorPane pneAdminControlCenter;
    public Button btnUpdate;
    public TableView<User> tblUser;
    public Spinner<Integer> txtQuota;
    public TextField txtSearch;
    public Button btnSearch;
    public Button btnRemoveUser;
    public TableColumn colAddress;

    public void initialize(){
        Platform.runLater(pneAdminControlCenter::requestFocus);

        txtQuota.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,20,16));
        pneAdminControlCenter.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number prev, Number current) {
                if(prev.doubleValue() == 0.0) return;
                double diff = current.doubleValue() - prev.doubleValue();
                double prefWidth = colAddress.getWidth() + diff;
                if(prefWidth < 192) prefWidth = 192;
                colAddress.setPrefWidth(prefWidth);
            }
        });

        tblUser.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("nic"));
        tblUser.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("quota"));
        tblUser.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tblUser.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tblUser.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("address"));

        //ObservableList<User> olUsers = FXCollections.observableArrayList(InMemoryDB.getUserDatabase());
        tblUser.setItems(FXCollections.observableArrayList(InMemoryDB.getUserDatabase()));
        /*ObservableList<User> olUsers = tblUser.getItems();
        for (User user : olUsers) {
            olUsers.add(user);
        }*/

        tblUser.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        txtSearch.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String prev, String current) {

                if(prev.equals(current)) return;
        //        ArrayList<User> foundUsers = InMemoryDB.findUsers(current);
        //        ObservableList<User> olFoundUsers = FXCollections.observableArrayList(foundUsers);
                tblUser.setItems(FXCollections.observableArrayList(InMemoryDB.findUsers(current)));

            }
        });

        btnRemoveUser.setDisable(true);
        txtQuota.setDisable(true);
        btnUpdate.setDisable(true);
        tblUser.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<User>() {
            @Override
            public void changed(ObservableValue<? extends User> observableValue, User prev, User current) {
                btnRemoveUser.setDisable(tblUser.getSelectionModel().getSelectedItems().isEmpty());
                txtQuota.setDisable(btnRemoveUser.isDisable());
                btnUpdate.setDisable(btnRemoveUser.isDisable());
            }
        });
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        ObservableList<User> selectedUsers = tblUser.getSelectionModel().getSelectedItems();
        for (User selectedUser : selectedUsers) {
            selectedUser.setQuota(txtQuota.getValue());
        }
        tblUser.refresh();
    }

    public void btnRemoveUserOnAction(ActionEvent actionEvent) {

        Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to delete?", ButtonType.NO, ButtonType.YES).showAndWait();
        if(buttonType.get() == ButtonType.NO) return;

        ObservableList<User> selectedUsers = tblUser.getSelectionModel().getSelectedItems();
        for (User selectedUser : selectedUsers) {
            InMemoryDB.removeUser(selectedUser.getNic());
            //tblUser.getItems().remove(selectedUser);
        }
        tblUser.getItems().removeAll(selectedUsers);
        tblUser.getSelectionModel().clearSelection();
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {

    }
}
