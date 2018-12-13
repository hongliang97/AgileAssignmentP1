/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.*;
import java.util.Objects;

/**
 *
 * @author liang
 */
public class Order implements Serializable {

    private String orderNo;
    private String orderID;
    private String prod_ID;
    private String custID;
    private int quantity;
    private double price;
    private String dateOrder;
    private String status;

    public Order(String orderNo, String orderID, String custID, String prod_ID, int quantity, double price, String dateOrder, String status) {
        this.orderNo = orderNo;
        this.orderID = orderID;
        this.prod_ID = prod_ID;
        this.quantity = quantity;
        this.price = price;
        this.dateOrder = dateOrder;
        this.status = status;
        this.custID = custID;
    }

     public Order(String orderNo, String orderID) {
        this.orderNo = orderNo;
         this.orderID = orderID;
    }

//    public Order(String orderNo) {
//        this.orderNo = orderNo;
//    }
//    public Order (String orderID){
//        this.orderID = orderID;
//    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

   
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getProd_ID() {
        return prod_ID;
    }

    public void setProd_ID(String prod_ID) {
        this.prod_ID = prod_ID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public String getID() {
        return orderNo;
    }

    public void setID(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCode() {
        return orderID;
    }

    public void setCode(String orderID) {
        this.orderID = orderID;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.orderNo);
        hash = 53 * hash + Objects.hashCode(this.orderID);
        hash = 53 * hash + Objects.hashCode(this.prod_ID);
        hash = 53 * hash + Objects.hashCode(this.custID);
        hash = 53 * hash + this.quantity;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 53 * hash + Objects.hashCode(this.dateOrder);
        hash = 53 * hash + Objects.hashCode(this.status);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.orderNo, other.orderNo)) {
            return false;
        }
        if (!Objects.equals(this.orderID, other.orderID)) {
            return false;
        }
        if (!Objects.equals(this.prod_ID, other.prod_ID)) {
            return false;
        }
        if (!Objects.equals(this.custID, other.custID)) {
            return false;
        }
        if (!Objects.equals(this.dateOrder, other.dateOrder)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Order{" + "orderNo=" + orderNo + ", orderID=" + orderID + ", prod_ID=" + prod_ID + ", custID=" + custID + ", quantity=" + quantity + ", price=" + price + ", dateOrder=" + dateOrder + ", status=" + status + '}';
    }

}
