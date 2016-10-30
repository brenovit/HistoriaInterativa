package DTO;

import java.util.Date;

public class DtoUsuario {
    private int USUA_ID;
    private String USUA_Nome;
    private String USUA_CPF;
    private Date USUA_DataNasc;
    private String USUA_Email;
    private String USUA_Login;
    private String USUA_Senha;
    private String confSenha;
    private int TPUS_ID;
    
    public DtoUsuario() {
    }
    
    public DtoUsuario(int USUA_ID, String USUA_Nome, String USUA_Email, String USUA_Login, String USUA_Senha, int TPUS_ID) {
        this.USUA_ID = USUA_ID;
        this.USUA_Nome = USUA_Nome;
        this.USUA_Email = USUA_Email;
        this.USUA_Login = USUA_Login;
        this.USUA_Senha = USUA_Senha;
        this.TPUS_ID = TPUS_ID;
    }
    
    public DtoUsuario(int USUA_ID, String USUA_Nome, String USUA_CPF, Date USUA_DataNasc, String USUA_Email, String USUA_Login, String USUA_Senha, String confSenha, int TPUS_ID) {
        this.USUA_ID = USUA_ID;
        this.USUA_Nome = USUA_Nome;
        this.USUA_CPF = USUA_CPF;
        this.USUA_DataNasc = USUA_DataNasc;
        this.USUA_Email = USUA_Email;
        this.USUA_Login = USUA_Login;
        this.USUA_Senha = USUA_Senha;
        this.confSenha = confSenha;
        this.TPUS_ID = TPUS_ID;
    }

    public int getUSUA_ID() {
        return USUA_ID;
    }

    public void setUSUA_ID(int USUA_ID) {
        this.USUA_ID = USUA_ID;
    }

    public String getUSUA_Nome() {
        return USUA_Nome;
    }

    public void setUSUA_Nome(String USUA_Nome) {
        this.USUA_Nome = USUA_Nome;
    }

    public String getUSUA_CPF() {
        return USUA_CPF;
    }

    public void setUSUA_CPF(String USUA_CPF) {
        this.USUA_CPF = USUA_CPF;
    }

    public Date getUSUA_DataNasc() {
        return USUA_DataNasc;
    }

    public void setUSUA_DataNasc(Date USUA_DataNasc) {
        this.USUA_DataNasc = USUA_DataNasc;
    }

    public String getUSUA_Email() {
        return USUA_Email;
    }

    public void setUSUA_Email(String USUA_Email) {
        this.USUA_Email = USUA_Email;
    }

    public String getUSUA_Login() {
        return USUA_Login;
    }

    public void setUSUA_Login(String USUA_Login) {
        this.USUA_Login = USUA_Login;
    }

    public String getUSUA_Senha() {
        return USUA_Senha;
    }

    public void setUSUA_Senha(String USUA_Senha) {
        this.USUA_Senha = USUA_Senha;
    }

    public String getConfSenha() {
        return confSenha;
    }

    public void setConfSenha(String confSenha) {
        this.confSenha = confSenha;
    }

    public int getTPUS_ID() {
        return TPUS_ID;
    }

    public void setTPUS_ID(int TPUS_ID) {
        this.TPUS_ID = TPUS_ID;
    }
}
