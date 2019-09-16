package daomap;


import javax.persistence.EntityManager;

import beans.BankBean;
import beans.CustomerAddress;

public class BankDao implements BankDao1 {

	EntityManager con;
	ConnectionDatabase cd=new ConnectionDatabase();
	
	
	
	@Override
	public long getBalance(long accNo) {
		
		con = cd.getConnection();
		con.getTransaction().begin();
		BankBean emp1=(BankBean) con.find(BankBean.class,new Long(accNo));
		con.getTransaction().commit();
		return emp1.getBalance();
		

	}

	@Override
	public void setBalance(long accNo, long bal, String st){
		con = cd.getConnection();
		con.getTransaction().begin();
		BankBean emp1=(BankBean) con.find(BankBean.class,new Long(accNo));
		
		
	
		String str = emp1.getTran() + st;
		emp1.setTran(str);
		emp1.setBalance(bal);
		con.merge(emp1);
		con.getTransaction().commit();
	}

	
	@Override
	public boolean checkPassword(String str,long accNo)  {
		con = cd.getConnection();
		con.getTransaction().begin();
		BankBean emp1=(BankBean) con.find(BankBean.class,new Long(accNo));
		if (emp1.getPassword().equals(str))
			return true;
		else
			return false;

	}

	@Override
	public boolean checkAccNo(long accNo){
		con = cd.getConnection();
		con.getTransaction().begin();
		BankBean emp1=(BankBean) con.find(BankBean.class,new Long(accNo));
		
		if (emp1==null)
			return false;
		else
			return true;

	}

	@Override
	public long setData(BankBean bb) {
	
		con = cd.getConnection();
		con.getTransaction().begin();

		con.persist(bb);
		con.getTransaction().commit();
		return bb.getAccNo();
	}

	@Override
	public String getTransaction(long accNo) {
		// TODO Auto-generated method stub
		con = cd.getConnection();
		con.getTransaction().begin();
		BankBean emp1=(BankBean) con.find(BankBean.class,new Long(accNo));
		con.getTransaction().commit();
		return emp1.getTran();
	}
	
}
