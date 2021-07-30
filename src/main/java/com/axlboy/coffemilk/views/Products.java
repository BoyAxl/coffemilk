package com.axlboy.coffemilk.views;

import com.axlboy.coffemilk.model.entity.Category;
import com.axlboy.coffemilk.model.entity.Product;
import com.axlboy.coffemilk.model.service.CategoryService;
import com.axlboy.coffemilk.model.service.ProductService;
import com.axlboy.coffemilk.views.common.Dialog;
import com.axlboy.coffemilk.views.popups.ProductEdit;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class Products extends AbstractController{

    @FXML
    private ComboBox<Category> category;
    @FXML
    private TextField name;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    @FXML
    private TableView<Product> tableView;

    @FXML
    private void initialize() {
        initTable();
        category.getItems().clear();
        category.getItems().addAll(categoryService.findAll());

        MenuItem edit = new MenuItem("Editar Producto");
        edit.setOnAction(event -> {
            Product product = tableView.getSelectionModel().getSelectedItem();
            if(null != product) {
                ProductEdit.edit(product, this::save, categoryService::findAll);
            }
        });

        MenuItem changeState = new MenuItem("Cambiar Estado");
        changeState.setOnAction(event -> {
            Product product = tableView.getSelectionModel().getSelectedItem();
            if(null != product) {
                String message;

                if (product.isValid()){
                    message =  String.format("Desea desactivar el producto: %s?", product.getName());
                }else{
                    message = String.format("Desea activar el producto: %s?", product.getName());
                }

                Dialog.DialogBuilder.builder()
                        .title("Change Status")
                        .message(message)
                        .okActionListener(() -> {
                            product.setValid(!product.isValid());
                            productService.save(product);
                            search();
                        })
                        .build().show();
            }
        });

        tableView.setContextMenu(new ContextMenu(edit, changeState));
    }


    private void initTable(){
        tableView.getItems().clear();
        List<Product> list = productService.getProducts();
        tableView.getItems().addAll(list);
    }

    @FXML
    private void search() {
        tableView.getItems().clear();
        List<Product> list = productService.search(category.getValue(), name.getText());
        tableView.getItems().addAll(list);
    }

    @FXML
    private void clear() {
        category.setValue(null);
        name.clear();
        initTable();
    }

    @FXML
    private void addNew(){
        ProductEdit.addNew(this::save, categoryService::findAll);
    }

    private void save(Product product){
        productService.save(product);
        //category.setValue(product.getCategory());
        //name.setText(product.getName());
        initTable();
    }
}
