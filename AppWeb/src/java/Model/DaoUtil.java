package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoUtil {
    private Connection cx = null;
     
     public Connection getConnection() throws ClassNotFoundException, SQLException{     //contrutor com o padrão singleton, para uma conexão com o banco
          if (cx == null){
              String url = "";
              String usr = "";
              String psw = "";
              
              Class.forName("org.sqlite.JDBC");   
              cx = DriverManager.getConnection(url, usr, psw);
          }    
         return cx;
     }
     
     public void getFechaTudo() throws SQLException{
         if(cx != null){ // para fechar conecção
             cx.close();
             cx = null;
         }
     }
     
     public PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException{
         return this.getConnection().prepareStatement(sql);
     } 
    
     public Statement getStatement() throws ClassNotFoundException, SQLException{
         return this.getConnection().createStatement();
     } 
}
