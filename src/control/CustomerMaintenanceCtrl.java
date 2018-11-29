/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import Interface.CustomerInterface;
import da.CustomerMaintenanceDA;
import domain.CustomerMaintenance;
import java.util.ArrayList;
import java.util.Queue;

/**
 *
 * @author liang
 */
public class CustomerMaintenanceCtrl implements CustomerInterface{
    private CustomerMaintenanceDA CMIPDA;
    String name = "";
    public CustomerMaintenanceCtrl(){
        
        CMIPDA = new CustomerMaintenanceDA();
    }
  
     public ArrayList<CustomerMaintenance> getCust() {
        return CMIPDA.getCustomer();
    }

    @Override
    public Queue getCustInfo() {
       Queue cust = CMIPDA.getRecord(name);
       
       return cust;
    }

    @Override
    public void setCustName(String name) {
        this.name = name;
    }
    
    public CustomerMaintenance selectRecord(String name){
        return CMIPDA.selectRecord(name);
    }
    
    public CustomerMaintenance CurrentRecord() {
        return CMIPDA.getCurrentRecord();
    }

    public ArrayList<CustomerMaintenance> getCustRecord(){
        return CMIPDA.getCustRecord();
}
}
