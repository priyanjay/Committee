package Entity;

import java.sql.Date;

public class Member {
	public String memberName;
	public int memberID=0;
	public String memberAddress;
	public double balance=0;
	public Date joinDate=null;
	public String contact=null;
	public Member(String name,String address,double amount,String contact) {
		this.memberName=name;
		this.memberAddress=address;
		this.balance=amount;
		this.contact=contact;
	}
	public Member() {
		Some random thing
	}
}
