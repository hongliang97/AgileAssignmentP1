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
import java.util.List;
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
     
//      public ArrayList<Product> getProd() {
//         ArrayList<Product> p = new ArrayList<Product>();
//         try{
//             stmt = conn.prepareStatement(sqlQueryStr);
//             rs = stmt.executeQuery();
//             while (rs.next())
//                 p.add(new Product(rs.getString("PROD_ID"),rs.getString("PROD_NAME"),rs.getDouble("PROD_PRICE"),rs.getString("PROD_DETAIL")));
//         }catch(SQLException ex){
//             ex.getMessage();
//         }
//         return p;
//    }
//    
//    public ArrayList<Product> getProdRecord() {
//
//        ArrayList<Product> p = new ArrayList<Product>();
//        String queryStr="SELECT * FROM " + tableName;
//        try {
//            stmt = conn.prepareStatement(queryStr);
//            rs = stmt.executeQuery();
//            while (rs.next()) {
//                p.add(getCurrentRecord());
//            }
//        } catch (SQLException ex) {
//            ex.getMessage();
//        }
//
//        return p;
//    }
//
//    public Product getCurrentRecord() {
//       Product p = null;
//        
//        try {
//           
//            p = new Product(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getString(4));
//        } catch (SQLException ex) {
//            ex.getMessage();
//        }
//        return p;
//    }
//    public Double getPrice(String name){
//        String queryStr="SELECT * FROM " + tableName + " WHERE PROD_NAME = ?'";
//        Double p = null;
//        try {
//            stmt = conn.prepareStatement(queryStr);
//           
//            ResultSet rs = stmt.executeQuery();
//            
//            if(rs.next()) {
//                p = rs.getDouble("Prod_price");
//                
//            }
//        } catch (SQLException ex) {
//            System.out.println("Error database");
//        }
//        return p;
//    }
//        
//    public Queue getRecord(String name){
//        String queryStr = "SELECT * FROM " + tableName + " WHERE PROD_NAME = ?";
//        
//        Queue<Product> q = new LinkedList<>();
//        Product p = null;
//        try{
//            stmt = conn.prepareStatement(queryStr);
//            stmt.setString(1, name);            
//            ResultSet rs = stmt.executeQuery();
//            if(rs.next()){
//                p = new Product(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getString(4));
//            q.add(p);
//            }else{
//                System.out.println("No Record Found");
//            }
//        }catch (SQLException ex){
//            System.out.println("Error Database");
//        }
//        return q;
//    }
//    
     public List<Product> getRecordList() {
        String queryStr = "SELECT * FROM " + tableName;
        List<Product> productList = new ArrayList<Product>();
        try {
            stmt = conn.prepareStatement(queryStr);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Product product = new Product(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4));
                productList.add(product);
            }
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return productList;
    }
    
    public Product getRecord(String name) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE Prod_name = ?";
        Product product = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                product = new Product(rs.getString(1), name, rs.getDouble(3), rs.getString(4));
            }
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return product;
    }
    
    public Product getSelectedRecord(String id) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE Prod_id = ?";
        Product product = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                product = new Product(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4));
            }
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return product;
    }
    
    public void addRecord(Product p){
        String insertStr = "INSERT INTO " + tableName + " VALUES(?,?,?,?)";
        try{
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1, p.getProd_ID());
            stmt.setString(2, p.getProd_name());
            stmt.setDouble(3, p.getProd_price());
            stmt.setString(4, p.getProd_detail());
            stmt.executeUpdate();
                    
        }catch(SQLException ex){
            //JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR);
        }
    }
    
    public void updateRecord(Product p){
        try{
            String updateStr = "UPDATE " + tableName + " SET Prod_name = ? , Prod_Price = ? , Prod_detail = ? WHERE Prod_id = ?";
                stmt = conn.prepareStatement(updateStr);
                stmt.setString(1, p.getProd_name());
                stmt.setDouble(2, p.getProd_price());
                stmt.setString(3, p.getProd_detail());
                stmt.setString(4, p.getProd_ID());
                stmt.executeUpdate();
        }catch(SQLException ex){
            //JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR);
        }
    }
    
    public void deleteRecord(String id){
            String deleteStr = "DELETE FROM " + tableName + " WHERE Prod_id = ?";
            Product product = null;
             try{
                        stmt = conn.prepareStatement(deleteStr);
                        stmt.setString(1, id);
                        stmt.executeUpdate();
                        
             }catch(SQLException ex){
                 //JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    private void shutDown() {
        if (conn != null)
            try {
            conn.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
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
