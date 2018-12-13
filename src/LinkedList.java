/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Delivery;

import domain.Deliveries;
import domain.DeliveryMan;
import domain.Order;

/**
 *
 * @author user
 */
public class LinkedList {
    // Reference to first Link in list
    // The last Link added to the LinkedList

    public Order firstLink;
    public Order currentLink;
    public Order previousLink;
    public DeliveryMan dManFirstLink;
    public DeliveryMan dManCurrentLink;
    public Deliveries deliveriesFirstLink;
    public Deliveries deliveriesCurrentLink;

    Node head;
    
    public LinkedList() {
        // Here to show the first Link always starts as null
        firstLink = null;
    }

    // Returns true if LinkList is empty
    public boolean isEmpty() {
        return (firstLink == null);
    }

    public boolean isEmptyTwo() {
        return (dManFirstLink == null);
    }

    public boolean isEmptyThree() {
        return (deliveriesFirstLink == null);
    }

    public void insertDeliveryManFirstLink(String dManID, String dManIC, String dManName) {

        DeliveryMan newLink = new DeliveryMan(dManID, dManIC, dManName);
        // Connects the firstLink field to the new Link 
        newLink.next = dManFirstLink;
        dManFirstLink = newLink;
    }

    public void insertAssignLink(String dManID, String orderID, String estimateTime) {

        Deliveries newLink = new Deliveries(dManID, orderID, estimateTime);
        // Connects the firstLink field to the new Link 
        newLink.next = deliveriesFirstLink;
        deliveriesFirstLink = newLink;
    }
    
     public void insertAssignLinkAtPosition(String dManID, String orderID, String estimateTime, int position) {

         Deliveries newLink = new Deliveries(dManID, orderID, estimateTime);
         Deliveries previous = deliveriesFirstLink;
         int count = 1;
         while(count < position - 1){
             previous = previous.next;
             count++;
         }
        Deliveries current = previous.next;
        newLink.next = current;
        previous.next = newLink;
    }

    public void insertDeliveryFirstLink(String orderID, String orderDescript, String paymentStatus,
            String orderStatus, String estimateReceived, String estimatedTime, String method, String address, String name, String custID) {

        Order newLink = new Order(orderID, orderDescript, paymentStatus, orderStatus, estimateReceived, estimatedTime, method, address, name, custID);
        // Connects the firstLink field to the new Link 
        newLink.next = firstLink;
        firstLink = newLink;
    }

    public void insertPickUpFirstLink(String orderID, String orderDescript, String paymentStatus,
            String orderStatus, String estimateReceived, String method) {

        Order newLink = new Order(orderID, orderDescript, paymentStatus, orderStatus, estimateReceived, method);
        // Connects the firstLink field to the new Link 
        newLink.next = firstLink;
        firstLink = newLink;
    }

    public Order removeFirst() {

        Order linkReference = firstLink;

        if (!isEmpty()) {
            // Removes the Link from the List
            firstLink = firstLink.next;
        } else {
            System.out.println("Empty LinkedList");
        }
        return linkReference;
    }

    public void deliveryDisplay() {
        Order theLink = firstLink;

        System.out.format("%-10s%-25s%-16s%-16s%-14s%-15s%-15s%-52s%-14s",
                "Order ID", "Order Description", "Payment Status", "Payment Method", "Order Status", "Expected Date", "Expected Time",
                "Address", "Customer Name\n");
        System.out.format("%-10s%-25s%-16s%-16s%-14s%-15s%-15s%-52s%-14s",
                "--------", "-----------------------", "--------------", "--------------", "------------", "------------",
                "------------", "--------------------------------------------------","-------------\n");

        while (theLink != null) {
            theLink.DeliveryDisplay();
            theLink = theLink.next;
            System.out.println();
        }
    }

    public void display() {

        Order theLink = firstLink;

        System.out.format("%-10s%-25s%-16s%-16s%-14s%-26s",
                "Order ID", "Order Description", "Payment Status", "Payment Method", "Order Status", "Expected Date(MM/dd/yyyy)\n");
        System.out.format("%-10s%-25s%-16s%-16s%-14s%-26s",
                "--------", "-----------------------", "--------------", "--------------", "------------", "-------------------------\n");
        // Start at the reference stored in firstLink and
        // keep getting the references stored in next for
        // every Link until next returns null
        while (theLink != null) {
            theLink.Display();
            //System.out.println("Next Link: " + theLink.next);
            theLink = theLink.next;
            System.out.println();
        }
    }

    public void deliveryManDisplay() {

        DeliveryMan theLink = dManFirstLink;

        System.out.format("%-17s%-17s%-18s",
                "Delivery Man ID", "Delivery Man IC", "Delivery Man Name\n");
        System.out.format("%-17s%-17s%-18s",
                "---------------", "---------------", "-----------------\n");
        // Start at the reference stored in firstLink and
        // keep getting the references stored in next for
        // every Link until next returns null
        while (theLink != null) {
            theLink.Display();
            //System.out.println("Next Link: " + theLink.next);
            theLink = theLink.next;
            System.out.println();
        }
    }

    public void assignDisplay() {

        Deliveries theLink = deliveriesFirstLink;

        System.out.format("%-18s%-10s%-4s",
                "\nDelivery Man ID", "Order ID", "Time\n");
        System.out.format("%-17s%-10s%-6s",
                "---------------", "--------", "------\n");
        // Start at the reference stored in firstLink and
        // keep getting the references stored in next for
        // every Link until next returns null
        while (theLink != null) {
            theLink.Display();
            //System.out.println("Next Link: " + theLink.next);
            theLink = theLink.next;
            System.out.println();
        }
    }

    public Order find(String orderID) {

        Order theLink = firstLink;
        if (!isEmpty()) {
            while (theLink.getOrderID().equals(orderID)) {
                // Checks if at the end of the LinkedList
                if (theLink.next == null) {
                    // Got to the end of the Links in LinkedList
                    // without finding a match
                    return null;
                } else {
                    // Found a matching Link in the LinkedList
                    theLink = theLink.next;
                }
            }
        } else {
            System.out.println("Empty LinkedList");
        }
        return theLink;
    }

    public boolean findOrderID(String orderID) {

        Order theLink = firstLink;
        if (!isEmpty()) {
            while (theLink.getOrderID().equals(orderID) == false) {
                if (theLink.next == null) {
                    return false;
                } else {
                    theLink = theLink.next;
                }
            }
        }
        return true;
    }

    public Order removeLink(String orderID) {

        Order currentLink = firstLink;
        Order previousLink = firstLink;

        // Keep searching as long as a match isn't made
        while (currentLink.getOrderID().equals(orderID)) {

            // Check if at the last Link in the LinkedList
            if (currentLink.next == null) {
                // bookName not found so leave the method
                return null;
            } else {
                // We checked here so let's look in the
                // next Link on the list
                previousLink = currentLink;
                currentLink = currentLink.next;
            }
        }

        if (currentLink == firstLink) {
            // If you are here that means there was a match
            // in the reference stored in firstLink in the
            // LinkedList so just assign next to firstLink
            firstLink = firstLink.next;
        } else {
            // If you are here there was a match in a Link other 
            // than the firstLink. Assign the value of next for
            // the Link you want to delete to the Link that's 
            // next previously pointed to the reference to remove
            System.out.println("FOUND A MATCH");
            System.out.println("currentLink: " + currentLink);
            System.out.println("firstLink: " + firstLink);
            previousLink.next = currentLink.next;
        }
        return currentLink;
    }

    public boolean checkID(String dManID) {
        int count = 0;
        Deliveries theLink = deliveriesCurrentLink;

        if (!isEmptyThree()) {
            while (theLink != null) {
                if (theLink.getDeliveryID().equals(dManID) == true) {
                    theLink = theLink.next;
                    count++;
                }
            }
        }

        if (count >= 3) {
            return false;
        } else {
            return true;
        }
    }

    public int size() {
        int size = 0;
        for (Order n = firstLink; n.next != null; n = n.next) {
            size++;
        }
        return size;
    }
    
    public int sizeTwo(Deliveries firstLink) {
        
        if(isEmptyThree()){
            return 0;
        }
        int size = 0;
        Deliveries current = firstLink;
        while(current != null){
            size++;
            current = current.next;
        }
        return size;
    }
    
    private class Node<T>{

        T data;
        Node next;

        public Node() {
            this.data = null;
            this.next = null;
        }

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

    }
    
}
