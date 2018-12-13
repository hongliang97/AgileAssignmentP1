/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import da.OrderDA;
import domain.Order;

/**
 *
 * @author liang
 */
public class OrderCtrl {
    private OrderDA orderDA;
    
    public OrderCtrl(){
        orderDA = new OrderDA();
    }
    
    public void addRecord (Order order){
        orderDA.addRecord(order);
    }
    
    public Order AddID(){
        return orderDA.orderID();
    }
    
    public Order selectRecord(String id){
        return orderDA.getRecord(id);
    }
}
