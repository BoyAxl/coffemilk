package com.axlboy.coffemilk.views.common;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.stereotype.Controller;

@Controller
public class Dialog {
    @FXML
    private Label title;
    @FXML
    private Label message;
    @FXML
    private Button okBtn;
    @FXML
    private Button closeBtn;

    private Stage stage;

    @FXML
    private void cancel(){
        okBtn.getScene().getWindow().hide();
    }

    public void show(){
        stage.show();
    }

    public static class DialogBuilder {
        private String title;
        private String message;

        private ActionListener okActionListener;

        public DialogBuilder() {
        }

        public DialogBuilder okActionListener(ActionListener okActionListener){
            this.okActionListener = okActionListener;
            return this;
        }

        public DialogBuilder title(String title){
            this.title = title;
            return this;
        }

        public DialogBuilder message(String message){
            this.message = message;
            return this;
        }

        public Dialog build(){
            try{
                Stage stage = new Stage(StageStyle.UNDECORATED);
                FXMLLoader loader = new FXMLLoader(Dialog.class.getResource("/com.axlboy.coffemilk.views/common/dialog.fxml"));
                Parent view = loader.load();
                stage.setScene(new Scene(view));

                Dialog controller = loader.getController();
                controller.stage = stage;

                controller.title.setText(this.title);
                controller.message.setText(this.message);

                if(null != okActionListener){
                    controller.okBtn.setOnAction(event -> {  //Cuando se Presiona OK
                        controller.cancel(); //Se ejecuta el método que cierra la ventana del Dialogo
                        okActionListener.doAction(); // Se ejecuta el metodo que cierra el programa
                    });
                }else{
                    controller.okBtn.setVisible(false);
                    controller.closeBtn.setText("Cancelar");
                }
                return controller;
            }catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        public static DialogBuilder builder(){
            return new DialogBuilder();
        }
    }

    public interface ActionListener{
        void doAction();
    }
}
