module no.desktopjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens no.desktopjavafx to javafx.fxml;
    exports no.desktopjavafx;


}