package JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.Committee;
import Entity.Member;
import Entity.Transaction;
import exceptions.DatabaseNotFoundException;
import exceptions.DriverNotFoundException;
import exceptions.MemberDaoException;
import exceptions.SQLSyntaxException;

public class MemberDao {
	static int i=0;
	public static double payableAmount=0;
	public MemberDao() throws DriverNotFoundException, DatabaseNotFoundException{
		Connect.con=Connect.connect();
	}
	public static void  createTable() throws DriverNotFoundException, DatabaseNotFoundException, SQLSyntaxException{
		try{
			Connect.con=Connect.connect();
			String sql="CREATE TABLE IF NOT EXISTS Member(ACC_NO INT(10) NOT NULL AUTO_INCREMENT,NAME TEXT(30) NOT NULL,JOIN_DATE DATE DEFAULT NULL,BALANCE DECIMAL(20) DEFAULT 0,ADDRESS TEXT(20) DEFAULT NULL,PRIMARY KEY(ACC_NO))";
			Statement st;
			st = Connect.con.createStatement();
			i=st.executeUpdate(sql);
			String sq2="CREATE TABLE IF NOT EXISTS TRANSACTION(ACC_NO INT(10) NOT NULL, TRANSACTION_ID INT(10) NOT NULL AUTO_INCREMENT,TYPE TEXT(30) NOT NULL,TRANSACTION_DATE DATE DEFAULT NULL,AMOUNT DECIMAL(20) DEFAULT 0, BALANCE DECIMAL(20) DEFAULT 0,PRIMARY KEY(TRANSACTION_ID))";
			Statement st1;
			st1=Connect.con.createStatement();
			i=st1.executeUpdate(sq2);
		} catch (SQLException e) {
			throw new SQLSyntaxException("\t\tTable Not Found !!!");
		}
	}

	public int addAccount(Member a) throws MemberDaoException
	{
		int accountNo=0;
		try {
			String sql="INSERT INTO MEMBER(NAME,ADDRESS,JOIN_DATE,BALANCE,CONTACT) VALUES(?,?,SYSDATE(),?,?)";
			PreparedStatement psmt=Connect.con.prepareStatement(sql);
			psmt.setString(1,a.memberName);
			psmt.setString(2, a.memberAddress);
			psmt.setDouble(3,a.balance);
			psmt.setString(4,a.contact);
			psmt.executeUpdate();
			String sql1="SELECT MAX(ACC_NO) AS ACC FROM MEMBER";
			Statement st=Connect.con.createStatement();
			ResultSet rs=st.executeQuery(sql1);
			while(rs.next()){
				accountNo=rs.getInt("ACC");
			}
			String sql2="INSERT INTO TRANSACTION(ACC_NO,TRANSACTION_DATE,TYPE,AMOUNT,BALANCE) VALUES(?,SYSDATE(),?,?,?)";
			PreparedStatement psmt1=Connect.con.prepareStatement(sql2);
			psmt1.setInt(1,accountNo);
			psmt1.setString(2,"Openning");
			psmt1.setDouble(3,a.balance);
			psmt1.setDouble(4,a.balance);
			psmt1.executeUpdate();
			return accountNo;
		} 

		catch (SQLException e12) {
			throw new MemberDaoException("\t\tCan't Create Account !!!");
		}
	}

	public ArrayList<Member> fetchAll() throws DriverNotFoundException, DatabaseNotFoundException, SQLSyntaxException{
		ArrayList<Member> al=new ArrayList<Member>();
		try{
			String sql="SELECT * FROM MEMBER";
			Statement st;
			st = Connect.con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Member a=new Member();
				a.memberID=(rs.getInt("ACC_NO"));
				a.memberName=(rs.getString("NAME"));
				a.memberAddress=(rs.getString("ADDRESS"));
				a.joinDate=(rs.getDate("JOIN_DATE"));
				a.balance=(rs.getDouble("BALANCE"));
				a.contact=rs.getString("CONTACT");
				al.add(a);
			}
		} catch (SQLException e) {
			throw new SQLSyntaxException("\t\tServer Not Found !!");
		}
		return al;
	}

	public ArrayList<Committee> fetchAllComittee() throws DriverNotFoundException, DatabaseNotFoundException, SQLSyntaxException{
		ArrayList<Committee> al=new ArrayList<Committee>();
		try{
			String sql="SELECT * FROM COMMITTEE";
			Statement st;
			st = Connect.con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Committee a=new Committee();
				a.committeeID=(rs.getInt("COMMITTEE_ID"));
				a.name=(rs.getString("NAME"));
				a.startDate=(rs.getString("START_DATE"));
				a.totalValue=(rs.getDouble("TOTAL_VALUE"));
				a.remaining=(rs.getInt("REMAINING"));
				al.add(a);
			}
		} catch (SQLException e) {
			throw new SQLSyntaxException("\t\tServer Not Found !!");
		}
		return al;
	}

	
	public boolean updateAmount(int acc,double sum) throws SQLSyntaxException, DriverNotFoundException, DatabaseNotFoundException{
		boolean success=false;
		try{
			double amount=getBalance(acc);
			double amount2=amount+sum;
			String typeString="";
			String sql="UPDATE MEMBER SET BALANCE="+amount2+" WHERE ACC_NO="+acc+"";
			Statement st=Connect.con.createStatement();
			i=st.executeUpdate(sql);
			String sql2="INSERT INTO TRANSACTION(ACC_NO,TRANSACTION_DATE,TYPE,AMOUNT,BALANCE) VALUES(?,SYSDATE(),?,?,?)";
			PreparedStatement psmt1=Connect.con.prepareStatement(sql2);
			psmt1.setInt(1,acc);
			if(sum<0){
				typeString="Cash Withdraw";
			}
			else{
				typeString="Cash Deposit";
			}
			psmt1.setString(2,typeString);
			psmt1.setDouble(3,sum);
			psmt1.setDouble(4,amount2);
			psmt1.execute();
			success=true;
		} catch (SQLException e) {
			throw new SQLSyntaxException("Table Not Found !!");
		}
		return success;
	}

	public double getBalance(int acc) throws SQLSyntaxException, DriverNotFoundException, DatabaseNotFoundException{
		double ret=0;
		try{
			String sql="SELECT BALANCE FROM MEMBER WHERE ACC_NO="+acc+"";
			Statement st=Connect.con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
				ret=rs.getDouble("BALANCE");
		} catch (SQLException e) {
			throw new SQLSyntaxException("\t\tProblem with Table Structure!!");
		}
		return ret;
	}

	public ArrayList<Transaction> getDetails(int acc) throws SQLSyntaxException
	{
		ArrayList<Transaction>tlist=new ArrayList<Transaction>();
		try{
			String sql="SELECT TRANSACTION_ID,TRANSACTION_DATE,TYPE,AMOUNT,BALANCE FROM TRANSACTION WHERE ACC_NO="+acc;
			Statement st=Connect.con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Transaction t=new Transaction();
				t.transactionID=(rs.getInt("TRANSACTION_ID"));
				t.transactionDate=(rs.getDate("TRANSACTION_DATE"));
				t.transactionType=(rs.getString("TYPE"));
				t.amount=(rs.getDouble("AMOUNT"));
				t.balance=(rs.getDouble("BALANCE"));
				tlist.add(t);
			}
		} catch (SQLException e) {
			throw new SQLSyntaxException("\t\tServer Not Found !!");
		}
		return tlist;
	}

	public int createCommittee(String name,double value,double interest) throws SQLSyntaxException {
		int accountNo=0;
		try{
			String sql="CREATE TABLE IF NOT EXISTS COMMITTEE(COMMITTEE_ID INT(10) NOT NULL AUTO_INCREMENT,NAME TEXT(30) NOT NULL,START_DATE DATE DEFAULT NULL,TOTAL_VALUE DECIMAL(20) DEFAULT 0,INTEREST DECIMAL(20) DEFAULT 0,PRIMARY KEY(COMMITTEE_ID))";
			Statement st;
			st = Connect.con.createStatement();
			i=st.executeUpdate(sql);
			String sql1="INSERT INTO COMMITTEE(NAME,START_DATE,TOTAL_VALUE,INTEREST) VALUES(?,SYSDATE(),?,?)";
			PreparedStatement psmt=Connect.con.prepareStatement(sql1);
			psmt.setString(1,name);
			psmt.setDouble(2,value);
			psmt.setDouble(3,interest);
			psmt.executeUpdate();
			String sql2="SELECT MAX(COMMITTEE_ID) AS ACC FROM COMMITTEE";
			Statement st2=Connect.con.createStatement();
			ResultSet rs=st2.executeQuery(sql2);
			while(rs.next())
			{
				accountNo=rs.getInt("ACC");
				System.out.println("\t\tCreated COMMITTEE ID is : "+accountNo);
			}
		} catch (SQLException e) {
			throw new SQLSyntaxException("\t\tTable Not Found !!!");
		}
		return accountNo;
	}
	public void addMembers(int id, ArrayList<Integer> members) throws SQLSyntaxException {	
		try{
			String sql="CREATE TABLE IF NOT EXISTS MAPPING(COMMITTEE_ID INT(10) NOT NULL,CUST_ID INT(20) NOT NULL,REMAINING TINYINT(1) DEFAULT 1)";
			Statement st;
			st = Connect.con.createStatement();
			i=st.executeUpdate(sql);
			for(int i=0;i<20;i++) {
				String sql1="INSERT INTO MAPPING(COMMITTEE_ID,CUST_ID,REMAINING) VALUES(?,?,?)";
				PreparedStatement psmt=Connect.con.prepareStatement(sql1);
				psmt.setInt(1,id);
				psmt.setInt(2,members.get(i));
				psmt.setDouble(3,1);
				psmt.executeUpdate();
			}	
		} catch (SQLException e) {
			throw new SQLSyntaxException("\t\tTable Not Found !!!");
		}
	}
	public ArrayList<Member> getAvailableIDs(int id) throws SQLSyntaxException {
		ArrayList<Member>al=new ArrayList<Member>();
		try{
			String sql="SELECT * FROM MEMBER WHERE ACC_NO IN(SELECT CUST_ID FROM MAPPING WHERE REMAINING=1 AND COMMITTEE_ID="+id+")";
			Statement st;
			st = Connect.con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Member a=new Member();
				a.memberID=(rs.getInt("ACC_NO"));
				a.memberName=(rs.getString("NAME"));
				a.memberAddress=(rs.getString("ADDRESS"));
				a.joinDate=(rs.getDate("JOIN_DATE"));
				a.balance=(rs.getDouble("BALANCE"));
				a.contact=(rs.getString("CONTACT"));
				al.add(a);
			}
		} catch (SQLException e) {
			throw new SQLSyntaxException("\t\tServer Not Found !!");
		}
		return al;
	}
	public double calculateBaseBid(int comiteeid) throws SQLSyntaxException {
		double suggestedInterest=0;
		try {
			String sql2="SELECT * FROM COMMITTEE WHERE COMMITTEE_ID="+comiteeid;
			Statement st2=Connect.con.createStatement();
			ResultSet rs=st2.executeQuery(sql2);
			while(rs.next()){
				double total=rs.getDouble("TOTAL_VALUE");
				double interest=rs.getDouble("INTEREST");
				int time=rs.getInt("REMAINING");
				suggestedInterest=total*interest*time/100;
			}
		}catch(SQLException e) {
			throw new SQLSyntaxException("\t\tServer Not Found !!");
		}
		return suggestedInterest;
	}
	public double calculteShare(int comiteeid, double finalBid) throws SQLSyntaxException {
		double share=0;
		try {
			String sql2="SELECT TOTAL_VALUE,NAME FROM COMMITTEE WHERE COMMITTEE_ID="+comiteeid;
			Statement st2=Connect.con.createStatement();
			ResultSet rs=st2.executeQuery(sql2);
			while(rs.next()){
				double total=rs.getDouble("TOTAL_VALUE");
				payableAmount=(total-finalBid);
				share=(total-finalBid)/20;
			}
		}catch(SQLException e) {
			throw new SQLSyntaxException("\t\tServer Not Found !!");
		}
		return share;
	}
	public void updateAll(int id, double share) throws SQLSyntaxException {
		try{
			String comiteeName=null;
			String sql4="SELECT NAME FROM COMMITTEE WHERE COMMITTEE_ID="+id;
			Statement st4=Connect.con.createStatement();
			ResultSet rs1=st4.executeQuery(sql4);
			while(rs1.next()){
				comiteeName=rs1.getString("NAME");
			}
			share=share*(-1);
			ArrayList<Member> al1=new ArrayList<Member>();
			String sql="SELECT * FROM MEMBER WHERE ACC_NO IN(SELECT CUST_ID FROM MAPPING WHERE COMMITTEE_ID="+id+")";
			Statement st=Connect.con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Member a=new Member();
				a.memberID=(rs.getInt("ACC_NO"));
				a.balance=(rs.getDouble("BALANCE"));
				al1.add(a);
			}
			for(int j=0;j<20;j++) {
				double amount=al1.get(j).balance;
				int acc=al1.get(j).memberID;
				double amount2=amount+share;
				String typeString="";
				String sql3="UPDATE MEMBER SET BALANCE="+amount2+" WHERE ACC_NO="+acc+"";
				Statement st2=Connect.con.createStatement();
				i=st2.executeUpdate(sql3);
				String sql2="INSERT INTO TRANSACTION(ACC_NO,TRANSACTION_DATE,TYPE,AMOUNT,BALANCE) VALUES(?,SYSDATE(),?,?,?)";
				PreparedStatement psmt1=Connect.con.prepareStatement(sql2);
				psmt1.setInt(1,acc);
				if(share<0){
					typeString=comiteeName+" Share";
				}
				else{
					typeString=comiteeName+" Bulk Deposit";
				}
				psmt1.setString(2,typeString);
				psmt1.setDouble(3,share);
				psmt1.setDouble(4,amount2);
				psmt1.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLSyntaxException("Table Not Found !!");
		}

	}
	public void updateComitee(int comiteeid, int bidID) throws SQLSyntaxException, DriverNotFoundException, DatabaseNotFoundException {
		try{
			String sql="SELECT * FROM COMMITTEE WHERE COMMITTEE_ID="+comiteeid;
			Statement st=Connect.con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			int time=0;
			while(rs.next()){
				time=rs.getInt("REMAINING");
			}
			String sql1="UPDATE COMMITTEE SET REMAINING="+(time-1)+" WHERE COMMITTEE_ID="+comiteeid;
			i=st.executeUpdate(sql1);
			Statement st1=Connect.con.createStatement();
			String sql2="UPDATE MAPPING SET REMAINING = "+0+" WHERE COMMITTEE_ID="+comiteeid+" AND CUST_ID="+bidID;
			i=st1.executeUpdate(sql2);
			double amount=getBalance(bidID);
			double amount2=amount+payableAmount;
			String typeString="";
			String sql3="UPDATE MEMBER SET BALANCE="+amount2+" WHERE ACC_NO="+bidID+"";
			Statement st3=Connect.con.createStatement();
			i=st3.executeUpdate(sql3);
			String sql4="INSERT INTO TRANSACTION(ACC_NO,TRANSACTION_DATE,TYPE,AMOUNT,BALANCE) VALUES(?,SYSDATE(),?,?,?)";
			PreparedStatement psmt3=Connect.con.prepareStatement(sql4);
			psmt3.setInt(1,bidID);
			typeString="Top Bid Deposit";
			psmt3.setString(2,typeString);
			psmt3.setDouble(3,payableAmount);
			psmt3.setDouble(4,amount2);
			psmt3.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLSyntaxException("Table Not Found !!");
		}
	}

}
