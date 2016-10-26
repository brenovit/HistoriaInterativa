/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.DtoUsuario;
import Model.UsuarioDao;
import java.util.List;

/**
 *
 * @author Breno
 */
public class UsuarioFaces {

    private List<DtoUsuario> listaUsuarios = null;
    private UsuarioDao usuarioDao = new UsuarioDao();
    private DtoUsuario dto = new DtoUsuario();

    public UsuarioFaces() {
    }
    
    public DtoUsuario getDto() {
        return dto;
    }
    
    public void setDto(DtoUsuario dto) {
        this.dto = dto;
    }

    public List<DtoUsuario> getListaUsuarios() {
        /*if (listaUsuarios == null) {
            listaUsuarios = usuarioDao.getRetornaTodos();
        }*/
        return listaUsuarios;
    }

    public void setListaUsuarios(List<DtoUsuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    public String IrCadastro() {
        this.dto = new DtoUsuario();        
        return "Cadastrar";
    }

    public String CadastrarUsuario() {
        /*if (usuarioDao.setAdicionar(dto)) {
            this.listaUsuarios = null;
            //this.dto = null;
        }*/
        listaUsuarios.add(this.dto);
        
        return "Voltar";
    }

    public String AlterarUsuario() {
        /*if (usuarioDao.setAlterar(this.getDto())) {
            this.listaUsuarios = null;
        }*/
        listaUsuarios.remove(this.dto);
        listaUsuarios.add(this.dto);
        return "Alterar";
    }

    public String DeletarUsuario() {
        /*if (usuarioDao.setDeletar(dto)) {
            this.listaUsuarios = null;
        }*/
        listaUsuarios.remove(this.dto);
        return "Excluir";
    }
}
