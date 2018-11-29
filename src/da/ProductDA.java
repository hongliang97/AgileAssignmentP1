/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import domain.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author liang
 */
public class ProductDA {
    private String host = "jdbc:derby://localhost:1527/agile";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "PRODUCT";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String sqlQueryStr = "SELECT * FROM " + tableName;
    
     public ProductDA(){
    createConnection();
    }
     
      public ArrayList<Product> getProd() {
         ArrayList<Product> p = new ArrayList<Product>();
         try{
             stmt = conn.prepareStatement(sqlQueryStr);
             rs = stmt.executeQuery();
             while (rs.next())
                 p.add(new Product(rs.getString("PROD_ID"),rs.getString("PROD_NAME"),rs.getDouble("PROD_PRICE"),rs.getString("PROD_DETAIL")));
         }catch(SQLException ex){
             ex.getMessage();
         }
         return p;
    }
    
    /*public ArrayList<Product> getProdRecord() {

        ArrayList<Product> p = new ArrayList<Product>();
        String queryStr="SELECT * FROM " + tableName;
        try {
            stmt = conn.prepareStatement(queryStr);
            rs = stmt.executeQuery();
            while (rs.next()) {
                p.add(getCurrentRecord());
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }

        return p;
    }*/

    public Product getCurrentRecord() {
       Product p = null;
        
        try {
           
            p = new Product(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getString(4));
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return p;
    }
    
    public Queue getRecord(String name){
        String queryStr = "SELECT * FROM " + tableName + " WHERE PROD_NAME = ?";
        
        Queue<Product> q = new LinkedList<>();
        Product p = null;
        try{
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, name);            
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                p = new Product(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getString(4));
            q.add(p);
            }else{
                System.out.println("No Record Found");
            }
        }catch (SQLException ex){
            System.out.println("Error Database");
        }
        return q;
    }
    
     private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            System.out.print("ERRROR");
        }
    }
}
