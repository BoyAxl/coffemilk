package com.axlboy.coffemilk.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {
    public static void loadView(Stage stage) throws Exception {
        Parent view = FXMLLoader.load(Login.class.getResource("/login.fxml"));
        stage.setScene(new Scene((view)));
        stage.show();
    }
}
