package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.Account;

public class LoginDaoImpl implements LoginDao {

	@Override
	public Account login(String username, String password) {
		Connection cons= DBConnect.getConnection();
		String sql = "Select * from accountTBL where Username like ? and PASSWORD like ?";
		Account tk= null;
		try {
			PreparedStatement ps = (PreparedStatement)cons.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			 ResultSet rs = ps.executeQuery();
			 if(rs.next()) {
				 tk = new Account();
				tk.setAccount(rs.getString("Username"));
				tk.setPasword(rs.getString("PASSWORD"));
			 }
			 ps.close();
			 cons.close();
			 return tk;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
