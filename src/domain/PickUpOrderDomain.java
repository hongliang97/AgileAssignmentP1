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
    private CustOrder order;
    private String newAddress = "";
    private String status = "";
    private String timeStamp = "";
    
    public PickUpOrderDomain(){
        
    }

    public PickUpOrderDomain(CustOrder order) {
        this.order = order;
        this.newAddress = order.getAddress() + ", " + order.getZip() + ", " + order.getCity() + " " + order.getState();
    }

    public PickUpOrderDomain(CustOrder order, String status) {
        this.order = order;
        this.newAddress = order.getAddress() + ", " + order.getZip() + ", " + order.getCity() + order.getState();
        this.status = status;
    }

    public PickUpOrderDomain(CustOrder order, String status, String timeStamp) {
        this.order = order;
        this.newAddress = order.getAddress() + ", " + order.getZip() + ", " + order.getCity() + order.getState();
        this.status = status;
        this.timeStamp = timeStamp;
    }
    

    public CustOrder getOrder() {
        return order;
    }

    public void setOrder(CustOrder order) {
        this.order = order;
    }

    public String getNewAddress() {
        return newAddress;
    }

    public void setNewAddress(String newAddress) {
        this.newAddress = newAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.order);
        hash = 59 * hash + Objects.hashCode(this.newAddress);
        hash = 59 * hash + Objects.hashCode(this.status);
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
        if (!Objects.equals(this.newAddress, other.newAddress)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.order, other.order)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PickUpOrderDomain{" + "order=" + order + ", newAddress=" + newAddress + ", status=" + status + '}';
    }
    
}
