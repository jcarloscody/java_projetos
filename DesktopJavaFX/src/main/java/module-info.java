module no.desktopjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.dlsc.formsfx;
    requires java.sql;
    opens no.desktopjavafx to javafx.fxml;


    exports no.desktopjavafx;
    exports no.entities;

    exports no.database;
    exports no.desktopjavafx.controller;
    opens no.desktopjavafx.controller to javafx.fxml;
}

