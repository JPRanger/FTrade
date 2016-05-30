package accounts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountObject {
	private static Connection conn = UserAccountConnectionDB.dbConnector();
	// private String userName = null;
	// private String passWord = null;
	// private String eMail = null;
	// private Double funds = 0.0;
	// private int rowID = 0;

	/**
	 * Returns boolean indicating userName, and password is valid
	 */
	public boolean loginUser(String userName, String passWord) throws SQLException {
		String accountAll = "Select NAME, PASSWORD from userAccount";
		PreparedStatement prepareAccounts = conn.prepareStatement(accountAll);
		ResultSet rs = prepareAccounts.executeQuery();
		while (rs.next()) {
			if (rs.getString("NAME").equals(userName) && rs.getString("PASSWORD").equals(passWord)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns password to corresponding email parameter
	 */
	public String getPassword(String eMail) throws SQLException {
		String accountAll = "Select EMAIL, PASSWORD from userAccount";
		PreparedStatement prepareAccounts = conn.prepareStatement(accountAll);
		ResultSet rs = prepareAccounts.executeQuery();
		while (rs.next()) {
			if (rs.getString("EMAIL").equals(eMail)) {
				return rs.getString("PASSWORD");
			}
		}
		return null;
	}

	/**
	 * Returns password to corresponding email parameter
	 */
	public String getEmail(String eMail) throws SQLException {
		String accountAll = "Select EMAIL, PASSWORD from userAccount";
		PreparedStatement prepareAccounts = conn.prepareStatement(accountAll);
		ResultSet rs = prepareAccounts.executeQuery();
		while (rs.next()) {
			if (rs.getString("EMAIL").equals(eMail)) {
				return rs.getString("EMAIL");
			}
		}
		return null;
	}

	public static void main(String[] args) throws SQLException {

	}
}
