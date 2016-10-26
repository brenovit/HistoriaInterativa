package DTO;

import java.util.Date;

public class DtoUsuario {
    private int idLeitor;
    private String nome;
    private String cpf;
    private Date dat_nasc;
    private String email;
    private String login;
    private String senha;
    
    public DtoUsuario() {
    }

    public DtoUsuario(int idLeitor, String nome, String cpf, Date dat_nasc, String email, String login, String senha) {
        this.idLeitor = idLeitor;
        this.nome = nome;
        this.cpf = cpf;
        this.dat_nasc = dat_nasc;
        this.email = email;
        this.login = login;
        this.senha = senha;
    }    
   
    public int getIdLeitor() {
        return idLeitor;
    }

    public void setIdLeitor(int idLeitor) {
        this.idLeitor = idLeitor;
    }

    public String getNome() {
        return nome;
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

    public Date getDat_nasc() {
        return dat_nasc;
    }

    public void setDat_nasc(Date dat_nasc) {
        this.dat_nasc = dat_nasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
