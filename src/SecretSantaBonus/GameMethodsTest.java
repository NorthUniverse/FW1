package SecretSantaBonus;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GameMethodsTest {


	List<Person> personsPlaying;

	@org.junit.Before
	public void before() {
		personsPlaying = new ArrayList<>();
		System.out.println("Running test for GameMethods class... ");
	}

	@org.junit.Test
	public void enterData() {
		String choiceInput = "0";
		ByteArrayInputStream choiceInputBuffer = new ByteArrayInputStream(choiceInput.getBytes());
		System.setIn(choiceInputBuffer);
		GameMethods.enterData(personsPlaying);
		assertEquals(0, personsPlaying.size());
	}

	@org.junit.Test
	public void addPerson() {
		String input = "Stark";
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);
		GameMethods.addPerson(personsPlaying);
		assertEquals("Stark", personsPlaying.get(0).getName());
	}

	@org.junit.Test
	public void removePerson() {
		String addInput = "Lannister";
		InputStream addInputStream = new ByteArrayInputStream(addInput.getBytes());
		System.setIn(addInputStream);
		GameMethods.addPerson(personsPlaying);
		String removeInput = "Lannister";
		InputStream removeInputStream = new ByteArrayInputStream(removeInput.getBytes());
		System.setIn(removeInputStream);
		GameMethods.removePerson(personsPlaying);
		assertEquals(0, personsPlaying.size());
	}

	@org.junit.Test
	public void printPersons() {
		String input = "Targaryen";
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);
		GameMethods.addPerson(personsPlaying);
		OutputStream outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		System.setOut(printStream);
		GameMethods.printPersons(personsPlaying);
		assertEquals("\nPerson List:\r\nTargaryen\r\n", outputStream.toString());
		PrintStream originalOut = System.out;
		System.setOut(originalOut);
	}

	@org.junit.Test
	public void playSecretSanta() {
		Person Dennis = new Person("Dennis");
		Person Oishi = new Person("Oishi");
		Person Rahul = new Person("Rahul");
		Person Sharon = new Person("Sharon");
		Person Rita = new Person("Rita");
		Person James = new Person("James");
		Person Russel = new Person("Russel");
		Person Nancy = new Person("Nancy");
		Person John = new Person("John");

		personsPlaying.add(Dennis);
		personsPlaying.add(Oishi);
		personsPlaying.add(Rahul);
		personsPlaying.add(Sharon);
		personsPlaying.add(Rita);
		personsPlaying.add(James);
		personsPlaying.add(Russel);
		personsPlaying.add(Nancy);
		personsPlaying.add(John);

		Dennis.setExclusions("Oishi");
		Dennis.setExclusions("Sharon");
		Oishi.setExclusions("Dennis");
		Oishi.setExclusions("Rita");
		Sharon.setExclusions("Dennis");
		Rita.setExclusions("Oishi");

		String addInput = "Y";
		InputStream addIn = new ByteArrayInputStream(addInput.getBytes());
		System.setIn(addIn);
		GameMethods.playSecretSanta(personsPlaying);
		assertNotEquals("Dennis", personsPlaying.get(0).getSecrectSantaFor().get(0));
		assertNotEquals("Oishi", personsPlaying.get(1).getSecrectSantaFor().get(0));
		assertNotEquals("Rahul", personsPlaying.get(2).getSecrectSantaFor().get(0));
		assertNotEquals("Sharon", personsPlaying.get(3).getSecrectSantaFor().get(0));
		assertNotEquals("Rita", personsPlaying.get(4).getSecrectSantaFor().get(0));
		assertNotEquals("James", personsPlaying.get(5).getSecrectSantaFor().get(0));
		assertNotEquals("Russel", personsPlaying.get(6).getSecrectSantaFor().get(0));
		assertNotEquals("Nancy", personsPlaying.get(7).getSecrectSantaFor().get(0));
		assertNotEquals("John", personsPlaying.get(8).getSecrectSantaFor().get(0));
	}

	@org.junit.Test
	public void shuffleAndAssignSecretSanta() {
		personsPlaying.add(new Person("Jon"));
		personsPlaying.add(new Person("Snow"));
		int secrectSanataSizeBeforeShuffle = personsPlaying.get(0).getSecrectSantaFor().size();
		GameMethods.shuffleAndAssignSecretSanta(personsPlaying);
		int secrectSanataSizeAfterShuffle = personsPlaying.get(0).getSecrectSantaFor().size();
		assertNotEquals(secrectSanataSizeBeforeShuffle, secrectSanataSizeAfterShuffle);
	}

	@org.junit.Test
	public void setExclusions() {
		personsPlaying.add(new Person("Robert"));
		String choiceInput = "0";
		InputStream choiceInputStream = new ByteArrayInputStream(choiceInput.getBytes());
		System.setIn(choiceInputStream);
		GameMethods.setExclusions(personsPlaying);
		assertEquals(0, personsPlaying.get(0).getExclusions().size());
	}
}