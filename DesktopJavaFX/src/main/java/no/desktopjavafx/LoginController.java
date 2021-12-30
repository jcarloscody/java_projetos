package no.desktopjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.Light;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.EventListener;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Label erroLabel;

    @FXML
    private TextField userNameTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button closeButton;

    @FXML
    private ImageView logoCarImage;

    @FXML
    public void onLogin() throws IOException {

        new Thread(){
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 3; i++) {
                        Login.getStage().setX(Login.xOffsetC - 2);
                        Login.getStage().setY(Login.yOffsetC);
                        sleep(20);
                        Login.getStage().setX(Login.xOffsetC + 2);
                        Login.getStage().setY(Login.yOffsetC);
                        sleep(20);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        Home home = new Home();
        home.start(new Stage());
        fechar();
    }

    @FXML
    public void onCancel(ActionEvent e){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cancelButton.setOnMouseClicked((MouseEvent e)->{
            fechar();
        });

        cancelButton.setOnKeyPressed((KeyEvent e)->{
            if (e.getCode()== KeyCode.ENTER){
                fechar();
            }
        });

        passwordField.setOnKeyPressed((KeyEvent e)->{
            if (e.getCode()== KeyCode.ENTER){
                try {
                    onLogin();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public void fechar(){
        Login.getStage().close();
    }

    @FXML
    void onLoginEnter(MouseEvent event) {
        logoCarImage.setFitWidth(99);
        logoCarImage.setFitHeight(115);
    }

    @FXML
    void onLoginOut(MouseEvent event) {
        logoCarImage.setFitWidth(94);
        logoCarImage.setFitHeight(101);
    }
}
