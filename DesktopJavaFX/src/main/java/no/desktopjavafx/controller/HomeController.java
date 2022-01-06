package no.desktopjavafx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import no.desktopjavafx.Home;
import no.desktopjavafx.HomeEmployees;
import no.desktopjavafx.Login;

import java.io.IOException;

public class HomeController {


    @FXML
    private Button closeButton;

    @FXML
    private Button minimizeButton;

    @FXML
    private Circle logoBolaImage;

    @FXML
    private ImageView logoCarImage;

    @FXML
    private Button employeesButton;

    @FXML
    private Text logoLetraImage;

    @FXML
    private Label nomeLabel;


    @FXML
    private Button signOutButton;

    @FXML
    void onClose(ActionEvent event) {
        Home.getStage().close();
    }

    @FXML
    void onFechar(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void onMinimize(ActionEvent event) {
        Home.getStage().setIconified(true);
    }

    @FXML
    void onLogomarcaEnter(MouseEvent event){
       // logoBolaImage.setRadius(77);
      //  logoBolaImage.setRadius(79);

        logoCarImage.setFitWidth(96);
        logoCarImage.setFitHeight(65);
        logoCarImage.setFitWidth(105);
        logoCarImage.setFitHeight(74);

        //logoLetraImage.setFont(Font.font(25));//Font[name=Arial Bold, family=Arial, style=Bold, size=20.0]
        //logoLetraImage.setFont(Font.font("Arial"));//Font[name=Arial Bold, family=Arial, style=Bold, size=20.0]
        //logoLetraImage.setFont(Font.font("Arial", FontWeight.BOLD,22));//Font[name=Arial Bold, family=Arial, style=Bold, size=20.0]
        //logoLetraImage.setLayoutY(135);
    }

    @FXML
    void onLogomarcaOut(MouseEvent event){
       // logoBolaImage.setRadius(74);
        logoCarImage.setFitWidth(93);
        logoCarImage.setFitHeight(62);
       // logoLetraImage.setFont(Font.font("Arial", FontWeight.BOLD,20));//Font[name=Arial Bold, family=Arial, style=Bold, size=20.0]
       // logoLetraImage.setLayoutY(128);

    }


    @FXML
    void onLogin(ActionEvent event) throws IOException {
        Login login = new Login();
        login.start(new Stage());
        onClose(event);
    }

    @FXML
    void onEmployees(ActionEvent event) throws IOException {
        HomeEmployees homeEmployees = new HomeEmployees();
        homeEmployees.start(new Stage());
        onClose(event);
    }

}
