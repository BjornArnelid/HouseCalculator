module bjorn.arnelid.housecalculator.housecalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens bjorn.arnelid.housecalculator to javafx.fxml;
    exports bjorn.arnelid.housecalculator;
}