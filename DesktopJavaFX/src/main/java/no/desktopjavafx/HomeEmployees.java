package no.desktopjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HomeEmployees extends Application {

    private static Stage stage;//janela1
    private  static  Scene scene;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("homeadme.fxml"));//carrega xml
        scene = new Scene(root);//colona numa cena

        stage.initStyle(StageStyle.DECORATED.UNDECORATED);

        stage.setScene(scene);//colona numa janela2
        stage.show();//abre a janela

        setStage(stage);//coloca a janela no atributo do Main
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        HomeEmployees.stage = stage;
    }

    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        HomeEmployees.scene = scene;
    }
}