module com.example.sistemalogin {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sistemalogin to javafx.fxml;
    exports com.example.sistemalogin;
}