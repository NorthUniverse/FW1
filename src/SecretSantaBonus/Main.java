package SecretSantaBonus;

import SecretSanta.MainMenu;

public class Main {

	public static void main(String[] args) {
		// starts a new Thread every time the program is run
		(new Thread(new MainMenu())).start();
	}
}
