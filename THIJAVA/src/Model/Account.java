package Model;

public class Account {
private String account;
private String pasword;
public Account(String account, String pasword) {
	super();
	this.account = account;
	this.pasword = pasword;
}
public Account() {
	super();
}
public String getAccount() {
	return account;
}
public void setAccount(String account) {
	this.account = account;
}
public String getPasword() {
	return pasword;
}
public void setPasword(String pasword) {
	this.pasword = pasword;
}

}
