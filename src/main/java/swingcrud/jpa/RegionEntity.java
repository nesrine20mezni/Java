/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingcrud.jpa;

import java.sql.ResultSet;
import java.util.logging.Logger;
import swingcrud.Crud;
import swingcrud.model.Region;

/**
 *
 * @author MSellami
 */
public class RegionEntity extends Region {
    
    public RegionEntity(int id, String name, String longitude, String latitude, int pop, int confirmes, int morts) {
        super(id, name, longitude, latitude, pop, confirmes, morts);
    }
    
    //method to save region to the db
    public static boolean saveRegion(int id, String fname, String longitude, String latitude, int pop, int confirmes, int morts) {
         
              String sql = "INSERT INTO `regions`"
                    + "VALUES ('" + id + "','" + fname + "','" + longitude + "','" + latitude + "'," + pop + ",'" + confirmes + "','" + morts + "')";
        return Crud.ConnexionMySQL.UpdateQuery(sql);
//         
         
    }

    //update the db
    public static boolean updateRegion(int id, String fname, String longitude, String latitude, int pop, int conf, int morts) {
        
             String sql = "UPDATE `regions`SET name='" + fname + "',longitude='" + longitude + "',latitude='" + latitude + "',population='" + pop + "',confirmes='" + conf + "',morts='" + morts
                    + "'WHERE id='" + id + "'";
            return Crud.ConnexionMySQL.UpdateQuery(sql);
        
    }

    //delete details in the db
    public static boolean deleteRegion(String id) {
        
             String sql = "DELETE FROM `regions` WHERE id='" + id + "'";
             
        return Crud.ConnexionMySQL.UpdateQuery(sql);
    }

   public static ResultSet selectRegionbyID(int id) {
       String sql = "select * from regions where id='" + id + "'";
       return Crud.ConnexionMySQL.ExecuteQuery(sql);
   }
    public static ResultSet selectAllRegion() {
       String sql = "select * from regions";
       return Crud.ConnexionMySQL.ExecuteQuery(sql);
   }
}
