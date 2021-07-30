package com.axlboy.coffemilk.views;

import com.axlboy.coffemilk.model.entity.Category;
import com.axlboy.coffemilk.model.entity.Product;
import com.axlboy.coffemilk.model.service.CategoryService;
import com.axlboy.coffemilk.model.service.ProductService;
import com.axlboy.coffemilk.views.popups.ProductEdit;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private void initialize(){
        category.getItems().clear();
        category.getItems().addAll(categoryService.findAll());

        tableView.setOnMouseClicked(event -> {
            if(event.getClickCount() == 2){
                Product product = tableView.getSelectionModel().getSelectedItem();
                if(null == product){
                    ProductEdit.edit(product, this::save, categoryService::findAll);
                }
            }
        });
    }

    @FXML
    private TableView<Product> tableView;

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
        tableView.getItems().clear();
    }

    @FXML
    private void addNew(){
        ProductEdit.addNew(this::save, categoryService::findAll);
    }

    private void save(Product product){
        productService.save(product);
        category.setValue(product.getCategory());
        name.setText(product.getName());
        search();
    }
}
