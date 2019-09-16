package daomap;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import beans.BankBean;

public class JunitTest {
	EntityManager con;
    ConnectionDatabase cd=new ConnectionDatabase();
    //Hashmap which is storing all account holders information
    BankBean bb1;                    //object of Bankbean class
    @Test// getting Balance of account holder by reference to their accno
    public void getBalance() { 
        con = cd.getConnection();
        con.getTransaction().begin();
        BankBean emp1=(BankBean) con.find(BankBean.class,new Long(1));
        con.getTransaction().commit();
        long observed= emp1.getBalance();
        long expected=1000;
        Assertions.assertEquals(expected, observed);
    }

}
