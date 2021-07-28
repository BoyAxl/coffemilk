package com.axlboy.coffemilk.views;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Login {
    @FXML
    private Label lblmessage;

    @FXML
    private TextField txtID;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnLogin;

    @FXML
    private void onClose() {
        btnClose.getScene().getWindow().hide();
    }

    @FXML
    private void onLogin() {

    }

    public static void loadView(Stage stage) throws Exception {
        Parent view = FXMLLoader.load(Login.class.getResource("/com.axlboy.coffemilk.views/login.fxml"));
        stage.setScene(new Scene((view)));
        stage.show();
    }
}
