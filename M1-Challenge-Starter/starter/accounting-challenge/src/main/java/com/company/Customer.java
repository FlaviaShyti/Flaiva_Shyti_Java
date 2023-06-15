package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        //update this
        int runningSum=0;
        if(!charges.isEmpty()){
            for(AccountRecord charge: charges){
                runningSum+=charge.getCharge();
            }
        }
        return runningSum;
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }

    @Override
    public String toString() {
        //Prints customer's ID, name and balance.

        //checks if there is any data to display. Assuming an ID of 0 is the null value
        if (this.name==null && this.id==0){
            return "No customer data";
        }else if (this.name==null || this.id==0){
            return "Incomplete customer data";
        }
        //prints a negative balance
        if(this.getBalance()<0){
            return String.format("ID: %d    Name: %-17s   Balance:-$%6d",this.getId(),this.getName(),Math.abs(this.getBalance()));

        }
        //prints a positive balance
        return String.format("ID: %d    Name: %-17s   Balance: $%6d",this.getId(),this.getName(),this.getBalance());
        //return "ID: "+this.id+" Name: "+this.name+" Balance: $"+this.getBalance();
    }
}
