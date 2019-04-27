package SecretSantaBonus;

import static org.junit.Assert.assertEquals;

public class PersonTest {

	private Person Jon;

	@org.junit.Before
	public void before() {
		Jon = new Person("Jon");
		System.out.println("Running test for person class... ");
	}

	@org.junit.Test
	public void getName() {
		assertEquals(Jon.getName(), "Jon");
	}

	@org.junit.Test
	public void setSecrectSantaFor() {
		Jon.setSecrectSantaFor("Daenerys");
		assertEquals(Jon.getSecrectSantaFor().get(0), "Daenerys");
	}

	@org.junit.Test
	public void getExclusions() {
		Jon.setExclusions("Daenerys");
		String exclusion = Jon.getExclusions().get(0);
		assertEquals(exclusion, "Daenerys");
	}

	@org.junit.Test
	public void setExclusions() {
		Jon.setExclusions("Daenerys");
		assertEquals(Jon.getExclusions().get(0), "Daenerys");
	}

	@org.junit.Test
	public void getSecrectSantaFor() {
		Jon.setSecrectSantaFor("Daenerys");
		String secrectSanta = Jon.getSecrectSantaFor().get(0);
		assertEquals(secrectSanta, "Daenerys");
	}
}