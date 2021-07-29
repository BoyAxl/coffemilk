package com.axlboy.coffemilk.views;

import com.axlboy.coffemilk.CoffeMilkApplication;
import com.axlboy.coffemilk.utils.Menu;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainFrame {

    @FXML
    private VBox sideBar;

    @FXML
    private StackPane contentView;

    @FXML
    private void initialize(){
        loadView(Menu.home);  //POR DEFECTO SE INICIALIZA EL MENÚ HOME
    }

    @FXML
    private void clickMenu(MouseEvent event){
        Node node = (Node) event.getSource();
        //System.out.println(node.getId());

        if(node.getId().equals("exit")){
            sideBar.getScene().getWindow().hide();
        }else{
            Menu menu = Menu.valueOf(node.getId());
            loadView(menu);
        }
    }

    private void loadView(Menu menu){
        try{

            for(Node node : sideBar.getChildren()){
                node.getStyleClass().remove("active");
                if(node.getId().equals(menu.name())) {
                    node.getStyleClass().add("active");
                }
            }

            contentView.getChildren().clear();
            //System.out.println(menu.getFxml());
            FXMLLoader loader = new FXMLLoader(getClass().getResource(menu.getFxml()));
            loader.setControllerFactory(CoffeMilkApplication.getApplicationContext()::getBean);
            Parent view = loader.load();
            contentView.getChildren().add(view);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

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
