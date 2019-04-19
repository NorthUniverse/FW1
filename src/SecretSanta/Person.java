package SecretSanta;

import java.util.List;

public class Person {

    private String name;
    private int NumberOfImmediateFamilyMembers;
    private List<Person> immediateFamilyMembers;
	private boolean isSecertSanta;
    private String isSecrectSantaOf;

    public Person(String name) {
        this.name = name;
    }

	public String getName() {
		return name;
	}

	public int getNumberOfImmediateFamilyMembers() {
		return NumberOfImmediateFamilyMembers;
	}

	public void setNumberOfImmediateFamilyMembers(int numberOfImmediateFamilyMembers) {
		NumberOfImmediateFamilyMembers = numberOfImmediateFamilyMembers;
	}

	public boolean isSecertSanta() {
		return isSecertSanta;
	}

	public void setSecertSanta(boolean secertSanta) {
		isSecertSanta = secertSanta;
	}

	public List<Person> getImmediateFamilyMembers() {
		return immediateFamilyMembers;
	}

	public void setIsSecrectSantaOf(String isSecrectSantaOf) {
		this.isSecrectSantaOf = isSecrectSantaOf;
	}
}
