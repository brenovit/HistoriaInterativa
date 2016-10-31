package Controller;

import DTO.DtoUsuario;
import Model.UsuarioDao;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UsuarioFaces {
    private List<DtoUsuario> listaUsuarios = new LinkedList<DtoUsuario>();
    private UsuarioDao usuarioDao = usuarioDao = new UsuarioDao();
    private DtoUsuario dto = new DtoUsuario();
    
    private String erroMsg = "";
    private boolean user_logado = false;
    private int livroEscolhido = 0;    
       
    public int getlivroEscolhido (){
        return livroEscolhido;
    }
    
    public UsuarioFaces() {
        
    }
    
    public String mudarEstilo(){
        if(user_logado){
            return "";
        }
        return "apagado";
    }
    
     public String estaLogado(){
        if(!user_logado){
            return "";
        }
        return "apagado";
    }
    
    public void erroMsg(){
        erroMsg = "Deu erro";
    }
    
    public DtoUsuario getDto() {
        return dto;
    }
    
    public void setDto(DtoUsuario dto) {
        this.dto = dto;
    }
    
    public DtoUsuario ProcurarUsuario(){        
        return null;
    }
    
    public String voltarPrincipal(){
        dto = new DtoUsuario();
        return "VoltarPrincipal";
    }
    
    public String lerLivro(int numLivro){
        if(user_logado){
          livroEscolhido = numLivro;
        return "LerLivro";  
        }
        return "Cadastrar";
    }
    
    public String logar() throws ClassNotFoundException, SQLException {
        DtoUsuario temp = usuarioDao.getPorLogin(dto);
        String senha = Seguranca.GerarHASH(dto.getUSUA_Senha());
        if(temp != null){
            if(senha.equals(temp.getUSUA_Senha())){
                dto = temp;
                dto.setUSUA_Senha("");                
                user_logado = true;
                return "AcessarConta";
            }
        }
        return "";
    }

    public String cadastrarUsuario() throws ClassNotFoundException, SQLException {
        dto.setTPUS_ID(1);
        //String senha = Seguranca.GeneratePass(dto.getUSUA_Senha());
        //System.out.println("Senha: "+dto.getUSUA_Senha());
        //System.out.println("Hasgh: "+senha);
        dto.setUSUA_Senha(Seguranca.GerarHASH(dto.getUSUA_Senha()));
        usuarioDao.setAdicionar(dto);
        
        dto = new DtoUsuario();
        return "VoltarPrincipal";
    }

    public String alterarUsuario() {
        if(ProcurarUsuario() != null){
           listaUsuarios.remove(dto);
           listaUsuarios.add(dto);
        }
        return "Alterar";
    }

    public String deletarUsuario() {
        if(ProcurarUsuario() != null){
            listaUsuarios.remove(dto);
        }
        return "Excluir";
    }
    
    public String Sair(){
        if(user_logado){
            dto = new DtoUsuario();
            user_logado = false;
            return "Sair";
        }
        return "";
    }
}
