module com.example.dynamiccomponents {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.patch;


    opens com.example.dynamiccomponents to javafx.fxml;
    exports com.example.dynamiccomponents;
}