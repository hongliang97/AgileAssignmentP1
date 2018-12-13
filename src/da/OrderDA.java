/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;
import domain.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
/**
 *
 * @author user
 */
public class OrderDA {
    private String host = "jdbc:derby://localhost:1527/orderdb";
    private String user = "nbuser";
    private String password = "nbuser";
    private PreparedStatement pstmt;
    private Statement stmt;
    private Connection conn;
    private String tableName = "CUST_ORDER";
    
    public OrderDA(){
        initializeJdbc();
    }
    /* create connection */
    public void initializeJdbc() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(host, user, password);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
            ResultSet.CONCUR_READ_ONLY);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    

    public ResultSet getQuery()  {   
        String query = "SELECT * FROM " + tableName;
        ResultSet rs = null;
        try{
            rs = stmt.executeQuery(query);  
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
       return rs;
    }
    
    public ResultSet getSelectedQuery(String id)  {   
        String queryStr = "SELECT * FROM " + tableName + " WHERE order_id = ?";
        ResultSet rs = null;
        try{
            pstmt = conn.prepareStatement(queryStr);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }     
   
    public void addOrderRecord(CustOrder o){
        String queryStr = "INSERT INTO " + tableName + " VALUES(?,?,?,?,?,?,?,?,?,?)";
        try{
            pstmt = conn.prepareStatement(queryStr);
            pstmt.setString(1, String.format("%d",o.getOrderId()));
            pstmt.setString(2, o.getName());
            pstmt.setString(3, o.getEmail());
            pstmt.setString(4, o.getAddress());
            pstmt.setString(5, o.getCity());
            pstmt.setString(6, o.getState());
            pstmt.setString(7, o.getZip());
            pstmt.setString(8, o.getOrderDate());
            pstmt.setString(9, o.getMethod());
            pstmt.setString(10, String.format("%d",o.getCustId()));
           
            pstmt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
   
    public static void main(String[] args){
        OrderDA oDA = new OrderDA();
        oDA.addOrderRecord(null);
       
    }
}
