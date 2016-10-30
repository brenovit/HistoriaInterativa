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
    
    public UsuarioFaces() {
        
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
    
    public String logar() throws ClassNotFoundException, SQLException {
        DtoUsuario temp = usuarioDao.getPorLogin(dto);
        if(temp != null){
            if(dto.getUSUA_Senha().equals(temp.getUSUA_Senha())){
                dto = temp;
                return "AcessarConta";
            }
        }
        return "";
    }

    public String cadastrarUsuario() throws ClassNotFoundException, SQLException {
        dto.setTPUS_ID(1);
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
}
