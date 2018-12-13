/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import da.InvoicePaymentDA;
import control.InvoicePaymentCtrl;
import da.CustomerMaintenanceDA;
import domain.CustomerMaintenance;
import control.CustomerMaintenanceCtrl;
import da.ProductDA;
import domain.Product;
import control.ProductCtrl;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;
import java.sql.ResultSet;


/**
 *
 * @author liang
 */
public class InvoicePayment extends JFrame{
    private DefaultComboBoxModel corporateName = new DefaultComboBoxModel();
    private JComboBox listCorporateName = new JComboBox (corporateName);
    private JTextField amount = new JTextField();
    private DefaultComboBoxModel prodName = new DefaultComboBoxModel();
    private String[] flowerType = {"Orchids","Rose"};
    private JComboBox listProdName = new JComboBox(flowerType);
    private JTextField purpose = new JTextField();
    private JButton btnConfirm = new JButton("Confirm");
    private JButton btnCancel = new JButton("Cancel");
    private ArrayList<CustomerMaintenance> corporateDetail;
    private ArrayList <Product> prodList;
    private JTextField id = new JTextField();
    private domain.InvoicePayment invPay;
    private CustomerMaintenance cm;
    private Product prod;
    private InvoicePaymentDA IPDA;
    private CustomerMaintenanceDA CMDA;
    private ProductDA prodDA;
    private CustomerMaintenanceCtrl CMC;
    private InvoicePaymentCtrl IPC;
    private ProductCtrl PC;
    
    public InvoicePayment(){
        CMC = new CustomerMaintenanceCtrl();
        IPC = new InvoicePaymentCtrl();
        PC = new ProductCtrl();
        IPDA = new InvoicePaymentDA();
        
        CustomerModel();
        //ProductModel();
        JPanel panel1 = new JPanel (new GridLayout (5,2));
        panel1.add(new JLabel("Invoice ID"));
        panel1.add(id);
        panel1.add(new JLabel("Corporate Comapany Name"));
        panel1.add(listCorporateName);
        panel1.add(new JLabel("Product Name"));
        panel1.add(listProdName);
        panel1.add(new JLabel("Quantity"));
        panel1.add(amount);
        panel1.add(new JLabel("Purpose"));
        panel1.add(purpose);
        add(panel1);
        JPanel panel2 = new JPanel (new GridLayout (1,2));
        panel2.add(btnConfirm);
        panel2.add(btnCancel);
        add(panel2,BorderLayout.SOUTH);
        btnCancel.addActionListener(new CancelListener());
        btnConfirm.addActionListener(new ConfirmListener());
        domain.InvoicePayment ip = IPC.AddID();
        String code = ip.getCode();
        String new_id = "I000" + (Integer.parseInt(code.substring(2,code.length()))+1);
        id.setText(new_id); 
    }
    
    private void CustomerModel(){
        corporateDetail = CMC.getCust();
        for(int i = 0 ; i < corporateDetail.size(); ++i){
            corporateName.addElement(corporateDetail.get(i).getCompany());
    } 
    }
    
    
/*    private void ProductModel(){
        prodList = prodDA.getProd();
        for(int i = 0 ; i < prodList.size(); ++i){
            prodName.addElement(prodList.get(i).getProd_name());
        }
    
    }*/
        private class CancelListener implements ActionListener{
        public void actionPerformed (ActionEvent e){
         dispose();
        }
        }
        
        private class ConfirmListener implements ActionListener{
        public void actionPerformed (ActionEvent e){
            SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = new java.util.Date();
            java.util.Date sqlDate = new java.util.Date(date.getTime());
            String aa = SDF.format(sqlDate);
            String item = (String) listProdName.getSelectedItem();
           
            int amt= 0;
            Double totalPrice = null;
            Double itemPrice;
            domain.InvoicePayment IP;
           
            amt = Integer.parseInt(amount.getText());
            if(item == "Orchids"){
                itemPrice = 10.00 ;
                totalPrice = (double)amt * itemPrice;  
            }else if(item == "Rose"){
                itemPrice = 5.00 ;
                totalPrice = (double)amt * itemPrice;  
            }else{
                
            }
            IP = new domain.InvoicePayment (id.getText(),listCorporateName.getSelectedItem().toString(),listProdName.getSelectedItem().toString(),Integer.parseInt(amount.getText()),totalPrice, aa ,"PENDING",purpose.getText());
            IPDA.addRecord(IP);
            JOptionPane.showMessageDialog(null, "TotalPrice of the items : RM " + totalPrice +". The receipt will print out.", "Success", JOptionPane.INFORMATION_MESSAGE);
            printReport();
            //ConfirmInvoicePayment CIP = new ConfirmInvoicePayment(Inv_id);
            // CIP.setTitle("Confirm Invoice");
            // CIP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            /// CIP.setSize(750, 450);
            //// CIP.setVisible(true);
            // CIP.setLocationRelativeTo(null);
            
        }
            private void printReport(){
                
                 int rowno = 0;
          
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/agile", "nbuser", "nbuser");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           
            ResultSet rs = stmt.executeQuery("SELECT INV_ID,CUST_NAME,PROD_NAME, QUANTITY, TOTAL_PRICE FROM INVOICE ORDER BY DESC FIRST 'ROW_NUMBER()' ");
            ResultSetMetaData rsmd = rs.getMetaData();
            int colno = rsmd.getColumnCount();

            while (rs.next()) {
                rowno = rowno + 1;
            }
            rs.first();
          
            Document d = new Document();
            PdfWriter.getInstance(d, new FileOutputStream("Invoice.pdf"));
            PdfPTable pt = new PdfPTable(colno);

            d.open();
            SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = new java.util.Date();
            java.util.Date sqlDate = new java.util.Date(date.getTime());
            String aa = SDF.format(sqlDate);
            
             Paragraph p0 = new Paragraph("Company Name");
             p0.setAlignment(Element.ALIGN_CENTER);
             d.add(p0);
             Paragraph p1 = new Paragraph("INVOICE ");
             p1.setAlignment(Element.ALIGN_CENTER);
             d.add(p1);
             Paragraph p2 = new Paragraph("Date Printed : " + aa);
             p2.setAlignment(Element.ALIGN_RIGHT);
             d.add(p2);

              d.add(new Paragraph(" "));
            
                pt.setWidthPercentage(110);
                pt.addCell("Invoice ID");
                pt.addCell("Customer Name");
                pt.addCell("Product Name");
                pt.addCell("Quantity");
                pt.addCell("Total Price");
              
                
            for (int i = 0; i < rowno; i++) {
             
                pt.addCell(rs.getString(1));
                pt.addCell(rs.getString(2));
                pt.addCell(rs.getString(3));
                pt.addCell(rs.getString(4));
                pt.addCell(rs.getString(5));
               
                rs.next();
            }

            d.add(pt);
            d.close();
            
        } catch (ClassNotFoundException ex){

        } catch (SQLException ex) {

        } catch (DocumentException ex) {

        } catch (FileNotFoundException ex) {

        }
            }
            
        }
        
    
    public static void main(String[] main){
        InvoicePayment IP = new InvoicePayment();
        IP.setTitle("Add Invoice");
        IP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        IP.setSize(750, 450);
        IP.setVisible(true);
        IP.setLocationRelativeTo(null);
    }
}
