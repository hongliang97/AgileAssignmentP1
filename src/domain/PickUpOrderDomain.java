/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Objects;

/**
 *
 * @author Lim Yb
 */
public class PickUpOrderDomain {
    private String orderId;
    private String productName;
    private int quantity;
    private String custName;
    private String custContact;
    private String pickUpDate;
    private String pickUpTime;
    private String address;
    private String pickUpMethod;
    private String paymentMethod;
    private String status;
    
    public PickUpOrderDomain(){
        
    }

    public PickUpOrderDomain(String orderId, String productName, int quantity, String custName, String custContact, String pickUpDate, String pickUpTime, String address, String pickUpMethod, String paymentMethod, String status) {
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
        this.custName = custName;
        this.custContact = custContact;
        this.pickUpDate = pickUpDate;
        this.pickUpTime = pickUpTime;
        this.address = address;
        this.pickUpMethod = pickUpMethod;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }
    
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustContact() {
        return custContact;
    }

    public void setCustContact(String custContact) {
        this.custContact = custContact;
    }

    public String getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(String pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPickUpMethod() {
        return pickUpMethod;
    }

    public void setPickUpMethod(String pickUpMethod) {
        this.pickUpMethod = pickUpMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.orderId);
        hash = 71 * hash + Objects.hashCode(this.productName);
        hash = 71 * hash + this.quantity;
        hash = 71 * hash + Objects.hashCode(this.custName);
        hash = 71 * hash + Objects.hashCode(this.custContact);
        hash = 71 * hash + Objects.hashCode(this.pickUpDate);
        hash = 71 * hash + Objects.hashCode(this.pickUpTime);
        hash = 71 * hash + Objects.hashCode(this.address);
        hash = 71 * hash + Objects.hashCode(this.pickUpMethod);
        hash = 71 * hash + Objects.hashCode(this.paymentMethod);
        hash = 71 * hash + Objects.hashCode(this.status);
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
        final PickUpOrderDomain other = (PickUpOrderDomain) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        if (!Objects.equals(this.orderId, other.orderId)) {
            return false;
        }
        if (!Objects.equals(this.productName, other.productName)) {
            return false;
        }
        if (!Objects.equals(this.custName, other.custName)) {
            return false;
        }
        if (!Objects.equals(this.custContact, other.custContact)) {
            return false;
        }
        if (!Objects.equals(this.pickUpDate, other.pickUpDate)) {
            return false;
        }
        if (!Objects.equals(this.pickUpTime, other.pickUpTime)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.pickUpMethod, other.pickUpMethod)) {
            return false;
        }
        if (!Objects.equals(this.paymentMethod, other.paymentMethod)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PickUpOrderDomain{" + "orderId=" + orderId + ", productName=" + productName + ", quantity=" + quantity + ", custName=" + custName + ", custContact=" + custContact + ", pickUpDate=" + pickUpDate + ", pickUpTime=" + pickUpTime + ", address=" + address + ", pickUpMethod=" + pickUpMethod + ", paymentMethod=" + paymentMethod + ", status=" + status + '}';
    }         
}
