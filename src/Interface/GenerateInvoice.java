/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import da.ProductDA;
import domain.Product;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author liang
 */
public class GenerateInvoice {

    String date = new Date().toString();

    public GenerateInvoice() {
        int rowno = 0;
        int rowno1 = 0;

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/agile", "nbuser", "nbuser");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery("SELECT ORDER_ID, PROD_ID, QUANTITY, PRICE, DATE_ORDER FROM ORDER_ITEM WHERE CUST_ID = 'C0001' AND STATUS = 'UNPAID'");
            //ResultSet rs1 = stmt.executeQuery("SELECT PROD_ID, PROD_NAME FROM PRODUCT");
            ResultSetMetaData rsmd = rs.getMetaData();
            //ResultSetMetaData rsmd1 = rs1.getMetaData();
            int colno = rsmd.getColumnCount() + 1;
            int colno1 = 2;

            while (rs.next()) {
                rowno = rowno + 1;
            }
            
           
            rs.first();
           

            Document d = new Document();
            PdfWriter.getInstance(d, new FileOutputStream("INVOICEeee.pdf"));
            PdfPTable pt = new PdfPTable(colno);
            PdfPTable pt2 = new PdfPTable(colno1);

            d.open();
            SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = new java.util.Date();
            java.util.Date sqlDate = new java.util.Date(date.getTime());
            String aa = SDF.format(sqlDate);

            Paragraph p0 = new Paragraph("COMPANY NAME");
            p0.setAlignment(Element.ALIGN_CENTER);
            d.add(p0);
            Paragraph p1 = new Paragraph("TAR UNIVERSITY COLLEGE");
            p1.setAlignment(Element.ALIGN_CENTER);
            d.add(p1);
            Paragraph p2 = new Paragraph("Date Printed : " + aa);
            p2.setAlignment(Element.ALIGN_RIGHT);
            d.add(p2);

            Paragraph p3 = new Paragraph("Bill to: ABC SDN BHD");
            p3.setAlignment(Element.ALIGN_LEFT);
            
            d.add(p3);
            d.add(new Paragraph("Credit Limit: RM2000.00"));
//            p3.setAlignment(Element.ALIGN_LEFT);
//            d.add(p3);
//            Paragraph p4 = new Paragraph(rs1.getString(2));
//            p3.setAlignment(Element.ALIGN_LEFT);
//            d.add(p4);

            ProductDA productDA = new ProductDA();
            Product pro = new Product();

            d.add(new Paragraph(" "));

            pt.setWidthPercentage(110);
            pt.addCell("DATE ORDER");
            pt.addCell("ORDER ID");
            pt.addCell("PRODUCT ID");
            pt.addCell("PRODUCT NAME");
            pt.addCell("QUANTITY");
            pt.addCell("PRICE");
            
            double totalprice = 0;
            for (int i = 0; i < rowno; i++) {
                pt.addCell(rs.getString(5));
                pt.addCell(rs.getString(1));
                pt.addCell(rs.getString(2));
                pro = productDA.getSelectedRecord(rs.getString(2));
                pt.addCell(pro.getProd_name());
                pt.addCell(rs.getString(3));
                pt.addCell(rs.getString(4));
                totalprice +=rs.getDouble(4);
                rs.next();
            }
            
            
           
            d.add(pt);
            d.add(new Paragraph(" "));
            
            d.add(new Paragraph(" "));
            d.add(new Paragraph("Total Price: RM "+ totalprice));
            d.add(new Paragraph("Please make this payment before 7th. Thanks."));
            d.close();

        } catch (ClassNotFoundException ex) {

        } catch (SQLException ex) {

        } catch (DocumentException ex) {

        } catch (FileNotFoundException ex) {

        }
//      Class.forName("org.apache.derby.jdbc.ClientDriver");
//            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HBB", "nbuser", "nbuser");
//            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//           
//            ResultSet rs = stmt.executeQuery("SELECT BLOOD_ID, BLOOD_TYPE, BLOOD_DONATED, BLOOD_VOLUME, BLOOD_EXPIRYDATE FROM BLOOD_DONATION WHERE BLOOD_STATUS = 'Active'");
//            ResultSetMetaData rsmd = rs.getMetaData();
//            int colno = rsmd.getColumnCount();
//
//            while (rs.next()) {
//                rowno = rowno + 1;
//            }
//            rs.first();
//          
//            Document d = new Document();
//            PdfWriter.getInstance(d, new FileOutputStream("Blood Active Report.pdf"));
//            PdfPTable pt = new PdfPTable(colno);
//
//            d.open();
//            SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
//            java.util.Date date = new java.util.Date();
//            java.util.Date sqlDate = new java.util.Date(date.getTime());
//            String aa = SDF.format(sqlDate);
//            
//             Paragraph p0 = new Paragraph("Healthy Blood Bank");
//             p0.setAlignment(Element.ALIGN_CENTER);
//             d.add(p0);
//             Paragraph p1 = new Paragraph("Exception Report for Blood Active ");
//             p1.setAlignment(Element.ALIGN_CENTER);
//             d.add(p1);
//             Paragraph p2 = new Paragraph("Date Printed : " + aa);
//             p2.setAlignment(Element.ALIGN_RIGHT);
//             d.add(p2);
//
//              d.add(new Paragraph(" "));
//            
//                pt.setWidthPercentage(110);
//                pt.addCell("Blood ID");
//                pt.addCell("Blood type");
//                pt.addCell("Donated Date");
//                pt.addCell("Blood volume");
//                pt.addCell("Blood Expire");
//              
//                
//            for (int i = 0; i < rowno; i++) {
//             
//                pt.addCell(rs.getString(1));
//                pt.addCell(rs.getString(2));
//                pt.addCell(rs.getString(3));
//                pt.addCell(rs.getString(4));
//                pt.addCell(rs.getString(5));
//               
//                rs.next();
//            }
//
//            d.add(pt);
//            d.close();
//            
//        } catch (ClassNotFoundException ex){
//
//        } catch (SQLException ex) {
//
//        } catch (DocumentException ex) {
//
//        } catch (FileNotFoundException ex) {
//
//        }
    }

    public static void main(String[] args) {
        new GenerateInvoice();
    }
}
