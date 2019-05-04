package SecretSantaBonus;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class DataSourceTest {

    @Test
    public void openConnection() {
        DataSource.openConnection();
        OutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        assertEquals("", outputStream.toString());
    }

    @Test
    public void closeConnection() {
        DataSource.openConnection();
        DataSource.closeConnection();
        OutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        assertEquals("", outputStream.toString());
    }

    @Test
    public void initialize() {
        DataSource.initialize();
        OutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        assertEquals("", outputStream.toString());
    }

    @Test
    public void queryNameColumn() {
        DataSource.initialize();
        DataSource.saveToDB("Arya");
        DataSource.addExclusionsToDB("Arya","NightKing");
        String name = DataSource.queryNameColumn("Arya", DataSource.COLUMN_EXCLUSIONS);
        assertEquals(",NightKing", name);
        DataSource.removeFromDB("Arya");
    }

    @Test
    public void updateNameColumn() {
    }

    @Test
    public void saveToDB() {
    }

    @Test
    public void saveToDB1() {
    }

    @Test
    public void removeFromDB() {
    }

    @Test
    public void readFromDB() {
    }

    @Test
    public void addExclusionsToDB() {
    }

    @Test
    public void saveSecretSantaToDB() {
    }

    @Test
    public void main() {
    }
}