package SecretSantaBonus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSource {
	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:c:\\secretSanta.db");
			Statement statement = conn.createStatement();
			statement.execute("CREATE TABLE IS NOT EXISTS person " +
					               " (name TEXT, exclusuions TEXT, secretSantaFor TEXT)");
		} catch (SQLException e) {
			System.out.println("SQL Exception: " + e.getMessage());
		}
	}

}
