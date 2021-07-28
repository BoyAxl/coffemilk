package com.axlboy.coffemilk.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFrame {
    public static void show() {

        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(MainFrame.class.getResource("/com.axlboy.coffemilk.views/mainFrame.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
