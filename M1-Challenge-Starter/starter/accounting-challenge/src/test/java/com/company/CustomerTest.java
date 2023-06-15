package com.company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
//testing getBalance
    @Test
    void getBalanceTest() {
        Customer customer=new Customer();
        AccountRecord charge= new AccountRecord();
        charge.setCharge(100);
        customer.getCharges().add(charge);
        assertEquals(100,customer.getBalance());
    }

    @Test
    void getNegativeBalance() {
        Customer customer=new Customer();
        AccountRecord charge= new AccountRecord();
        charge.setCharge(-100);
        customer.getCharges().add(charge);
        assertEquals(-100,customer.getBalance());
    }

    @Test
    void getBalanceIfNoTransactions() {
        Customer customer=new Customer();
        assertEquals(0,customer.getBalance());
    }




    //testing toString
    @Test
    void testToStringPositiveBalance() {
        Customer customer=new Customer();
        customer.setId(2);
        customer.setName("Flavia");
        AccountRecord charge=new AccountRecord();
        charge.setCharge(1000);
        customer.getCharges().add(charge);
        assertEquals("ID: 2    Name: Flavia              Balance: $  1000",customer.toString());
    }

    @Test
    void testToStringNegativeBalance() {
        Customer customer=new Customer();
        customer.setId(2);
        customer.setName("Flavia");
        AccountRecord charge=new AccountRecord();
        charge.setCharge(-1000);
        customer.getCharges().add(charge);
        assertEquals("ID: 2    Name: Flavia              Balance:-$  1000",customer.toString());
    }

    @Test
    void testToStringifBlank() {
        Customer customer=new Customer();
        assertEquals("No customer data",customer.toString());
    }

    @Test
    void testToStringifNameless() {
        Customer customer=new Customer();
        customer.setId(6);
        assertEquals("Incomplete customer data",customer.toString());
    }

    @Test
    void testToStringifNoID() {
        Customer customer=new Customer();
        customer.setName("Michael");
        assertEquals("Incomplete customer data",customer.toString());
    }

    @Test
    void testToStringifNoTransactions() {
        Customer customer=new Customer();
        customer.setName("Michael");
        customer.setId(10);
        assertEquals("ID: 10    Name: Michael             Balance: $     0",customer.toString());
    }
}
