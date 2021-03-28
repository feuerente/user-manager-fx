module me.feuerente {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;

    opens me.feuerente to javafx.fxml;
    exports me.feuerente;
}
