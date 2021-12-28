package no.desktopjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
    private ImageView closeImg;

    @FXML
    private Button closeButton;

    @FXML
    public void onLogin() throws IOException {
        Home home = new Home();
        home.start(new Stage());
        fechar();
    }

    @FXML
    public void onCancel(ActionEvent e){
        Stage stage = (Stage) closeImg.getScene().getWindow();
        Stage stage2 = (Stage) closeButton.getScene().getWindow();
        stage.close();
        stage2.close();
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
}
