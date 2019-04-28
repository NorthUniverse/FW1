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
        assertEquals("\r\n", outputStream.toString());
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
        DataSource.saveToDB("Dennis");
        String name = DataSource.queryNameColumn("Dennis", DataSource.COLUMN_EXCLUSIONS);
        System.out.println(name);
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