package Model;

import DTO.DtoUsuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UsuarioDao extends DaoUtil{

    public UsuarioDao() {
        super();
    }
    
   public boolean setAdicionar(DtoUsuario user) throws ClassNotFoundException, SQLException{ 
       String sql = "INSERT INTO Usuario (usua_nome, usua_login, usua_senha, usua_email, tpus_id) values (?,?,?,?,?)";
       PreparedStatement ps = super.getPreparedStatement(sql);
       ps.setString(1, user.getUSUA_Nome());
       ps.setString(2, user.getUSUA_Login());
       ps.setString(3, user.getUSUA_Senha());
       ps.setString(4, user.getUSUA_Email());
       ps.setInt(5, user.getTPUS_ID());
       int ret = ps.executeUpdate();
       ps.close();
       return ret > 0; 
   }
   
   public boolean setAlterar(DtoUsuario user) throws ClassNotFoundException, SQLException{
        String sql = "UPDATE Usuario SET "+
                     "USUA_Nome = ?, USUA_Login = ?, USUA_Senha = ? " + 
                     "WHERE USUA_ID = ?";
        
         PreparedStatement ps = super.getPreparedStatement(sql);
         ps.setString(1,user.getUSUA_Nome());
         ps.setString(2, user.getUSUA_Login());
         ps.setString(3,user.getUSUA_Senha());
         ps.setInt (4, user.getUSUA_ID());
        
         int ret = ps.executeUpdate();
         ps.close();
         
         return ret > 0; // retorna se foi sucesso ou não a incersão de objeto 
    }
    
    public boolean setDeletar(DtoUsuario user) throws ClassNotFoundException, SQLException{
        String sql = "DELETE FROM Usuario "+
                     "WHERE USUA_ID = ?";
        
         PreparedStatement ps = super.getPreparedStatement(sql);
         ps.setInt (1, user.getUSUA_ID());
         int ret = ps.executeUpdate();
         ps.close();
         
         return ret > 0; // retanar se foi sucesso ou não a incesão de ob 
    }
    
    public List<DtoUsuario> getRetornaTodos() throws ClassNotFoundException, SQLException{
        List<DtoUsuario> lstRet = new LinkedList<DtoUsuario>();
        String sql = "SELECT USUA_ID, USUA_Nome, USUA_Login, USUA_Senha, USUA_Email, TPUS_ID FROM Usuario";
        
        ResultSet rs = super.getStatement().executeQuery(sql);
        while(rs.next()){
            lstRet.add(new DtoUsuario(rs.getInt("USUA_ID"),
                                      rs.getString("USUA_Nome"),
                                      rs.getString("USUA_Email"),
                                      rs.getString("USUA_Login"),
                                      rs.getString("USUA_Senha"),
                                      rs.getInt("TPUS_ID")));
        }
        rs.close();
        super.getFechaTudo();
        return lstRet;
    }
    
    public DtoUsuario getPorId(DtoUsuario user) throws ClassNotFoundException, SQLException{
        DtoUsuario dtoUser = new DtoUsuario();
        String sql = "SELECT USUA_ID, USUA_Nome, USUA_Login, USUA_Senha, USUA_Email, TPUS_ID FROM Usuario " + 
                      "WHERE USUA_ID = ?";
        PreparedStatement ps = super.getPreparedStatement(sql);
        ps.setInt(1, user.getUSUA_ID());
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            dtoUser.setUSUA_ID(rs.getInt("USUA_ID"));
            dtoUser.setUSUA_Nome(rs.getString("USUA_Nome"));
            dtoUser.setUSUA_Login(rs.getString("USUA_Login"));
            dtoUser.setUSUA_Senha(rs.getString("USUA_Senha"));
            dtoUser.setUSUA_Email(rs.getString("USUA_Email"));
            dtoUser.setTPUS_ID(rs.getInt("TPUS_ID"));
        }
        rs.close();
        super.getFechaTudo();
        return dtoUser;
    }
    
    public DtoUsuario getPorLogin(DtoUsuario user) throws ClassNotFoundException, SQLException{
        DtoUsuario dtoUser = new DtoUsuario();
        String sql = "SELECT USUA_ID, USUA_Nome, USUA_Login, USUA_Senha, USUA_Email, TPUS_ID FROM Usuario " + 
                      "WHERE USUA_Login = ?";
        PreparedStatement ps = super.getPreparedStatement(sql);
        ps.setString(1, user.getUSUA_Login());
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            dtoUser.setUSUA_ID(rs.getInt("USUA_ID"));
            dtoUser.setUSUA_Nome(rs.getString("USUA_Nome"));
            dtoUser.setUSUA_Login(rs.getString("USUA_Login"));
            dtoUser.setUSUA_Senha(rs.getString("USUA_Senha"));
            dtoUser.setUSUA_Email(rs.getString("USUA_Email"));
            dtoUser.setTPUS_ID(rs.getInt("TPUS_ID"));
        }
        rs.close();
        super.getFechaTudo();
        return dtoUser;
    }    
}
