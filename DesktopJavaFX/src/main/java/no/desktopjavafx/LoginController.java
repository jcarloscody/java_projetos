package no.desktopjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class LoginController {

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
    public void onLogin(){
        erroLabel.setText("Please enter username and password!");
    }

    @FXML
    public void onCancel(ActionEvent e){
        Stage stage = (Stage) closeImg.getScene().getWindow();
        Stage stage2 = (Stage) closeButton.getScene().getWindow();
        stage.close();
        stage2.close();
    }
}
