package no.desktopjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Home extends Application {

    private static Stage stage;//janela1


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("homeadm.fxml"));//carrega xml
        Scene scene = new Scene(root);//colona numa cena

        stage.initStyle(StageStyle.DECORATED.UNDECORATED);

        stage.setScene(scene);//colona numa janela2
        stage.show();//abre a janela

        setStage(stage);//coloca a janela no atributo do Main
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Home.stage = stage;
    }
}
