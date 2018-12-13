/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;
import domain.InvoicePayment;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;
/**
 *
 * @author liang
 */
public class InvoicePaymentDA {
    
    private String host = "jdbc:derby://localhost:1527/agile";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "INVOICE";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String sqlQueryStr = "SELECT * FROM " + tableName;
    
    public InvoicePaymentDA(){
    createConnection();
}
    public ArrayList<InvoicePayment> getStaff() {
         ArrayList<InvoicePayment> invoice = new ArrayList<InvoicePayment>();
         try{
             stmt = conn.prepareStatement(sqlQueryStr);
             rs = stmt.executeQuery();
             while (rs.next())
                 invoice.add(new InvoicePayment(rs.getString("INV_ID"),rs.getString("CUST_NAME"),rs.getString("PROD_NAME"),rs.getInt("QUANTITY"),rs.getDouble("TOTAL_PRICE"),
                         rs.getString("DATE_GENERATE"),rs.getString("STATUS"),rs.getString("Purpose")));
         }catch(SQLException ex){
             ex.getMessage();
         }
         return invoice;
    }
     private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            System.out.print("ERRROR");
        }
    }
     
     public void addRecord(InvoicePayment invoice){
        
        String insertStr = "INSERT INTO "+ tableName + "(INV_ID, CUST_NAME, PROD_NAME, QUANTITY, TOTAL_PRICE, DATE_GENERATE, STATUS, PURPOSE)"+" VALUES(?,?,?,?,?,?,?,?)";
        try{
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1,invoice.getInv_ID());
            stmt.setString(2,invoice.getCustomer());
            stmt.setString(3,invoice.getProduct());
            stmt.setString(4,String.valueOf(invoice.getQuantity()));
            stmt.setString(5,String.valueOf(invoice.getPrice()));
            stmt.setString(6,invoice.getDate_generate());
            stmt.setString(7,invoice.getStatus());
            stmt.setString(8,invoice.getPurpose());
            stmt.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
     
     public InvoicePayment invID(){
         String queryStr="SELECT * FROM " + tableName + " ORDER BY 'ROW_NUMBER()'";
        InvoicePayment ip = null;
        try {
            stmt = conn.prepareStatement(queryStr);
           
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()) {
                ip = new InvoicePayment(rs.getString(1));
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return ip;
    }
     public InvoicePayment getRecord(String id) {
        String queryStr = "SELECT * FROM " + tableName + "  WHERE INV_ID = ?";
        InvoicePayment ip = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
               ip = new InvoicePayment(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDouble(5),rs.getString(6),rs.getString(7),rs.getString(8));  
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return ip;
    }
     }

