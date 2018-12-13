
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order.and.consumer.payment.management;

import da.OrderDA;
import da.OrderPickUpManageDA;
import domain.CustOrder;
import domain.PickUpOrderDomain;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lim Yb
 */
public class DeliveryOrder extends JFrame {
   // GridBagLayout gridbag = new GridBagLayout();
   // GridBagConstraints c = new GridBagConstraints();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat timeStampFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();
    Date timeStamp = new Date();
    private JLabel jlbDate = new JLabel("Order (Delivery) of Date: " + dateFormat.format(date));
    private JButton jbUpdate = new JButton("Update Status");
    private JButton jbBack = new JButton("Back");
    private JLabel total = new JLabel();
    private JLabel total2 = new JLabel();
    private DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Order id","Product Name","Customer Name"
     , "Pick Up Date", "Pick Up Time", "Address", "Payment Method", "Status", "Time Stamp"},0); 
    private JTable table = new JTable(tableModel);
    JScrollPane scrollPane = new JScrollPane(table);
    
    PickUpOrderDomain domain = new PickUpOrderDomain();
    OrderPickUpManageDA da = new OrderPickUpManageDA();
    CustOrder orderDomain = new CustOrder();
    OrderDA orderDa = new OrderDA();
      
    public DeliveryOrder(){
        table = new JTable();
        table.setRowSelectionAllowed(true);
       // table2 = new JTable();
        setLayout(new BorderLayout());
        addDetail();
      //  JPanel pn0 = new JPanel(new GridLayout(1,2));
        JPanel pn1 = new JPanel(new GridLayout(2,1));
        JPanel pn2 = new JPanel(new GridLayout(3,1));
        JPanel pn3 = new JPanel((new BorderLayout()));
        JPanel pn4 = new JPanel(new FlowLayout(FlowLayout.LEFT));      
        JPanel pn6 = new JPanel(new FlowLayout());
        
       // c.fill = GridBagConstraints.BOTH;
        //c.weightx = 0.0;
        //gridbag.setConstraints(jlbDate, c);
        pn1.add(jlbDate);        
      //  pn0.add(jtfSearch);
      //  pn0.add(jbSearch);
      //  pn1.add(pn0);
        pn1.add(new JSeparator());
        pn4.add(total);
        pn2.add(new JLabel("Orders to be Delivery (Sorted according most efficient route)"));
        pn2.add(scrollPane);       
        pn2.add(pn4);
        pn6.add(jbUpdate);
        pn6.add(jbBack);
        
        add(pn1, BorderLayout.NORTH);
        add(pn2, BorderLayout.CENTER);
        //add(pn3, BorderLayout.CENTER);
        add(pn6, BorderLayout.SOUTH);
        
       // getRootPane().setDefaultButton(jbSearch);
        
        jbUpdate.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){             
                String str = " ";
                str = JOptionPane.showInputDialog(null, "Enter Order Id: ");
                ResultSet rsOrder = null;
                ResultSet rs = null;
                try{
                    rsOrder = orderDa.getSelectedQuery(str);
                    rs = (ResultSet) da.retrieveSelected(str);  
                    if (rsOrder.next()){
                        orderDomain = new CustOrder(rsOrder.getInt(1),rsOrder.getString(2),rsOrder.getString(3),rsOrder.getString(4),rsOrder.getString(5),
                                    rsOrder.getString(6),rsOrder.getString(7),rsOrder.getString(8),rsOrder.getString(9),rsOrder.getString(10),rsOrder.getString(11),
                                    rsOrder.getString(12),rsOrder.getString(13),rsOrder.getInt(14));
                        if (JOptionPane.showConfirmDialog(null, "Are you sure want to update Order ID: " + str + "?", "Update Status",JOptionPane.YES_NO_OPTION) == 0){
                            if (rs.next()){                   
                                domain = new PickUpOrderDomain(orderDomain, rs.getString(2), rs.getString(3));
                                da.update(domain.getOrder().getOrderId(), timeStampFormat.format(timeStamp));                               
                            }else{
                                 domain = new PickUpOrderDomain(orderDomain, "Done", timeStampFormat.format(timeStamp));
                                 da.add(domain);                              
                            }                          
                            JOptionPane.showMessageDialog(null, "Status Updated!");
                                
                                dispose();                  
                                DeliveryOrder pick = new DeliveryOrder();
                                pick.setVisible(true);
                                pick.setTitle("List of Today Orders Delivery");
                                pick.setLocationRelativeTo(null);
                                pick.setSize(1000, 550);
                                pick.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        }else{
                            
                            JOptionPane.showMessageDialog(null, "Record not updated!");
                        }
                    }
                    if (!str.equals(" ")){
                        JOptionPane.showMessageDialog(null, "This order id doesn't exist!");
                    }
                    
                }catch(Exception ex){
                    ex.getMessage();
                }                                    
            }
        });
        
           
        jbBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                PickupOrder pick = new PickupOrder();
                pick.setVisible(true);
                pick.setTitle("List of Today Orders Pick Up");
                pick.setLocationRelativeTo(null);
                pick.setSize(1000, 550);
                pick.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
              
            }
        });
       
    }
    
    public void addDetail(){            
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        int o = tableModel.getRowCount();
            for (int k=0; k < o; k++){
                tableModel.removeRow(0);
            }
       
        
        for (int i = 51000; i < 54000; i+=1000){
            ResultSet rsOrder = null;
            ResultSet rs = null;
            orderDomain = null;
            domain = null;
            try{
                rsOrder = orderDa.getQuery();
                rs = (ResultSet) da.retrieve();
            while (rsOrder.next()){
            orderDomain = new CustOrder(rsOrder.getInt(1),rsOrder.getString(2),rsOrder.getString(3),rsOrder.getString(4),rsOrder.getString(5),
            rsOrder.getString(6),rsOrder.getString(7),rsOrder.getString(8),rsOrder.getString(9),rsOrder.getString(10),rsOrder.getString(11),
            rsOrder.getString(12),rsOrder.getString(13),rsOrder.getInt(14));
            domain = new PickUpOrderDomain(orderDomain);
            rs = (ResultSet) da.retrieve();
            while (rs.next()){
                if (rs.getInt(4) == orderDomain.getOrderId()){
                    domain = new PickUpOrderDomain(orderDomain, rs.getString(2), rs.getString(3));
                }
            }
            if (orderDomain.getPickupDate().equals(dateFormat.format(date)) && orderDomain.getPickupMethod().equals("Delivery")){
                if (orderDomain.getZip().equals(String.format("%d", i))){                  
                    tableModel.addRow(new Object[]{domain.getOrder().getOrderId(),domain.getOrder().getProductName(),domain.getOrder().getName()
                    ,domain.getOrder().getPickupDate(),domain.getOrder().getPickupTime(),domain.getNewAddress(),domain.getOrder().getMethod(),domain.getStatus(), domain.getTimeStamp()});
                }
            }
        }
        }catch(SQLException ex){
            ex.getMessage();
        }
        }
                total.setText("Total Record: " + tableModel.getRowCount());
    }
    public static void main(String args[]){       
        DeliveryOrder pick = new DeliveryOrder();
        pick.setVisible(true);
        pick.setTitle("List of Today Orders Delivery");
        pick.setLocationRelativeTo(null);
        pick.setSize(1000, 550);
        pick.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }
    
}