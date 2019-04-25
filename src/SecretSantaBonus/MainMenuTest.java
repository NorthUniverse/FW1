package SecretSantaBonus;

import SecretSanta.MainMenu;

import java.io.ByteArrayInputStream;

public class MainMenuTest {

	@org.junit.Test
	public void run() {
		String choiceInput = "7";
		ByteArrayInputStream choiceInputBuffer = new ByteArrayInputStream(choiceInput.getBytes());
		System.setIn(choiceInputBuffer);
		(new Thread(new MainMenu())).start();
	}
}