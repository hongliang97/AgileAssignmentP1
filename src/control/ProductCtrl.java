/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import da.ProductDA;
import domain.Product;
import java.util.ArrayList;
import java.util.Queue;
/**
 *
 * @author liang
 */
public class ProductCtrl {
    private ProductDA PDA;
    String name = "";
    
    public Product CurrentRecord() {
        return PDA.getCurrentRecord();
    }

      public ArrayList<Product> getProduct() {
        return PDA.getProd();
    }
      
    public ArrayList<Product> getProdRecord(){
        return PDA.getProdRecord();
}
    public Product selectRecord(String id){
        return (Product) PDA.getRecord(id);
    }
    
    public Queue getProdInfo() {
       Queue prod = PDA.getRecord(name);
       
       return prod;
    }
    
     public void setProdName(String name) {
        this.name = name;
    }
}
