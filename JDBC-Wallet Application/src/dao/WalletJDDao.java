package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.WalletBean;

public class WalletJDDao implements WalletJDDaoI {
	WalletDB cd = new WalletDB();
	PreparedStatement ps;
	Connection con;

	@Override
	public long getBalance(long accNo) throws ClassNotFoundException, SQLException {
		con = cd.getConnection();
		ps = con.prepareStatement("Select * from user1 where uaccNo1=?");
		ps.setLong(1, accNo);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return rs.getLong(5);

	}

	@Override
	public void setBalance(long accNo, long bal, String st) throws ClassNotFoundException, SQLException {
		con = cd.getConnection();
		ps = con.prepareStatement("Select * from user1 where uaccno1=?");
		ps.setLong(1, accNo);
		ResultSet rs = ps.executeQuery();
		rs.next();
		String str = rs.getString(6) + st;
		ps = con.prepareStatement("update user1 set balance1=?, transaction1=? where uaccNo1=?");
		ps.setLong(3, accNo);
		ps.setLong(1, bal);
		ps.setString(2, str);

		ps.executeUpdate();

	}

	@Override
	public boolean checkMobile(long mob) throws ClassNotFoundException, SQLException {
		con = cd.getConnection();
		ps = con.prepareStatement("Select * from user1 where mobile1=?");
		ps.setLong(1, mob);
		ResultSet rs = ps.executeQuery();
		if (rs.next())
			return false;
		else
			return true;

	}

	@Override
	public boolean checkPassword(String str) throws ClassNotFoundException, SQLException {
		con = cd.getConnection();
		ps = con.prepareStatement("Select * from user1 where password1=?");
		ps.setString(1, str);
		ResultSet rs = ps.executeQuery();
		if (rs.next())
			return true;
		else
			return false;

	}

	@Override
	public boolean checkAccNo(long accNo) throws ClassNotFoundException, SQLException {
		con = cd.getConnection();
		ps = con.prepareStatement("Select * from user1 where uaccno1=?");
		ps.setLong(1, accNo);
		ResultSet rs = ps.executeQuery();
		if (rs.next())
			return true;
		else
			return false;

	}

	@Override
	public void setData(WalletBean bb) throws ClassNotFoundException, SQLException {
		con = cd.getConnection();
		ps = con.prepareStatement("insert into user1 values(?,?,?,?,?,?)");
		ps.setString(1, bb.getName());
		ps.setLong(2, bb.getAccNo());
		
		ps.setLong(3, bb.getMobile());
		ps.setString(4, bb.getPassword1());
		ps.setLong(5, bb.getBalance());

		ps.setString(6, bb.getTran());

		int ans = ps.executeUpdate();

	}

	@Override
	public String getTransaction(long accNo) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		con = cd.getConnection();
		ps = con.prepareStatement("Select * from user1 where uaccNo1=?");
		ps.setLong(1, accNo);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return rs.getString(6);
	}

	public WalletBean getInfo(long accNo) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		con = cd.getConnection();
		ps = con.prepareStatement("Select * from user1 where uaccNo1=?");
		ps.setLong(1, accNo);
		ResultSet rs = ps.executeQuery();
		rs.next();
		WalletBean b=new WalletBean(rs.getString(1),rs.getLong(2), rs.getLong(3), rs.getString(4), rs.getLong(5),rs.getString(6));
		return b;
	}

	
}