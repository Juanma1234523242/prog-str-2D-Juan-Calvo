module com.example.demolistview {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demolistview to javafx.fxml;
    exports com.example.demolistview;
}