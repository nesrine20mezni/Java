/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isetj.guicassandra.gui;
 
 
 
import swingcrud.jpa.nosql.*;
import com.datastax.driver.core.ResultSet;
import swingcrud.Crud;
import swingcrud.dao.CassandraConnector;
import swingcrud.model.Region;

/**
 *
 * @author MSellami
 */
public class RegionEntityNoSQL1 extends Region {
    
    public RegionEntityNoSQL1(int id, String name, String longitude, String latitude, int pop, int confirmes, int morts) {
        super(id, name, longitude, latitude, pop, confirmes, morts);
    }
    
    //method to save region to the db
    public static ResultSet saveRegion(int id, String fname, String longitude, String latitude, int pop, int confirmes, int morts) {
         
              String sql = "INSERT INTO Covid19DB.regions"
                    + "VALUES ('" + id + "','" + fname + "','" + longitude + "','" + latitude + "'," + pop + ",'" + confirmes + "','" + morts + "')";
        
        return  CassandraConnector.ExecuteQuery(sql);
               
         
    }

    //update the db
    public static ResultSet updateRegion(int id, String fname, String longitude, String latitude, int pop, int conf, int morts) {
        
             String sql = "UPDATE  Covid19DB.regions SET name='" + fname + "',longitude='" + longitude + "',latitude='" + latitude + "',population='" + pop + "',confirmes='" + conf + "',morts='" + morts
                    + "'WHERE id='" + id + "'";
             return  CassandraConnector.ExecuteQuery(sql);
        
    }

    //delete details in the db
    public static ResultSet deleteRegion(String id) {
        
             String sql = "DELETE FROM Covid19DB.regions WHERE id='" + id + "'";
             
      return  CassandraConnector.ExecuteQuery(sql);
    }

   public static ResultSet selectRegionbyID(int id) {
       String sql = "select * from Covid19DB.regions where id='" + id + "'";
       return  CassandraConnector.ExecuteQuery(sql);
   }
    public static ResultSet selectAllRegion() {
       String sql = "select * from Covid19DB.regions";
       return  CassandraConnector.ExecuteQuery(sql);
   }
}
