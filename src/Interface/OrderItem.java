/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import domain.Product;
import domain.CustomerMaintenance;
import control.CustomerMaintenanceCtrl;
import control.ProductCtrl;
import control.OrderCtrl;
import da.CustomerMaintenanceDA;
import da.ProductDA;
import da.OrderDA;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import domain.Order;
import Interface.GenerateInvoice;
import Interface.Generate_Invoice;

/**
 *
 * @author liang
 */
public class OrderItem extends JFrame {

    private DefaultComboBoxModel corporateName = new DefaultComboBoxModel();
    private JComboBox listCorporateName = new JComboBox(corporateName);
    private JTextField amount = new JTextField();
    private DefaultComboBoxModel prodName = new DefaultComboBoxModel();
    private JComboBox listProduct = new JComboBox(prodName);
    private JTextField purpose = new JTextField();
    private JButton btnConfirm = new JButton("Confirm");
    private JButton btnCancel = new JButton("Cancel");
    private ArrayList<CustomerMaintenance> corporateDetail;
    private java.util.List<Product> productList = new ArrayList<Product>();
    private JTextField id = new JTextField();
    private JButton btnAdd = new JButton("Add");
    private JTextField orderNo = new JTextField();
    private CustomerMaintenance cm;
    private Product prod;
    private CustomerMaintenanceCtrl custControl;
    private ProductCtrl prodControl;
    private CustomerMaintenanceDA CMDA;
    private OrderDA orderDA;
    private Order order;
    private ProductDA prodDA;

    public OrderItem() {
        custControl = new CustomerMaintenanceCtrl();
        prodControl = new ProductCtrl();
        orderDA = new OrderDA();
        CMDA = new CustomerMaintenanceDA();
        prodDA = new ProductDA();

        CustomerModel();
        ProductModel();
        JPanel panel1 = new JPanel(new GridLayout(5, 2));
        panel1.add(new JLabel("Order ID"));
        panel1.add(id);
        panel1.add(new JLabel("Corporate Comapany Name"));
        panel1.add(listCorporateName);
        panel1.add(new JLabel("Product Name"));
        panel1.add(listProduct);
        panel1.add(new JLabel("Quantity"));
        panel1.add(amount);
        add(panel1);
        JPanel panel2 = new JPanel();
        panel2.add(btnAdd);
        panel2.add(btnConfirm);
        panel2.add(btnCancel);
        add(panel2, BorderLayout.SOUTH);
        btnAdd.addActionListener(new AddListener());
        btnCancel.addActionListener(new CancelListener());
        btnConfirm.addActionListener(new ConfirmListener());
        domain.Order order = orderDA.orderID();
//        domain.Order order2 = orderDA.orderNo();
        String code = order.getCode();
        int numid = Integer.parseInt(order.getID());
        String numid2 = Integer.toString(numid + 1);
        System.out.println(numid2);
        panel2.add(orderNo);
        orderNo.setText(numid2);
        orderNo.setVisible(false);
        String new_id = "O00" + (Integer.parseInt(code.substring(2, code.length())) + 1);
        id.setText(new_id);
        id.setEditable(false);
    }

    private class AddListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = new java.util.Date();
            java.util.Date sqlDate = new java.util.Date(date.getTime());
            String aa = SDF.format(sqlDate);
            String item = (String) listProduct.getSelectedItem();
            String ppl = (String) listCorporateName.getSelectedItem();
            int amt = 0;
            double totalPrice = 0;
            double itemPrice = 0;
            double creditlimit = 0;
            OrderItem order = new OrderItem();
            amt = Integer.parseInt(amount.getText());

            ProductDA productDA = new ProductDA();
            CustomerMaintenanceDA customerDA = new CustomerMaintenanceDA();
            Product product = productDA.getRecord(item);

            CustomerMaintenance cm2 = customerDA.selectRecord(ppl);

            //itemPrice = new Double(itemPrice2).doubleValue();
            totalPrice = amt * product.getProd_price();
            creditlimit = cm2.getCreditLimit() - totalPrice;
            if (creditlimit < 0) {
                JOptionPane.showMessageDialog(null, "Reach credit limit! System will jump to invoice page", "ERROR", JOptionPane.ERROR_MESSAGE);
                InvoiceOption IO = new InvoiceOption();
                IO.setTitle("Invoice");
                IO.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                IO.setSize(250, 150);
                IO.setVisible(true);
                IO.setLocationRelativeTo(null);
                dispose();
            
            } else {
                //CustomerMaintenance cm = corporateDetail.get(listCorporateName.getSelectedIndex());
                CustomerMaintenance cm = new CustomerMaintenance(ppl);
                CustomerMaintenanceDA cmDA = new CustomerMaintenanceDA();
                Product p = productList.get(listProduct.getSelectedIndex());

                cm.setCreditLimit(creditlimit);

                //Product p2 = prodControl.selectRecord(p.getProd_ID());
                //order = new Order(id.getText(),cust2.getCustID(),product.getProd_ID(),Integer.parseInt(amount.getText()),totalPrice, aa ,"UNPAID");
                Order order2 = new Order(orderNo.getText(), id.getText(), "C0001", product.getProd_ID(), Integer.parseInt(amount.getText()), totalPrice, aa, "UNPAID");
                orderDA.addRecord(order2);
                cmDA.updateRecord(cm);
                String ordernum = orderNo.getText();
                int ordernum2 = Integer.parseInt(ordernum);
                String orderNum = Integer.toString(ordernum2 + 1);
                orderNo.setText(orderNum);
                clearText();

            }

        }

    }

    private class CancelListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

    private class ConfirmListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = new java.util.Date();
            java.util.Date sqlDate = new java.util.Date(date.getTime());
            String aa = SDF.format(sqlDate);
            String item = (String) listProduct.getSelectedItem();
            String ppl = (String) listCorporateName.getSelectedItem();
            int amt = 0;
            double totalPrice = 0;
            double itemPrice = 0;
            double creditlimit = 0;
            OrderItem order = new OrderItem();
            amt = Integer.parseInt(amount.getText());

            ProductDA productDA = new ProductDA();
            CustomerMaintenanceDA customerDA = new CustomerMaintenanceDA();
            Product product = productDA.getRecord(item);

            CustomerMaintenance cm2 = customerDA.selectRecord(ppl);

            //itemPrice = new Double(itemPrice2).doubleValue();
            totalPrice = amt * product.getProd_price();
            creditlimit = cm2.getCreditLimit() - totalPrice;
            if (creditlimit < 0) {
                JOptionPane.showMessageDialog(null, "Reach credit limit! System will jump to invoice page", "ERROR", JOptionPane.ERROR_MESSAGE);
               dispose(); InvoiceOption IO = new InvoiceOption();
                IO.setTitle("Invoice");
                IO.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                IO.setSize(250, 150);
                IO.setVisible(true);
                IO.setLocationRelativeTo(null);
                
            } else {
                //CustomerMaintenance cm = corporateDetail.get(listCorporateName.getSelectedIndex());
                CustomerMaintenance cm = new CustomerMaintenance(ppl);
                CustomerMaintenanceDA cmDA = new CustomerMaintenanceDA();
                Product p = productList.get(listProduct.getSelectedIndex());

                cm.setCreditLimit(creditlimit);

                //Product p2 = prodControl.selectRecord(p.getProd_ID());
                //order = new Order(id.getText(),cust2.getCustID(),product.getProd_ID(),Integer.parseInt(amount.getText()),totalPrice, aa ,"UNPAID");
                Order order2 = new Order(orderNo.getText(), id.getText(), "C0001", product.getProd_ID(), Integer.parseInt(amount.getText()), totalPrice, aa, "UNPAID");
                orderDA.addRecord(order2);
                cmDA.updateRecord(cm);
                String ordernum = orderNo.getText();
                int ordernum2 = Integer.parseInt(ordernum);
                String orderNum = Integer.toString(ordernum2 + 1);
                orderNo.setText(orderNum);
                String orderID = id.getText();
                String newOrder = "O00" + (Integer.parseInt(orderID.substring(2, orderID.length())) + 1);
                id.setText(newOrder);
                clearText();
                JOptionPane.showMessageDialog(null, "Successful! ", "Successful", JOptionPane.INFORMATION_MESSAGE);
                dispose();

            }
        }
    }

    private void CustomerModel() {
        corporateDetail = custControl.getCust();
        for (int i = 0; i < corporateDetail.size(); ++i) {
            corporateName.addElement(corporateDetail.get(i).getCompany());
        }
    }

    private void ProductModel() {
        productList = prodDA.getRecordList();
        for (int i = 0; i < productList.size(); ++i) {
            prodName.addElement(productList.get(i).getProd_name());
        }
    }

    public static void main(String[] main) {
        OrderItem order = new OrderItem();
        order.setTitle("Add Order");
        order.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        order.setSize(750, 450);
        order.setVisible(true);
        order.setLocationRelativeTo(null);
    }

    private void clearText() {
        amount.setText("");
        purpose.setText("");
    }
}
