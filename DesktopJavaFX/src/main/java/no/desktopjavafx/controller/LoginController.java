package no.desktopjavafx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Light;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import no.database.ConnectionFactory;
import no.desktopjavafx.Home;
import no.desktopjavafx.Login;
import no.entities.User;
import no.services.UserServices;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    private Hyperlink forgotPassHyperlink;

    @FXML
    public void onLogin() throws IOException, SQLException {

        String usuario = userNameTextField.getText();
        String password = passwordField.getText();
        User user = new User(usuario, password);
        ResultSet rs = UserServices.autenticationLogin(user);

        if (rs.next()){
            Home home = new Home();
            home.start(new Stage());
            fechar();
        }else{
            erroLabel.setText("username or password was wrong");
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
        }
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
                } catch (SQLException ex) {
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

    @FXML
    void onMouseForgotIn(MouseEvent event) {
        forgotPassHyperlink.setFont(Font.font("System", FontWeight.BOLD, 12));
    }

    @FXML
    void onMouseForgotOut(MouseEvent event) {
        forgotPassHyperlink.setFont(Font.font("System", FontWeight.NORMAL, 12));
    }
}
