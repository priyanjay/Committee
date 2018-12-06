package Services;

public class Admin {
	String username="Admin";
	String password="password";
	public boolean validateLogin(String userName,String password){
		boolean valid=false;
		if(userName.equals(username)&& this.password.equals(password)) {
			valid=true;
		}else {
			valid=false;
		}
		return valid;
	}
}
