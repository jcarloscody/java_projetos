module no.desktopjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.dlsc.formsfx;
    requires java.sql;
    opens no.desktopjavafx to javafx.fxml;


    exports no.desktopjavafx;
    exports no.database;
}

