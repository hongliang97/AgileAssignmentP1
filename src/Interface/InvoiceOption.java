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
/**
 *
 * @author liang
 */
public class InvoiceOption extends JFrame{
    String[] reportSelection = {"ABC SDN BHD", "DEF SDN BHD"};
    private JComboBox reportSelect = new JComboBox(reportSelection);
    private JButton btnGenerate = new JButton("Generate");
    private JButton btnExit = new JButton("Exit");
    
    public InvoiceOption(){
         JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel l1 = new JLabel("COMPANY NAME");
        l1.setFont(new Font("TimesRoman", Font.BOLD, 15));
        panel.add(l1);
        add(panel, BorderLayout.NORTH);
        JPanel panel1 = new JPanel();
        panel1.add(new Label("Select Company"));
        panel1.add(reportSelect);
       
        add(panel1);
        JPanel panel2 = new JPanel();
        panel2.add(btnGenerate);
        panel2.add(btnExit);
        add(panel2, BorderLayout.SOUTH);
        btnGenerate.addActionListener(new GenerateListener());
        btnExit.addActionListener(new ExitListener());
    }

    private class GenerateListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (reportSelect.getSelectedItem().toString().equals("ABC SDN BHD")){
                    JOptionPane.showMessageDialog(null, "Successful to generate invoice", "Successful", JOptionPane.INFORMATION_MESSAGE);
                    new GenerateInvoice();
                    dispose();
            }else if (reportSelect.getSelectedItem().toString().equals("DEF SDN BHD")) {
                    JOptionPane.showMessageDialog(null, "Successful to generate invoice", "Successful", JOptionPane.INFORMATION_MESSAGE);
                    new Generate_Invoice();
                    dispose();
                } 
                
            
            }

        }
    

    private class ExitListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }
    
    public static void main(String[] main) {
        InvoiceOption order = new InvoiceOption();
        order.setTitle("Invoice");
        order.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        order.setSize(250, 150);
        order.setVisible(true);
        order.setLocationRelativeTo(null);
    } 
}
