/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order.and.consumer.payment.management;
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
public class PickupOrder extends JFrame {
   // GridBagLayout gridbag = new GridBagLayout();
   // GridBagConstraints c = new GridBagConstraints();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    private JLabel jlbDate = new JLabel("Order Pick Up of Date: " + dateFormat.format(date));
  //  private JTextField jtfSearch = new JTextField();
  //  private JButton jbSearch = new JButton("Search");
    private JButton jbUpdate = new JButton("Update Status");
    private JButton jbBack = new JButton("Back");
    private JLabel total = new JLabel();
    private JLabel total2 = new JLabel();
    private DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Order id","Product Name","Quantity","Customer Name","Customer Contact"
     , "Pick Up Date", "Pick Up Time", "Address", "Pick Up Method", "Payment Method", "Status"},0); 
    private JTable table = new JTable(tableModel);
    JScrollPane scrollPane = new JScrollPane(table);
    private DefaultTableModel tableModel2 = new DefaultTableModel(new Object[]{"Order id","Product Name","Quantity","Customer Name","Customer Contact"
      , "Pick Up Date","Pick Up Time" ,"Address", "Pick Up Method", "Payment Method", "Status"},0); 
    private JTable table2 = new JTable(tableModel2);
    JScrollPane scrollPane2 = new JScrollPane(table2);
    private ResultSet rsBook = null;
    
       
    public PickupOrder(PickUpOrderDomain[] arr){
        table = new JTable();
        table.setRowSelectionAllowed(true);
       // table2 = new JTable();
        setLayout(new BorderLayout());
        addDetail(arr);
      //  JPanel pn0 = new JPanel(new GridLayout(1,2));
        JPanel pn1 = new JPanel(new GridLayout(2,1));
        JPanel pn2 = new JPanel(new GridLayout(7,1));
        JPanel pn3 = new JPanel((new BorderLayout()));
        JPanel pn4 = new JPanel(new FlowLayout(FlowLayout.LEFT));      
        JPanel pn5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
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
        pn5.add(total2);
        pn2.add(new JLabel("Order that customer come and pick up"));
        pn2.add(scrollPane);       
        pn2.add(pn4);
        pn2.add(new JSeparator());
        pn2.add(new JLabel("Order that need to be delivery"));
        pn2.add(scrollPane2);
        pn2.add(pn5);
        pn6.add(jbUpdate);
        pn6.add(jbBack);
        
        add(pn1, BorderLayout.NORTH);
        add(pn2, BorderLayout.CENTER);
        //add(pn3, BorderLayout.CENTER);
        add(pn6, BorderLayout.SOUTH);
        
       // getRootPane().setDefaultButton(jbSearch);
        
        jbUpdate.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                PickUpOrderDomain[] newArr = new PickUpOrderDomain[arr.length];
                String str = "";
                int check = 0;
                str = JOptionPane.showInputDialog(null, "Enter Order Id: ");
                for (int i = 0; i < arr.length; i++){
                    if (arr[i].getOrderId().equals(str)){
                        check = 1;
                        if (JOptionPane.showConfirmDialog(null, "Are you sure want to update Order ID: " + str + "?", "Update Status",JOptionPane.YES_NO_OPTION) == 0){

                            if (arr[i].getStatus().equals("Done")){
                                arr[i].setStatus("Not Yet");
                            }
                            else
                                arr[i].setStatus("Done");
                            JOptionPane.showMessageDialog(null, "Status Updated!");
                        }
                        
                    }                                          
                    newArr[i] = arr[i];
                }
                if (check != 1)
                    JOptionPane.showMessageDialog(null, "Wrong Order Id entered!");
                dispose();
                PickupOrder pick = new PickupOrder(newArr);
                pick.setVisible(true);
                pick.setTitle("List of Today Orders Pick Up");
                pick.setLocationRelativeTo(null);
                pick.setSize(900, 550);
                pick.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
            }
        });
           
        jbBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
              /*  .setTitle("u");
                .setVisible(true);
                .setSize(700,400);
                .setLocationRelativeTo(null);
                .setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              */
            }
        });
       
    }
    
    public void addDetail(PickUpOrderDomain[] arr){
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        int o = tableModel.getRowCount();
            for (int k=0; k < o; k++){
                tableModel.removeRow(0);
            }
        table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        int j = tableModel2.getRowCount();
            for (int k=0; k < j; k++){
                tableModel2.removeRow(0);
            }
        for (int i = 0; i < arr.length; i++){
            if (arr[i].getPickUpDate().equals(dateFormat.format(date)) && arr[i].getPickUpMethod().equals("Pick Up")){
                tableModel.addRow(new Object[]{arr[i].getOrderId(),arr[i].getProductName(),arr[i].getQuantity(),arr[i].getCustName(),arr[i].getCustContact()
                ,arr[i].getPickUpDate(),arr[i].getPickUpTime(),arr[i].getAddress(),arr[i].getPickUpMethod(),arr[i].getPaymentMethod(),arr[i].getStatus()});
            }
            if (arr[i].getPickUpDate().equals(dateFormat.format(date)) && arr[i].getPickUpMethod().equals("Delivery")){
                tableModel2.addRow(new Object[]{arr[i].getOrderId(),arr[i].getProductName(),arr[i].getQuantity(),arr[i].getCustName(),arr[i].getCustContact()
                ,arr[i].getPickUpDate(),arr[i].getPickUpTime(),arr[i].getAddress(),arr[i].getPickUpMethod(),arr[i].getPaymentMethod(),arr[i].getStatus()});
            }
        }
                total.setText("Total Record: " + tableModel.getRowCount());
                total2.setText("Total record: " + tableModel2.getRowCount());
    }
    public static void main(String args[]){
        PickUpOrderDomain[] arr = new PickUpOrderDomain[]{new PickUpOrderDomain("O0001","Rose",2,"Lim Chun Chun","012-3456789"
       ,"2018-11-27" ,"12:11 pm", "No.01, Jalan Bla...", "Pick Up", "Pay When Pick Up", "Not Yet"), 
            new PickUpOrderDomain("O0002","Orchid",3,"Bryan Loh","012-3456789"
       ,"2018-11-27" ,"13:30 pm" ,"No.02, Jalan Bla...", "Pick Up", "Pay When Pick Up", "Not Yet"), 
            new PickUpOrderDomain("O0003","Rose",2,"Lim Chun Chun","012-3456789"
       ,"2018-11-27" ,"12:11 pm", "No.03, Jalan Bla...", "Delivery", "Cash on Delivery", "Not Yet"), 
            new PickUpOrderDomain("O0004","Orchid",3,"Bryan Loh","012-3456789"
       ,"2018-11-27" ,"13:30 pm" ,"No.04, Jalan Bla...", "Delivery", "Cash on Delivery", "Done")};
        
        PickupOrder pick = new PickupOrder(arr);
        pick.setVisible(true);
        pick.setTitle("List of Today Orders Pick Up");
        pick.setLocationRelativeTo(null);
        pick.setSize(900, 550);
        pick.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }
}
