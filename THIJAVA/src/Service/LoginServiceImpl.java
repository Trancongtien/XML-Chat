package Service;

import Dao.*;
import Model.Account;

public class LoginServiceImpl implements LoginService {
	 public LoginDao logInDao=null;
	 public LoginServiceImpl() {
		 logInDao= new LoginDaoImpl(); 
	 }
	@Override
	public Account login(String username, String password) {
		// TODO Auto-generated method stub
		return logInDao.login(username, password);
	}

}
