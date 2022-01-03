package no.entities;

public class User {

    private Long id;
    private Long idEmployee;
    private String userName;
    private String password;
    private String perfil;
    private String nivelAcesso;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(Long idEmployee, String userName, String password, String perfil, String nivelAcesso) {
        this.idEmployee = idEmployee;
        this.userName = userName;
        this.password = password;
        this.perfil = perfil;
        this.nivelAcesso = nivelAcesso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
}
