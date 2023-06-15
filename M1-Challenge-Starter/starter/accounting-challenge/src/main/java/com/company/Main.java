package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.Boolean.FALSE;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Plan et","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );


    public static void main(String[] args) {
                /*
    Iterating through customerData and converting the List into a List of Customer
    objects where there is only one copy of each customer;
     */
        List<Customer> custList=new ArrayList<Customer>();
        Hashtable<Integer,Customer> custDictionary=new Hashtable();
        for(String [] customerInfo : customerData){
            int currID=Integer.parseInt(customerInfo[0]);
            String currName=customerInfo[1];
            int currAmount=Integer.parseInt(customerInfo[2]);
            String currDate=customerInfo[3];

            //if customer has NOT been encountered:create a new Customer object
            if(custDictionary.containsKey(currID)==false){
                Customer currCustomer=new Customer();
                currCustomer.setId(currID);
                currCustomer.setName(currName);
                custDictionary.put(currCustomer.getId(),currCustomer);
                custList.add(currCustomer);
            }//add charges to list of charges
                AccountRecord currCharge=new AccountRecord();
                currCharge.setCharge(currAmount);
                currCharge.setChargeDate(currDate);
                custDictionary.get(currID).getCharges().add(currCharge);

        }

        //Updated this to print all positive and negative accounts
        System.out.println("Positive accounts:");
        for(Customer cust: custList){
            if (cust.getBalance()>=0){
                System.out.println(cust.toString());
            }
        }

        System.out.println("Negative accounts:");
        for(Customer cust: custList){
            if (cust.getBalance()<0){
                System.out.println(cust.toString());
            }
        }



    }
}
