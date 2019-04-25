package SecretSanta;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GameMethodsTest {


	List<Person> personsPlaying;

	@org.junit.Before
	public void before() {
		personsPlaying = new ArrayList<>();
		System.out.println("Running test for GameMethods class... ");
	}

//	@org.junit.Test
//	public void enterData() {
//		String input0 = "3";
//		ByteArrayInputStream in0 = new ByteArrayInputStream(input0.getBytes());
//		System.setIn(in0);

//		String input1 = "Dog";
//		InputStream in1 = new ByteArrayInputStream(input1.getBytes());
//		System.setIn(in1);
//		String input2 = "Cat";
//		InputStream in2 = new ByteArrayInputStream(input2.getBytes());
//		System.setIn(in2);
//		String input3 = "Mouse";
//		InputStream in3 = new ByteArrayInputStream(input3.getBytes());
//		System.setIn(in3);
//		GameMethods.enterData(personsPlaying);
//		assertEquals(3, personsPlaying.size());
//	}

	@org.junit.Test
	public void addPerson() {
		String input = "Phil";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		GameMethods.addPerson(personsPlaying);
		assertEquals("Phil", personsPlaying.get(0).getName());
	}

	@org.junit.Test
	public void removePerson() {
		String addInput = "Phil";
		InputStream addIn = new ByteArrayInputStream(addInput.getBytes());
		System.setIn(addIn);
		GameMethods.addPerson(personsPlaying);
		String removeInput = "Phil";
		InputStream removeIn = new ByteArrayInputStream(removeInput.getBytes());
		System.setIn(removeIn);
		GameMethods.removePerson(personsPlaying);
		assertEquals(0, personsPlaying.size());
	}

	@org.junit.Test
	public void printPersons() {
		String addInput = "Phil";
		InputStream addIn = new ByteArrayInputStream(addInput.getBytes());
		System.setIn(addIn);
		GameMethods.addPerson(personsPlaying);
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		GameMethods.printPersons(personsPlaying);
		assertEquals("\nPerson List:\r\nPhil\r\n", os.toString());
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

//	@org.junit.Test
//	public void shuffleAndAssignSecretSanta() {
//	}
//
//	@org.junit.Test
//	public void setExclusions() {
//	}
}