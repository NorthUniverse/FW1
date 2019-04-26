package SecretSantaBonus;

import oracle.jrockit.jfr.tools.ConCatRepository;
import org.sqlite.core.DB;

import java.sql.*;

public class DataSource {

	public static final String DB_NAME = "secretSanta.db";
	public static final String CONNECTION_STRING = "jdbc:sqlite:c:\\FW1\\src\\SecretSantaBonus\\" + DB_NAME;

	public static final String TABLE_PERSONS = "persons";

	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_EXCLUSIONS = "exclusions";
	public static final String COLUMN_SECRETSANTAFOR = "secretSantaFor";

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection(CONNECTION_STRING);
			Statement statement = conn.createStatement();
			statement.execute("DROP TABLE IF EXISTS " + TABLE_PERSONS);
			statement.execute("CREATE TABLE IF NOT EXISTS persons " +
					               " (name TEXT, exclusions TEXT, secretSantaFor TEXT)");
//			statement.execute("INSERT INTO persons (name, exclusions, secretSantaFor) " +
//					               "VALUES('Dennis','Oishi','Omi')");
//			statement.execute("INSERT INTO persons (name, exclusions, secretSantaFor) " +
//					"VALUES('Oishi','Dennis','Rahul')");
//			statement.execute("INSERT INTO persons (name, exclusions, secretSantaFor) " +
//					"VALUES('Rahul','','Dennis')");
//			statement.execute("UPDATE persons SET secretSantaFor = 'stringList' WHERE name = 'query name'");
//			statement.execute("DELETE FROM persons WHERE name = 'query name'");

//			statement.execute("SELECT * FROM persons");
//			ResultSet results = statement.getResultSet();

			ResultSet results = statement.executeQuery("SELECT * FROM persons");

			while(results.next()) {
				System.out.println(results.getString("name") + " " +
									results.getString("exclusions") + " " +
									results.getString("secretSantaFor"));
			}
			results.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("SQL Exception: " + e.getMessage());
		}
	}

}
