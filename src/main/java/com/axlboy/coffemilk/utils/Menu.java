package com.axlboy.coffemilk.utils;

public enum Menu {
    home("CoffeMilk Dashboard"),
    sales("Historial de Ventas"),
    category("Manejador de Categorías"),
    product("Manejador de Productos");

    private String title;

    Menu(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public String getFxml(){
        return String.format("/com.axlboy.coffemilk.views/%s.fxml", name());
    }
}
