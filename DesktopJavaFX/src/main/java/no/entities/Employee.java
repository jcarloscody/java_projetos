package no.entities;

public class Employee {

    private Long id;
    private String nome;
    private  Double salario;
    private String cpf;

    public Employee( ) {

    }

    public Employee(String nome, String cpf,  double salario ) {
        this.cpf = cpf;
        this.nome = nome;
        this.salario = salario;
    }

    public Employee(Long id, String nome, String cpf,  double salario ) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.salario = salario;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
