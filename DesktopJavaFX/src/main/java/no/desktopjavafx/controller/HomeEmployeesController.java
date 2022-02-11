package no.desktopjavafx.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import no.database.repository.EmployeeReposit;
import no.desktopjavafx.Home;
import no.desktopjavafx.HomeEmployees;
import no.desktopjavafx.Login;
import no.entities.Employee;
import no.services.EmployeServices;

import java.io.Console;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HomeEmployeesController implements Initializable {
    @FXML
    private Button closeButton;

    @FXML
    private TableColumn<Employee, String> cpfColumn;


    @FXML
    private TableColumn<Employee, Long> idColumn;

    @FXML
    private TextField cpfTextField;

    @FXML
    private Button homeButton;

    @FXML
    private Circle logoBolaImage;

    @FXML
    private ImageView logoCarImage;

    @FXML
    private Text logoLetraImage;

    @FXML
    private Button minimizeButton;

    @FXML
    private TableColumn<Employee, String> nomeColumn;

    @FXML
    private Label nomeLabel;

    @FXML
    private TextField nomeTextField;

    @FXML
    private Button deleteButton;

    @FXML
    private TableColumn<Employee, Double> salarioColumn;

    @FXML
    private Button atualizaButton;

    @FXML
    private Button salvarEdicaoButton;

    @FXML
    private TextField salarioTextField;

    @FXML
    private Button signOutButton;

    @FXML
    private TableView<Employee> tabela;

    @FXML
    private TextField salarioPesquisaTextField;

    @FXML
    private TextField nomePesquisaTextField;

    @FXML
    private TextField cpfPesquisaTextField;

    @FXML
    private Button pesquisaButton;

    @FXML
    private TextField pesquisaTextField;

    private Employee selecionadoEmployee;

    private ObservableList<Employee> employees = FXCollections.observableArrayList();

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
    void onFechar(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        HomeEmployees homeEmployees = new HomeEmployees();
        nomeLabel.setText(homeEmployees.getUserProgram().getUser().getUserName());
        initTable();

        deleteButton.setOnMouseClicked((MouseEvent e ) -> {
            nomePesquisaTextField.setText("");
            cpfPesquisaTextField.setText("");
            salarioPesquisaTextField.setText("");
            limpar ();
            delete();
        });

        atualizaButton.setOnMouseClicked((MouseEvent e ) -> {
            nomePesquisaTextField.setText("");
            cpfPesquisaTextField.setText("");
            salarioPesquisaTextField.setText("");
            limpar ();
            tabela.setItems(atualizaTabela());
        });

        tabela.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Employee>() {
            @Override
            public void changed(ObservableValue<? extends Employee> observable, Employee oldValue, Employee newValue) {
                selecionadoEmployee = (Employee) newValue != null ? newValue : oldValue;
                System.out.println((Employee) newValue);
                if (selecionadoEmployee.getNome() != null){
                    nomePesquisaTextField.setText(selecionadoEmployee.getNome());
                    cpfPesquisaTextField.setText(selecionadoEmployee.getCpf());
                    salarioPesquisaTextField.setText(String.valueOf(selecionadoEmployee.getSalario()));
                }

            }
        });

        salvarEdicaoButton.setOnMouseClicked((MouseEvent e)-> {
                Employee employee = new Employee();
                //System.out.println(nomePesquisaTextField.getText());
                employee.setId(selecionadoEmployee.getId());
                employee.setNome(nomePesquisaTextField.getText());
                employee.setSalario(Double.parseDouble(salarioPesquisaTextField.getText()));
                employee.setCpf(cpfPesquisaTextField.getText());
            try {
                //System.out.println(employee.getId());
                EmployeeReposit.updateEmployee(employee);
                nomePesquisaTextField.setText("");
                cpfPesquisaTextField.setText("");
                salarioPesquisaTextField.setText("");

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        pesquisaButton.setOnMouseClicked((MouseEvent e)-> {
            nomePesquisaTextField.setText("");
            cpfPesquisaTextField.setText("");
            salarioPesquisaTextField.setText("");
            limpar ();
            tabela.setItems(buscar());

        });
    }

    @FXML
    void salvar(ActionEvent event) throws SQLException {
        Employee employee = new Employee(nomeTextField.getText(), cpfTextField.getText(), Double.parseDouble(salarioTextField.getText()));
        EmployeServices.Insert(employee);
        nomeTextField.setText("");
        cpfTextField.setText("");
        salarioTextField.setText("");
    }

    public void initTable(){
        EmployeeReposit reposit = new EmployeeReposit();
        /*for (int x = 0; x < reposit.lista().size(); x++){
            System.out.println(reposit.lista().get(x).getId());
        }*/
        idColumn.setCellValueFactory(new PropertyValueFactory("id"));
        nomeColumn.setCellValueFactory(new PropertyValueFactory("nome"));
        salarioColumn.setCellValueFactory(new PropertyValueFactory("salario"));
        cpfColumn.setCellValueFactory(new PropertyValueFactory("cpf"));
        tabela.setItems(atualizaTabela());
    }

    public ObservableList<Employee> atualizaTabela(){
        EmployeeReposit reposit = new EmployeeReposit();
        employees = FXCollections.observableArrayList(reposit.lista());
        return employees;
    }

    public void delete(){
        EmployeeReposit reposit = new EmployeeReposit();
        if (selecionadoEmployee != null){
            reposit.delete(selecionadoEmployee);
        }
    }

    private ObservableList<Employee> buscar(){

        ObservableList<Employee> employeePesquisa = FXCollections.observableArrayList();

        for (int x = 0; x < employees.size(); x++){
            if (employees.get(x).getId() == Integer.parseInt(pesquisaTextField.getText())){
                employeePesquisa.add(employees.get(x));
            }
        }
        return  employeePesquisa;
    }

    private  void limpar (){
        nomePesquisaTextField.setText("");
        cpfPesquisaTextField.setText("");
        salarioPesquisaTextField.setText("");
    }
}
