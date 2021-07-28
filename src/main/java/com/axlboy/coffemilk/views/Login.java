package com.axlboy.coffemilk.views;

import com.axlboy.coffemilk.CoffeMilkApplication;
import com.axlboy.coffemilk.model.PostException;
import com.axlboy.coffemilk.model.entity.Account;
import com.axlboy.coffemilk.model.service.LoginService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class Login {

    private static Account user;

    @Autowired
    private LoginService service;

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
        try {
            user = service.login(txtID.getText(), txtPassword.getText());
            lblmessage.setText("Success");
            //Aquí se abre la aplicación
        }catch (PostException e){
            lblmessage.setText(e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            onClose();
        }
    }

    public static void loadView(Stage stage) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(Login.class.getResource("/com.axlboy.coffemilk.views/login.fxml"));
            loader.setControllerFactory(CoffeMilkApplication.getApplicationContext()::getBean);
            Parent view = loader.load();
            stage.setScene(new Scene((view)));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
