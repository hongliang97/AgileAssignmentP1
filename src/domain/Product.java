/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Objects;

/**
 *
 * @author liang
 */
public class Product {
    private String prod_ID;
    private String prod_name;
    private double prod_price;
    private String prod_detail;

    public Product(String prod_ID, String prod_name, double prod_price, String prod_detail) {
        this.prod_ID = prod_ID;
        this.prod_name = prod_name;
        this.prod_price = prod_price;
        this.prod_detail = prod_detail;
    }

    public String getProd_ID() {
        return prod_ID;
    }

    public void setProd_ID(String prod_ID) {
        this.prod_ID = prod_ID;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public double getProd_price() {
        return prod_price;
    }

    public void setProd_price(double prod_price) {
        this.prod_price = prod_price;
    }

    public String getProd_detail() {
        return prod_detail;
    }

    public void setProd_detail(String prod_detail) {
        this.prod_detail = prod_detail;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.prod_ID);
        hash = 17 * hash + Objects.hashCode(this.prod_name);
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.prod_price) ^ (Double.doubleToLongBits(this.prod_price) >>> 32));
        hash = 17 * hash + Objects.hashCode(this.prod_detail);
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
        final Product other = (Product) obj;
        if (Double.doubleToLongBits(this.prod_price) != Double.doubleToLongBits(other.prod_price)) {
            return false;
        }
        if (!Objects.equals(this.prod_ID, other.prod_ID)) {
            return false;
        }
        if (!Objects.equals(this.prod_name, other.prod_name)) {
            return false;
        }
        if (!Objects.equals(this.prod_detail, other.prod_detail)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product_ID=" + prod_ID + "\nProduct_name=" + prod_name + "\nProduct_price=" + prod_price + "\nProduct_detail=" + prod_detail ;
    }
    
    
}
