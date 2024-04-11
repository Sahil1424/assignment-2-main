module com.example.catinfo {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens com.example.catinfo to javafx.fxml, com.google.gson; // Allow access to com.example.catinfo package from both JavaFX and Gson
    exports com.example.catinfo;
}
