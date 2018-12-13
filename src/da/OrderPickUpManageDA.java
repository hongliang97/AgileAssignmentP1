/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import domain.PickUpOrderDomain;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Lim Yb
 */
public class OrderPickUpManageDA<T> implements InterfaceDA<T> {
    private String host = "jdbc:derby://localhost:1527/orderdb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "ORDERPICKUPMANAGE";
    private Connection conn;
    private PreparedStatement stmt;
    private Statement stmt2;
    
    public OrderPickUpManageDA(){
        createConnection();
    }
    public void add(PickUpOrderDomain domain){
        String insertStr = "INSERT INTO " + tableName + " VALUES(?,?,?,?)";
        ResultSet rs = (ResultSet) retrieve();
        try {
            int num = 0;
            if (!rs.next()){
                num = 3001;
            }else{
                rs.last();
                num = rs.getInt(1) + 1;
            }
            stmt = conn.prepareStatement(insertStr);
            stmt.setInt(1, num);
            stmt.setString(2, domain.getStatus());
            stmt.setString(3, domain.getTimeStamp());
            stmt.setInt(4, domain.getOrder().getOrderId());
         
            stmt.executeUpdate();
    }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
       
    public T retrieve(){
        String query = "SELECT * FROM " + tableName;
        ResultSet rs = null;
        try{
            rs = stmt2.executeQuery(query);
            
        }catch (SQLException ex) {
            ex.getMessage();
        }
       return (T) rs;
    }
    
    public ResultSet retrieveSelected(String id)  {   
        String queryStr = "SELECT * FROM " + tableName + " WHERE order_id = ?";
        ResultSet rs = null;
        try{
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }
    
    public void update(T data, T data2){
        String updateStr = "UPDATE " + tableName + " SET status = ?, time_stamp = ? WHERE order_id = ?";
        try{
            stmt = conn.prepareStatement(updateStr);
            stmt.setString(1, "Done");
            stmt.setString(2, (String) data2);
            stmt.setString(3, (String) data);
            stmt.executeUpdate();
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void delete(T data){
        
    }
    
    public void createConnection() {
        try { 
            conn = DriverManager.getConnection(host, user, password);
            stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
            ResultSet.CONCUR_READ_ONLY);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void shutDown() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public static void main(String[] args){
        OrderPickUpManageDA da = new OrderPickUpManageDA();
        ResultSet rs = null;
        rs = (ResultSet) da.retrieve();
        try{
            if (rs.last())
                System.out.println(rs.getString(4));
        
        }catch(SQLException ex){
            
        }
    }
}
