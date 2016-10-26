package Controller;

import DTO.DtoUsuario;
import java.util.LinkedList;
import java.util.List;
import org.apache.jasper.tagplugins.jstl.ForEach;

public class UsuarioFaces {
    private List<DtoUsuario> listaUsuarios = new LinkedList<DtoUsuario>();
    //private UsuarioDao usuarioDao = usuarioDao = new UsuarioDao();
    private DtoUsuario dto = new DtoUsuario();

    public UsuarioFaces() {
        
    }
    
    public DtoUsuario getDto() {
        return dto;
    }
    
    public void setDto(DtoUsuario dto) {
        this.dto = dto;
    }
    
    public DtoUsuario ProcurarUsuario(){
        for(DtoUsuario user : listaUsuarios){
            if(user.getLogin().equals(dto.getLogin())){
                System.out.println("====== Encontrado ======");
                System.out.println("User - Login:"+user.getLogin());
                System.out.println("User - Senha:"+user.getSenha());
                return user;
            }
        }
        return null;
    }
    
    public String voltarPrincipal(){
        dto = new DtoUsuario();
        return "VoltarPrincipal";
        
    }
    
    public String logar() {
        DtoUsuario temp = ProcurarUsuario();
        if(temp != null){
            if(dto.getLogin().equals(temp.getLogin()) && dto.getSenha().equals(temp.getSenha())){
                dto = temp;
                return "LogadoSucesso";
            }
        }
        return "";
    }

    public String cadastrarUsuario() {
        listaUsuarios.add(dto);        
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
