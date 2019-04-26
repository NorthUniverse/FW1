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
//			statement.execute("INSERT INTO person (name, exclusions, secretSantaFor) " +
//					               "VALUES('Jon','Sumo','Sam')");
			statement.execute("CREATE TABLE IS NOT EXISTS person " +
					" (name TEXT, exclusuions TEXT, secretSantaFor TEXT)");
			statement.execute("CREATE TABLE IS NOT EXISTS person " +
					" (name TEXT, exclusuions TEXT, secretSantaFor TEXT)");

			statement.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("SQL Exception: " + e.getMessage());
		}
	}

}
