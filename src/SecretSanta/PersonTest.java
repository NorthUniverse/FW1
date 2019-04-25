package SecretSanta;

import static org.junit.Assert.assertEquals;

public class PersonTest {

	private Person tim;

	@org.junit.Before
	public void before() {
		tim = new Person("Tim");
		System.out.println("Running test for person class... ");
	}

	@org.junit.Test
	public void getName() {
		assertEquals(tim.getName(),"Tim");
	}

	@org.junit.Test
	public void setSecrectSantaFor() {
		tim.setSecrectSantaFor("Jane");
		assertEquals(tim.getSecrectSantaFor().get(0),"Jane");
	}

	@org.junit.Test
	public void getExclusions() {
		tim.setExclusions("Jane");
		String exclusion = tim.getExclusions().get(0);
		assertEquals(exclusion,"Jane");
	}

	@org.junit.Test
	public void setExclusions() {
		tim.setExclusions("Jane");
		assertEquals(tim.getExclusions().get(0),"Jane");
	}

	@org.junit.Test
	public void getSecrectSantaFor() {
		tim.setSecrectSantaFor("Jane");
		String secrectSanta = tim.getSecrectSantaFor().get(0);
		assertEquals(secrectSanta,"Jane");
	}
}