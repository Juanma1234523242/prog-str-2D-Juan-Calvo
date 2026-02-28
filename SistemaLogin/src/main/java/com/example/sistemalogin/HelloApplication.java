package com.example.sistemalogin;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        mostrarLogin();
    }

    public void mostrarLogin() {
        VBox layout = new VBox(15);
        layout.setPadding(new Insets(30));
        layout.setAlignment(Pos.CENTER);

        Label titulo = new Label("Iniciar Sesión");
        titulo.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        TextField txtCorreo = new TextField();
        txtCorreo.setPromptText("Correo electrónico");

        PasswordField txtPass = new PasswordField();
        txtPass.setPromptText("Contraseña");

        Label lblError = new Label();
        lblError.setTextFill(Color.RED);
        lblError.setWrapText(true);

        Button btnLogin = new Button("Entrar");

        btnLogin.setOnAction(e -> {
            String correo = txtCorreo.getText().trim();
            String pass = txtPass.getText();

            if (correo.length() < 4) {
                lblError.setText("Error: Usuario mín. 4 chars.");
            } else if (!correo.contains("@") || !correo.contains(".")) {
                lblError.setText("Error: Correo no válido (@ y .)");
            } else if (pass.length() < 6) {
                lblError.setText("Error: Password mín. 6 chars.");
            } else {
                String usuario = correo.split("@")[0];
                mostrarDashboard(usuario);
            }
        });

        layout.getChildren().addAll(titulo, txtCorreo, txtPass, lblError, btnLogin);

        Scene scene = new Scene(layout, 350, 300);
        primaryStage.setTitle("Sistema de Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void mostrarDashboard(String nombreUsuario) {
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Label lblBienvenida = new Label("Bienvenido, " + nombreUsuario);
        lblBienvenida.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        Button btnSalir = new Button("Cerrar Sesión");
        btnSalir.setOnAction(e -> mostrarLogin());

        layout.getChildren().addAll(lblBienvenida, btnSalir);

        Scene scene = new Scene(layout, 350, 300);
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}