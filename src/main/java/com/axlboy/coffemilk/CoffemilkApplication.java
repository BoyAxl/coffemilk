package com.axlboy.coffemilk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CoffemilkApplication extends Application {
	public static ConfigurableApplicationContext applicationContext;
	public static Parent rootNode; //Nodo que inicializa la aplicación
	public static Stage stage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception { // escanea toda nuestra aplicacion y busca nuestras dependencias
		applicationContext = SpringApplication.run(CoffemilkApplication.class); //Esta corriendo la aplicación y escanea el paquete CoffeMilkApplication, entra al paquete y busca los Beans y los carga en el Application Context
		FXMLLoader loader = new FXMLLoader(CoffemilkApplication.class.getResource("/index.fxml"));
		loader.setControllerFactory(applicationContext::getBean); //carga las dependencias
		Scene scene = new Scene(loader.load(), 600, 400, false,SceneAntialiasing.BALANCED);

		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
