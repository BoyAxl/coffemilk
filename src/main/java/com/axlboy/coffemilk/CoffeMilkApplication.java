package com.axlboy.coffemilk;

import com.axlboy.coffemilk.views.Login;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class CoffeMilkApplication extends Application {

	private ConfigurableApplicationContext applicationContext;

	@Override
	public void init() throws Exception {
		this.applicationContext = SpringApplication.run(CoffeMilkApplication.class);
	}

	@Override
	public void stop() throws Exception {
		this.applicationContext.close();
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Login.loadView(stage);
	}
}
