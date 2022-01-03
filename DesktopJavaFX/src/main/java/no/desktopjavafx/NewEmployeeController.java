package no.desktopjavafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewEmployeeController {
    @FXML
    private Button backButton;

    @FXML
    private TextField nomeTextField;

    @FXML
    private Button saveButton;

    @FXML
    void onBack(ActionEvent event) {

        NewEmployee.getStage().close();
    }

    @FXML
    void onSave(ActionEvent event) {
        System.out.println(nomeTextField.getText());
    }

}
