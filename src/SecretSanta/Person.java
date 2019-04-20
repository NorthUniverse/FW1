package SecretSanta;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
	private List<String> exclusions; //List for exclusions(immediate family menbers)
    private String isSecrectSantaOf;
    private List<String> canGiftToList;

    public Person(String name) {
        this.name = name;
		exclusions = new ArrayList<>();
		canGiftToList = new ArrayList<>();
        this.isSecrectSantaOf = "";
    }

	public String getName() {
		return this.name;
	}

	public void setIsSecrectSantaOf(String isSecrectSantaOf) {
		this.isSecrectSantaOf = isSecrectSantaOf;
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

	public String getIsSecrectSantaOf() {
		return isSecrectSantaOf;
	}
}
