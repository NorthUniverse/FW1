package SecretSantaBonus;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class DataSourceTest {

    @Test
    public void openConnection() {
        DataSource.openConnection();
        OutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        assertEquals("", outputStream.toString());
        DataSource.closeConnection();
    }

    @Test
    public void closeConnection() {
        DataSource.openConnection();
        DataSource.closeConnection();
        OutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        assertEquals("", outputStream.toString());
        DataSource.closeConnection();
    }

    @Test
    public void initialize() {
        DataSource.initialize();
        OutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        assertEquals("", outputStream.toString());
        DataSource.closeConnection();
    }

    @Test
    public void queryNameColumn() {
        DataSource.initialize();
        DataSource.saveToDB("Arya");
        DataSource.addExclusionsToDB("Arya","NightKing");
        String name = DataSource.queryNameColumn("Arya", DataSource.COLUMN_EXCLUSIONS);
        assertEquals(",NightKing", name);
        DataSource.removeFromDB("Arya");
        DataSource.closeConnection();
    }

    @Test
    public void updateNameColumn() {
        DataSource.initialize();
        DataSource.saveToDB("Bran");
        DataSource.addExclusionsToDB("Bran","Theon");
        DataSource.updateNameColumn("Bran", DataSource.COLUMN_EXCLUSIONS, "childrenOfTheForest");
        String name = DataSource.queryNameColumn("Bran", DataSource.COLUMN_EXCLUSIONS);
        assertEquals("childrenOfTheForest", name);
        DataSource.removeFromDB("Bran");
        DataSource.closeConnection();
    }

    @Test
    public void saveToDB() {
        DataSource.initialize();
        DataSource.saveToDB("Hordor");
        DataSource.addExclusionsToDB("Hordor","WhiteWalker");
        String name = DataSource.queryNameColumn("Hordor", DataSource.COLUMN_EXCLUSIONS);
        assertEquals(",WhiteWalker", name);
        DataSource.removeFromDB("Hordor");
        DataSource.closeConnection();
    }

    @Test
    public void removeFromDB() {
        DataSource.initialize();
        DataSource.saveToDB("Sansa");
        DataSource.removeFromDB("Sansa");
        String name = DataSource.queryNameColumn("Sansa", DataSource.COLUMN_EXCLUSIONS);
        assertEquals("", name);
        DataSource.closeConnection();
    }

    @Test
    public void readFromDB() {
        DataSource.initialize();
        LinkedList<Person> personsPlaying = new LinkedList<Person>();
        DataSource.saveToDB("Tyrion");
        DataSource.readFromDB(personsPlaying);
        int personListSize = personsPlaying.size();
        assertTrue(personListSize >=  1);
        DataSource.removeFromDB("Tyrion");
        DataSource.closeConnection();
    }

    @Test
    public void addExclusionsToDB() {
        DataSource.initialize();
        DataSource.saveToDB("Dragon1");
        DataSource.addExclusionsToDB("Dragon1","Dragon2");
        String name = DataSource.queryNameColumn("Dragon1", DataSource.COLUMN_EXCLUSIONS);
        assertEquals(",Dragon2", name);
        DataSource.removeFromDB("Dragon1");
        DataSource.closeConnection();
    }

    @Test
    public void saveSecretSantaToDB() {
        DataSource.initialize();
        DataSource.saveToDB("sirDavos");
        DataSource.saveSecretSantaToDB("sirDavos","Jorah");
        String name = DataSource.queryNameColumn("sirDavos", DataSource.COLUMN_SECRETSANTAFOR);
        assertEquals(",Jorah", name);
        DataSource.removeFromDB("sirDavos");
        DataSource.closeConnection();
    }
}