package com.axlboy.coffemilk.views;

import com.axlboy.coffemilk.model.entity.Category;
import com.axlboy.coffemilk.model.service.CategoryService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.SVGPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Categories extends AbstractController{

    @FXML
    private TilePane container;

    @Autowired
    private CategoryService service;

    @FXML
    private void initialize(){
        container.getChildren().clear();
        service.findAll().stream().forEach(category -> container.getChildren().add(new CategoryItem(category)));
    }

    private class CategoryItem extends HBox {

        private SVGPath icon;
        private Label name;

        public CategoryItem(Category category) {
            icon = new SVGPath();
            icon.setContent("M34.001 11.499c0 1.38 1.12 2.5 2.5 2.5s2.5-1.12 2.5-2.5-1.12-2.5-2.5-2.5-2.5 1.12-2.5 2.5zM16.521 46.839c1.54 1.551 4.040 1.551 5.59 0l24.44-24.28c0.979-0.979 1.47-2.27 1.45-3.56v-14.040c0-2.74-2.221-4.96-4.96-4.96h-14.040c-1.29-0.021-2.58 0.47-3.561 1.45l-24.279 24.441c-1.551 1.549-1.551 4.049 0 5.59l15.36 15.359zM30.001 11.499c0-3.59 2.91-6.5 6.5-6.5s6.5 2.91 6.5 6.5-2.91 6.5-6.5 6.5-6.5-2.91-6.5-6.5z");
            name = new Label();
            name.setText(category.getName()); // le pasamos el atributo name al nombre del label

            getChildren().addAll(icon, name);
            getStyleClass().add("category-item"); //Le seteamnos un estilo del css
        }
    }
}
