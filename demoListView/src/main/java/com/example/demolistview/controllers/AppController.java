package com.example.demolistview.controllers;

import com.example.demolistview.services.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class AppController {

    @FXML
    private ListView<String> listView;
    @FXML
    private Label lblMsg;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtAge;

    @FXML
    private final ObservableList<String> data = FXCollections.observableArrayList();

    private PersonService service = new PersonService();

    @FXML
    public void initialize() {
        loadFromFile();
        listView.setItems(data);
    }

    @FXML
    private void onAddPerson() {
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            int age = Integer.parseInt(txtAge.getText());

            service.addPerson(name, email, age);

            lblMsg.setText("Datos cargados exitosamente");
            lblMsg.setStyle("-fx-text-fill: green");

            txtName.clear();
            txtEmail.clear();
            txtAge.clear();

            loadFromFile();

        } catch (NumberFormatException e) {
            lblMsg.setText("La edad debe ser un numero");
            lblMsg.setStyle("-fx-text-fill: red");
        } catch (IOException e) {
            lblMsg.setText("Hubo un error con el archivo");
            lblMsg.setStyle("-fx-text-fill: red");
        } catch (IllegalArgumentException ex) {
            lblMsg.setText(ex.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }

    private void loadFromFile() {
        try {
            List<String> items = service.loadDataforList();
            data.setAll(items);
            lblMsg.setText("Datos cargados exitosamente ");
            lblMsg.setStyle("-fx-text-fill: green");
        } catch (IOException e) {
            lblMsg.setText(e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }
}