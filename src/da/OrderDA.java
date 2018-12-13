/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;
import domain.Order;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import domain.CustomerMaintenance;
import domain.Product;
import javax.swing.JOptionPane;
import control.OrderCtrl;
import control.ProductCtrl;
import control.CustomerMaintenanceCtrl;

/**
 *
 * @author liang
 */
public class OrderDA {
    private String host = "jdbc:derby://localhost:1527/agile";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "ORDER_ITEM";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String sqlQueryStr = "SELECT * FROM " + tableName;
    private CustomerMaintenanceCtrl cust;
    private ProductCtrl prodCtrl;
    
    public OrderDA(){
    createConnection();
    cust = new CustomerMaintenanceCtrl();
    prodCtrl = new ProductCtrl();
}
    
     private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            System.out.print("ERRROR");
        }
    }
     
      public void addRecord(Order order){
        
        String insertStr = "INSERT INTO "+ tableName + " VALUES(?,?,?,?,?,?,?,?)";
        try{
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1,order.getOrderNo());
            stmt.setString(2,order.getOrderID());
            stmt.setString(3,order.getCustID());
            stmt.setString(4,order.getProd_ID());
            stmt.setString(5,String.valueOf(order.getQuantity()));
            stmt.setString(6,String.valueOf(order.getPrice()));
            stmt.setString(7,order.getDateOrder());
            stmt.setString(8,order.getStatus());
            
            
            stmt.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
      
      public Order orderID(){
         String queryStr="SELECT ORDER_NO, ORDER_ID FROM " + tableName + " ORDER BY ORDER_NO DESC FETCH FIRST ROW ONLY";
        Order order = null;
        try {
            stmt = conn.prepareStatement(queryStr);
           
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()) {
                order = new Order(rs.getString(1),rs.getString(2));
              
                
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return order;
    }
      
//      public Order orderNo(){
//         String queryStr="SELECT ORDER_NO FROM " + tableName + " ORDER BY 'ROW_NUMBER()'";
//        Order order = null;
//        try {
//            stmt = conn.prepareStatement(queryStr);
//           
//            ResultSet rs = stmt.executeQuery();
//            
//            if(rs.next()) {
//                order = new Order(rs.getString(1));
                
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
//        }
//        return order;
//    }
      
      public Order getRecord(String id) {
        String queryStr = "SELECT * FROM " + tableName + "  WHERE ORDER_ID = ?";
        Order order = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                CustomerMaintenance cust2 = cust.selectRecord(rs.getString("CUST_ID"));
                Product p = prodCtrl.selectRecord(rs.getString("PROD_ID"));
               order = new Order(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getDouble(6),rs.getString(7),rs.getString(8));  
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return order;
    }
      
      
}
