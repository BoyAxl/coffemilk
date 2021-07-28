package com.axlboy.coffemilk.controllers;

import com.axlboy.coffemilk.model.Cliente;
import com.axlboy.coffemilk.repos.ClienteRep;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class IndexController implements Initializable {
    @Autowired
    @Qualifier("lblTitle")
    private String title;

    @Autowired
    private ClienteRep clienteRep;

    @FXML
    private Label lblTitle;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtTelefono;
    @FXML
    private ComboBox<Cliente> comboClientes;

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) { //Aquí se inicializan valores
        lblTitle.setText(title); //Cargamos el titulo de la página
        comboClientes.setItems(FXCollections.observableArrayList(clienteRep.findAll())); //Cargamos los clientes en el Cbo
    }

    @FXML
    public void onSave(){
        Cliente cliente = new Cliente();
        cliente.setNombre(txtNombre.getText());
        cliente.setApellido(txtApellido.getText());
        cliente.setTelefono(txtTelefono.getText());

        clienteRep.save(cliente);
        comboClientes.setItems(FXCollections.observableArrayList(clienteRep.findAll()));
    }
}
