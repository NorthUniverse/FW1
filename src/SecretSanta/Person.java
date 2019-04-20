package SecretSanta;

import java.util.List;

public class Person {

    private String name;
    private int numberOfImmediateFamilyMembers;
    private List<Person> immediateFamilyMembers; //List for exclusions(immediate family menbers)
	private boolean isSecertSanta;
    private String isSecrectSantaOf;

    public Person(String name) {
        this.name = name;
        this.isSecertSanta = false;
        this.isSecrectSantaOf = "";
    }

	public String getName() {
		return this.name;
	}

	public int getNumberOfImmediateFamilyMembers() {
		return this.numberOfImmediateFamilyMembers;
	}

	public void setNumberOfImmediateFamilyMembers(int numberOfImmediateFamilyMembers) {
		this.numberOfImmediateFamilyMembers = numberOfImmediateFamilyMembers;
	}

	public boolean isSecertSanta() {
		return this.isSecertSanta;
	}

	public void setSecertSanta(boolean secertSanta) {
		this.isSecertSanta = secertSanta;
	}

	public void setIsSecrectSantaOf(String isSecrectSantaOf) {
		this.isSecrectSantaOf = isSecrectSantaOf;
	}

	public void setImmediateFamilyMembers(String name) {
        this.immediateFamilyMembers.add(new Person(name));
    }

    public List<Person> getImmediateFamilyMembers() {
        return this.immediateFamilyMembers;
    }
}
