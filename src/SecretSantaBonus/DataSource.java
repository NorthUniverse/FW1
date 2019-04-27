package SecretSantaBonus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static SecretSantaBonus.DataSource.openConnection;

public class DataSource {

	public static final String DB_NAME = "secretSanta.db";
	public static final String CONNECTION_STRING ="jdbc:sqlite:c:\\Users\\denni\\Documents\\MyJavaProjects\\FW1\\src\\SecretSantaBonus\\" + DB_NAME;
//	public static final String CONNECTION_STRING = "jdbc:sqlite:c:\\FW1\\src\\SecretSantaBonus\\" + DB_NAME;

	public static final String TABLE_PERSONS = "persons";

	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_EXCLUSIONS = "exclusions";
	public static final String COLUMN_SECRETSANTAFOR = "secretSantaFor";

	private static Connection connection;

	private static void openConnection() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void closeConnection() {
        try {
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldnt close connection " + e.getMessage());
            e.printStackTrace();
        }
    }

	public static void initialize() {
	    Statement statement = null;
	    try {
            openConnection();
            statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_PERSONS +
                    " (" + COLUMN_NAME + " text, " +
                    COLUMN_EXCLUSIONS + " text, "  +
                    COLUMN_SECRETSANTAFOR + " text" +
                    " )");
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        } finally {
	        try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println("SQL Exception: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static void saveToDB(List<Person> personList) throws SQLException {
        Statement statement = connection.createStatement();
	    for (Person eachPerson : personList) {
	        String name = eachPerson.getName();
	        String exclusions = listToString(eachPerson.getExclusions());
	        String secretSantaFor = listToString(eachPerson.getSecrectSantaFor());
	        insertToDB(statement, name, exclusions, secretSantaFor);
        }
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void insertToDB(Statement statement, String name, String exclusions, String secretSantaFor) throws SQLException{
        			statement.execute("INSERT INTO " + TABLE_PERSONS +
                                   " (" +  COLUMN_NAME + "," +
                                          COLUMN_EXCLUSIONS + "," +
                                          COLUMN_SECRETSANTAFOR +
                                   " ) " +
					               "VALUES(" + name + ","+ exclusions + ","+ secretSantaFor + ")");
    }

    public static List<Person> readFromDB() throws SQLException {
        Statement statement = connection.createStatement();
	    List<Person> personList = new ArrayList<>();

        ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_PERSONS);

        while(results.next()) {
            System.out.println(results.getString(COLUMN_NAME) + " " +
                    results.getString(COLUMN_EXCLUSIONS) + " " +
                    results.getString(COLUMN_SECRETSANTAFOR));
            personList.add(new Person(results.getString(COLUMN_NAME)));

        }
        results.close();
        statement.close();
//        conn.close();

	    return personList;
    }


	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection(CONNECTION_STRING);
			Statement statement = conn.createStatement();
//			statement.execute("DROP TABLE IF EXISTS " + TABLE_PERSONS);
			statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_PERSONS +
					               " (" + COLUMN_NAME + " text, " +
                                          COLUMN_EXCLUSIONS + " text, "  +
                                          COLUMN_SECRETSANTAFOR + " text" +
                                   " )");

			ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_PERSONS);

			while(results.next()) {
				System.out.println(results.getString(COLUMN_NAME) + " " +
									results.getString(COLUMN_EXCLUSIONS) + " " +
									results.getString(COLUMN_SECRETSANTAFOR));
			}
			results.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("SQL Exception: " + e.getMessage());
			e.printStackTrace();
		}


	}

	private static String listToString(List<String> stringList) {
	    String string = "";
	    for(String eachString : stringList) {
	        string = string + eachString + ",";
        }
        return string;
    }

    private static List<String> stringToList(String string) {
	    String[] arrayString = string.split(",");
	    List<String> stringList = new ArrayList<>();
        Collections.addAll(stringList, arrayString);
        return stringList;
    }



}
