package com.example.demolistview.controllers;

import com.example.demolistview.services.PersonService;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.List;

public class AppController {
    @FXML
    private ListView<String> ListView;
    @FXML
    private Label lblMsg;


    @FXML
    private final ObservableList<String> data = FXCollections.observableList();

    private PersonService service = new PersonService();

    @FXML
    private void initialize() {
        ListView.setItems(data);
        loadFromFile();

    }

    private void loadFromFile() {
        try {
            List<String> items = service.loadDataforList();
            data.setAll(items);
            lblMsg.setText("Datos cargados exitosamente");
        } catch (IOException e) {
            lblMsg.setText(e.getMessage());
        }
    }
}
