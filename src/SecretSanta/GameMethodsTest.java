package SecretSanta;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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

	@Test
	public void enterData() {
		String input1 = "1";
		ByteArrayInputStream in1;
		in1 = new ByteArrayInputStream(input1.getBytes());
		System.setIn(in1);
		String input2 = "Hannah";
		InputStream in2 = new ByteArrayInputStream(input2.getBytes());
		System.setIn(in2);
		GameMethods.enterData(personsPlaying);
		assertEquals("Hannah", personsPlaying.get(0).getName());
	}

//	@org.junit.Test
//	public void addPerson() {
//		String input = "Phil";
//		InputStream in = new ByteArrayInputStream(input.getBytes());
//		System.setIn(in);
//		GameMethods.addPerson(personsPlaying);
//		assertEquals("Phil", personsPlaying.get(0).getName());
//	}

//	@org.junit.Test
//	public void removePerson() {
//	}
//
//	@org.junit.Test
//	public void printPersons() {
//	}
//
//	@org.junit.Test
//	public void playSecretSanta() {
//	}
//
//	@org.junit.Test
//	public void shuffleAndAssignSecretSanta() {
//	}
//
//	@org.junit.Test
//	public void setExclusions() {
//	}
}