package SecretSanta;

import java.util.ArrayList;
import java.util.List;

public class Person {

	private String name;
	private List<String> exclusions; //List for exclusions(immediate family menbers)
	private List<String> secrectSantaFor;
	private List<String> canGiftToList;

	public Person(String name) {
		this.name = name;
		this.exclusions = new ArrayList<>();
		this.canGiftToList = new ArrayList<>();
		this.secrectSantaFor = new ArrayList<>();
	}

	public String getName() {
		return this.name;
	}

	public void setSecrectSantaFor(String secrectSantaOf) {
		this.secrectSantaFor.add(secrectSantaOf);
	}

	public List<String> getExclusions() {
		return this.exclusions;
	}

	public void setExclusions(String name) {
		this.exclusions.add(name);
	}

	public List<String> getCanGiftToList() {
		return canGiftToList;
	}

	public void setCanGiftToList(String name) {
		this.canGiftToList.add(name);
	}

	public List<String> getSecrectSantaFor() {
		return this.secrectSantaFor;
	}
}
