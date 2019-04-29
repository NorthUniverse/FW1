package SecretSantaBonus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DataSource {

	public static final String DB_NAME = "secretSanta.db";
	public static final String CONNECTION_STRING ="jdbc:sqlite:c:\\Users\\denni\\Documents\\MyJavaProjects\\FW1\\src\\SecretSantaBonus\\" + DB_NAME;
//	public static final String CONNECTION_STRING = "jdbc:sqlite:c:\\FW1\\src\\SecretSantaBonus\\" + DB_NAME;

	public static final String TABLE_PERSONS = "persons";

	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_EXCLUSIONS = "exclusions";
	public static final String COLUMN_SECRETSANTAFOR = "secretSantaFor";

	private static Connection connection;

	public static void openConnection() {
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

    private static void insertToDB(Statement statement, String name, String exclusions, String secretSantaFor) throws SQLException{
//        statement.execute("INSERT INTO " + TABLE_PERSONS +
//                " (" +  COLUMN_NAME + ", " +
//                COLUMN_EXCLUSIONS + ", " +
//                COLUMN_SECRETSANTAFOR +
//                ") " +
//                "VALUES ('" + "Dennis" + "', '" + "" + "', '" + ""+ "')")
	    statement.execute("INSERT INTO " + TABLE_PERSONS +
                " (" +  COLUMN_NAME + ", " +
                COLUMN_EXCLUSIONS + ", " +
                COLUMN_SECRETSANTAFOR +
                ") " +
                "VALUES ('" + name + "', '" + exclusions + "', '" + secretSantaFor + "')");
    }

    private static void deleteFromDB(Statement statement, String name) throws SQLException{
        statement.execute("DELETE FROM " + TABLE_PERSONS +
                " WHERE" +  COLUMN_NAME + " = " + name + ")");
    }

    public static String queryNameColumn(String name, String columnName) {
        String queryResult = "";
	    try {
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("SELECT " + columnName +
                                                           " FROM " + TABLE_PERSONS +
                                                           " WHERE " + COLUMN_NAME + " = " + name);
            while(results.next()) {
                queryResult = results.getString(columnName);
            }
            results.close();
            if (statement != null) {
                statement.close();
            }
            return queryResult;
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        } finally {
            return queryResult;
        }
    }

    public static void updateNameColumn(String name, String columnName, String newColumnValue) {
        String queryResult = "";
        try {
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("UPDATE " + TABLE_PERSONS +
                                                            " SET " + columnName +
                                                            " = " + newColumnValue +
                                                            " WHERE " + COLUMN_NAME +
                                                            " = " + name);
            results.close();
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void saveToDB(List<Person> personList) {
	    try {
            Statement statement = connection.createStatement();
            for (Person eachPerson : personList) {
                String name = eachPerson.getName();
                String exclusions = listToString(eachPerson.getExclusions());
                String secretSantaFor = listToString(eachPerson.getSecrectSantaFor());
                insertToDB(statement, name, exclusions, secretSantaFor);
            }
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void saveToDB(String name) {
        try {
            Statement statement = connection.createStatement();
            insertToDB(statement, name, "", "");
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void removeFromDB(String name) {
        try {
            Statement statement = connection.createStatement();
            deleteFromDB(statement, name);
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static List<Person> readFromDB() {
	    try {
            Statement statement = connection.createStatement();
            List<Person> personList = new ArrayList<>();

            ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_PERSONS);
            int i = 0;

            while(results.next()) {
                personList.add(new Person(results.getString(COLUMN_NAME)));

                List<String> exclusionList = stringToList(results.getString(COLUMN_EXCLUSIONS));
                for (String eachExclusion : exclusionList) {
                    personList.get(i).setExclusions(eachExclusion);
                }
                List<String> santaList = stringToList(results.getString(COLUMN_SECRETSANTAFOR));
                for (String eachSanta : santaList) {
                    personList.get(i).setSecrectSantaFor(eachSanta);
                }
                i++;
            }
            results.close();
            if (statement != null) {
                statement.close();
            }
            return personList;
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        } finally {
	        return new ArrayList<>();
        }
    }

    public static void addExclusionsToDB(String personName, String exclusionName) {
	    String currentExclusions = queryNameColumn(personName, COLUMN_EXCLUSIONS);
	    currentExclusions = currentExclusions + "," + exclusionName;
	    updateNameColumn(personName, COLUMN_EXCLUSIONS, currentExclusions);
    }

    public static void saveSecretSantaToDB(String personName, String secretSanta) {
        String currentSecretSanta = queryNameColumn(personName, COLUMN_SECRETSANTAFOR);
        currentSecretSanta = currentSecretSanta + "," + secretSanta;
        updateNameColumn(personName, COLUMN_SECRETSANTAFOR, currentSecretSanta);
    }


	public static void main(String[] args) {
	    int i =1;
		try {
			Connection conn = DriverManager.getConnection(CONNECTION_STRING);
			Statement statement = conn.createStatement();
//			statement.execute("DROP TABLE IF EXISTS " + TABLE_PERSONS);
			statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_PERSONS +
					               " (" + COLUMN_NAME + " text, " +
                                          COLUMN_EXCLUSIONS + " text, "  +
                                          COLUMN_SECRETSANTAFOR + " text" +
                                   " )");

            statement.execute("INSERT INTO " + TABLE_PERSONS +
                    " (" +  COLUMN_NAME + ", " +
                    COLUMN_EXCLUSIONS + ", " +
                    COLUMN_SECRETSANTAFOR +
                    ") " +
                    "VALUES ('" + "Rahul" + "', '" + "" + "', '" + ""+ "')");

            System.out.println(i);
            i++;

//			ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_PERSONS);
            ResultSet results = statement.executeQuery("SELECT " + columnName +
                    " FROM " + TABLE_PERSONS +
                    " WHERE " + COLUMN_NAME + " = " + name);

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
