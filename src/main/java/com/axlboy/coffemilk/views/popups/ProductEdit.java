package com.axlboy.coffemilk.views.popups;

import com.axlboy.coffemilk.model.PostException;
import com.axlboy.coffemilk.model.entity.Category;
import com.axlboy.coffemilk.model.entity.Product;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ProductEdit {

    @FXML
    private ComboBox<Category> category;
    @FXML
    private Label message;
    @FXML
    private Label title;
    @FXML
    private TextField name;
    @FXML
    private TextField price;
    @FXML
    private TextArea remark;

    private Product product;
    private Consumer<Product> saveHandler;

    public static void addNew(Consumer<Product> saveHandler, Supplier<List<Category>> supplier){
        edit(null, saveHandler, supplier);
    }

    public static void edit(Product product, Consumer<Product> saveHandler, Supplier<List<Category>> supplier){
        try{
            Stage stage = new Stage(StageStyle.UNDECORATED);
            FXMLLoader loader = new FXMLLoader(ProductEdit.class.getResource("/com.axlboy.coffemilk.views/popups/productEdit.fxml"));
            stage.setScene(new Scene(loader.load()));
            stage.initModality(Modality.APPLICATION_MODAL);

            ProductEdit controller = loader.getController();
            controller.init(product, saveHandler, supplier);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void save(){
        try{
            product.setCategory(category.getValue());
            product.setName(name.getText());
            product.setPrice(Integer.parseInt(price.getText()));
            product.setRemark(remark.getText());

            saveHandler.accept(product);
            close();
        }catch (PostException e){
            message.setText(e.getMessage());
        }catch (NumberFormatException e){
            message.setText("Ingrese el precio con digitos.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    private void close(){
        remark.getScene().getWindow().hide();
    }

    private void init(Product product, Consumer<Product> saveHandler, Supplier<List<Category>> supplier) {

        this.product = product;
        this.saveHandler = saveHandler;
        category.getItems().addAll(supplier.get());

        if (null == product){
            title.setText("Agregar Producto");
            this.product = new Product();
        }else{
            title.setText("Editar Producto");
            this.product = product;
        }

        category.setValue(this.product.getCategory());
        name.setText(this.product.getName());
        price.setText(String.valueOf(this.product.getPrice()));
        remark.setText(this.product.getRemark());
    }
}
