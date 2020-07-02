/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingcrud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSellami
 */
public class ConnectionMySQL {
    Connection Connexion;
private static String CQLShema
            = "CREATE Database IF NOT EXISTS Covid19DB ;"
             
            + "CREATE TABLE IF NOT EXISTS Covid19DB.City("
            + "  IDCity integer PRIMARY KEY,"
            + "  CityName String,"
            + "  Longitude double,"
            + "  latitude double,"
            + "  population int"
            + ");";
    public ConnectionMySQL(String host,String user,String password) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        
            Connexion = DriverManager.getConnection("jdbc:mysql://"+host+":3306/covid", user, password);
          } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Close(){
        try {
            Connexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet ExecuteQuery(String SQL){
        ResultSet rs=null;
        try {
            Statement st = Connexion.createStatement();
              rs = st.executeQuery(SQL);
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public boolean UpdateQuery(String SQL){
        boolean res=false;
        try {
            Statement st = Connexion.createStatement();
             res = st.execute(SQL);
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    public void CreateDatabase(){
        
        this.UpdateQuery(CQLShema);
    }
}
