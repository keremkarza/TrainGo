package com.omerkagandanaci.projecttrial.Model;

import java.util.ArrayList;
import java.util.Date;

/**
 * A class to create Ticket objects belong to a customer.
 * @author Furkan Gön
 * @version 18/04/2021
*/
public class Ticket {
    
    // properties
    private String fromWhere;
    private String toWhere;
    private Date departmentDate;
    private Date arrivalDate;
    private int compartmentNo;
    private String seat;
    private Customer owner;
    private double price;
    private String type;
    private ArrayList<Comment> comments;

    // constructor
    public Ticket(String fromWhere, String toWhere, Date departmentDate, 
        Date arrivalDate, int compartmentNo, String seat, Customer owner, double price){
            
            this.fromWhere = fromWhere;
            this.toWhere = toWhere;
            this.departmentDate = departmentDate;
            this.arrivalDate = arrivalDate;
            this.compartmentNo = compartmentNo;
            this.seat = seat;
            this.owner = owner; 
            this.price = price;
            this.type = "Future";
            this.comments = null;
    }

    // default constructor
    public Ticket(){

    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * Edit the type if it is old, future or current ticket.
     */
    public void editType() {
        
        Date currentDate;
        currentDate = new Date();
        
        if(getDepartmentDate().compareTo(currentDate) < 0 && getArrivalDate().compareTo(currentDate) < 0)
            this.type = "Old";
        else if(getDepartmentDate().compareTo(currentDate) < 0 && getArrivalDate().compareTo(currentDate) >= 0)
            this.type = "Current";
        else 
            this.type = "Future";
    }
    /**
     * @return the comments
     */
    public ArrayList<Comment> getComments() {
        return comments;
    }


    /**
     * Add a comment to the comment list.
     */
    public void addComment(Comment aComment) {
        comments.add(aComment);
    }

    

    /**
     * @return the fromWhere
     */
    public String getFromWhere() {
        return fromWhere;
    }

    /**
     * @param fromWhere the fromWhere to set
     */
    public void setFromWhere(String fromWhere) {
        this.fromWhere = fromWhere;
    }

    /**
     * @return the toWhere
     */
    public String getToWhere() {
        return toWhere;
    }

    /**
     * @param toWhere the toWhere to set
     */
    public void setToWhere(String toWhere) {
        this.toWhere = toWhere;
    }

    /**
     * @return the departmentDate
     */
    public Date getDepartmentDate() {
        return departmentDate;
    }

    /**
     * @param departmentDate the departmentDate to set
     */
    public void setDepartmentDate(Date departmentDate) {
        this.departmentDate = departmentDate;
    }

    /**
     * @return the arrivalDate
     */
    public Date getArrivalDate() {
        return arrivalDate;
    }

    /**
     * @param arrivalDate the arrivalDate to set
     */
    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    /**
     * @return the compartmentNo
     */
    public int getCompartmentNo() {
        return compartmentNo;
    }

    /**
     * @param compartmentNo the compartmentNo to set
     */
    public void setCompartmentNo(int compartmentNo) {
        this.compartmentNo = compartmentNo;
    }

    /**
     * @return the seat
     */
    public String getSeat() {
        return seat;
    }

    /**
     * @param seat the seat to set
     */
    public void setSeat(String seat) {
        this.seat = seat;
    }

    /**
     * @return the owner
     */
    public Customer getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    
    

    
}
