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
public class InvoicePayment implements Serializable{
    private String inv_ID;
    private String customer;
    private String product;
    private int quantity;
    private double price;
    private String date_generate;
    private String status;
    private String purpose;

    public InvoicePayment(String inv_ID, String customer, String product, int quantity, double price, String date_generate, String status, String purpose) {
        this.inv_ID = inv_ID;
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.date_generate = date_generate;
        this.status = status;
        this.purpose = purpose;
    }

    public String getInv_ID() {
        return inv_ID;
    }

    public void setInv_ID(String inv_ID) {
        this.inv_ID = inv_ID;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.inv_ID);
        hash = 13 * hash + Objects.hashCode(this.customer);
        hash = 13 * hash + Objects.hashCode(this.product);
        hash = 13 * hash + this.quantity;
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 13 * hash + Objects.hashCode(this.date_generate);
        hash = 13 * hash + Objects.hashCode(this.status);
        hash = 13 * hash + Objects.hashCode(this.purpose);
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
        final InvoicePayment other = (InvoicePayment) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.inv_ID, other.inv_ID)) {
            return false;
        }
        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.purpose, other.purpose)) {
            return false;
        }
        if (!Objects.equals(this.date_generate, other.date_generate)) {
            return false;
        }
        return true;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
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

    public String getDate_generate() {
        return date_generate;
    }

    public void setDate_generate(String date_generate) {
        this.date_generate = date_generate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public InvoicePayment(String inv_ID) {
        
        this.inv_ID = inv_ID;
        
    }

   
    public String getCode() {
        return inv_ID;
    }

   
    public void setCode(String inv_ID) {
        this.inv_ID = inv_ID;
    }

       
}
