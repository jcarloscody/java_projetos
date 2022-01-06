package no.desktopjavafx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import no.desktopjavafx.Home;
import no.desktopjavafx.HomeEmployees;
import no.desktopjavafx.Login;
import no.desktopjavafx.NewEmployee;

import java.io.IOException;

public class HomeEmployeesController {

    @FXML
    private Button closeButton;

    @FXML
    private Button homeButton;

    @FXML
    private Button minimizeButton;

    @FXML
    private Circle logoBolaImage;

    @FXML
    private ImageView logoCarImage;

    @FXML
    private Text logoLetraImage;

    @FXML
    private Label nomeLabel;

    @FXML
    private Button signOutButton;

    @FXML
    private Button newButton;


    @FXML
    void onClose(ActionEvent event) {
        HomeEmployees.getStage().close();
    }

    @FXML
    void onMinimize(ActionEvent event) {
        HomeEmployees.getStage().setIconified(true);
    }

    @FXML
    void onLogomarcaEnter(MouseEvent event){
        logoCarImage.setFitWidth(96);
        logoCarImage.setFitHeight(65);
        logoCarImage.setFitWidth(105);
        logoCarImage.setFitHeight(74);
    }

    @FXML
    void onLogomarcaOut(MouseEvent event){
        logoCarImage.setFitWidth(93);
        logoCarImage.setFitHeight(62);
    }


    @FXML
    void onLogin(ActionEvent event) throws IOException {
        Login login = new Login();
        login.start(new Stage());
        onClose(event);
    }

    @FXML
    void onHome(ActionEvent event) throws IOException {
        Home home = new Home();
        home.start(new Stage());
        onClose(event);
    }

    @FXML
    void onNew(ActionEvent event) throws IOException {
        HomeEmployees.getStage().toBack();
        NewEmployee newEmployee = new NewEmployee();
        newEmployee.start(new Stage());
    }

    @FXML
    void onFechar(ActionEvent event) {
        System.exit(0);
    }
}
