package Services;

import java.util.ArrayList;

import Entity.Committee;
import Entity.Member;
import Entity.Transaction;
import JDBC.MemberDao;
import exceptions.DatabaseNotFoundException;
import exceptions.DriverNotFoundException;
import exceptions.MemberDaoException;
import exceptions.SQLSyntaxException;

public class Services {

	public int addMember(String name,String address,double amount,String contact) throws MemberDaoException, DriverNotFoundException, DatabaseNotFoundException {
		Member member=new Member(name,address,amount,contact);
		int success=0;
		MemberDao memberDao=new MemberDao();
		success=memberDao.addAccount(member);
		return success;
	}
	public ArrayList<Member> showAllMembers() throws DriverNotFoundException, DatabaseNotFoundException, SQLSyntaxException {
		ArrayList<Member> memberList=new ArrayList<Member>();
		MemberDao memberDao=new MemberDao();
		memberList=memberDao.fetchAll();
		return memberList;
	}
	public ArrayList<Committee> showAllComittee() throws DriverNotFoundException, DatabaseNotFoundException, SQLSyntaxException {
		ArrayList<Committee> comitteeList=new ArrayList<Committee>();
		MemberDao memberDao=new MemberDao();
		comitteeList=memberDao.fetchAllComittee();
		return comitteeList;
	}
	public boolean makePayment(int id,double payment) throws SQLSyntaxException, DriverNotFoundException, DatabaseNotFoundException {
		MemberDao memberDao=new MemberDao();
		boolean success=memberDao.updateAmount(id, payment);
		return success;
	}

	public ArrayList<Transaction> getStatement(int id) throws DriverNotFoundException, DatabaseNotFoundException, SQLSyntaxException {
		MemberDao memberDao=new MemberDao();
		ArrayList<Transaction> tList=new ArrayList<Transaction>();
		tList=memberDao.getDetails(id);
		return tList;
	}

	public int startCommittee(String name,double value,double interest,ArrayList<Integer> members) throws DriverNotFoundException, DatabaseNotFoundException, SQLSyntaxException{
		MemberDao memberDao=new MemberDao();
		int id=memberDao.createCommittee(name,value,interest);
		memberDao.addMembers(id,members);
		return id;
	}
	public ArrayList<Member> getAvailableMembers(int id) throws DriverNotFoundException, DatabaseNotFoundException, SQLSyntaxException{
		ArrayList<Member> al=new ArrayList<Member>();
		MemberDao memberDao=new MemberDao();
		al=memberDao.getAvailableIDs(id);
		return al;
	}
	public double getBaseBid(int comiteeid) throws DriverNotFoundException, DatabaseNotFoundException, SQLSyntaxException {
		MemberDao memberDao=new MemberDao();
		double amount=memberDao.calculateBaseBid(comiteeid);
		return amount;
	}
	public double closeBid(int comiteeid, int bidID, double finalBid) throws DriverNotFoundException, DatabaseNotFoundException, SQLSyntaxException {
		MemberDao memberDao=new MemberDao();
		double share=memberDao.calculteShare(comiteeid,finalBid);
		memberDao.updateAll(comiteeid,share);
		memberDao.updateComitee(comiteeid,bidID);
		return share;
	}
}
