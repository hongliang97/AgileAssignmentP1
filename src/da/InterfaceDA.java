/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import domain.PickUpOrderDomain;


/**
 *
 * @author Lim Yb
 */
public interface InterfaceDA<T> {
       
    public void add(PickUpOrderDomain domain);    
       
    public T retrieve();
    
    public void update(T data, T data2);
    
    public void delete(T data);
    
    public void createConnection();

    public void shutDown();
}
