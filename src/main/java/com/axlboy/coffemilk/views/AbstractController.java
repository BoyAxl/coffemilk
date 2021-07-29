package com.axlboy.coffemilk.views;

import com.axlboy.coffemilk.utils.Menu;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public abstract class AbstractController {

    @FXML
    private Label title;

    public void setTitle(Menu menu){
        this.title.setText(menu.getTitle());
    }
}
