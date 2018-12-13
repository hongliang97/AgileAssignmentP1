/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import da.InvoicePaymentDA;
import domain.InvoicePayment;

/**
 *
 * @author liang
 */
public class InvoicePaymentCtrl {
    private InvoicePaymentDA ipDA;
    
    public InvoicePaymentCtrl(){
        ipDA = new InvoicePaymentDA();
}
    public void addRecord (InvoicePayment ip){
        ipDA.addRecord(ip);
    }
    
    public InvoicePayment AddID(){
        return ipDA.invID();
    }
}

