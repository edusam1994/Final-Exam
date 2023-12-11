module com.example.finalexam {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.finalexam to javafx.fxml;
    exports com.example.finalexam;
}