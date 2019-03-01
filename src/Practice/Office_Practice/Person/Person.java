package Practice.Office_Practice.Person;

public class Person {
	String firstName;
	String lastName;
	int age;

	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{" +
				"firstName='" + firstName + '\'' +
				", LastName='" + lastName + '\'' +
				", age=" + age +
				'}';
	}

	public String getPerson() {
		return ("First Name = " + this.firstName + " Last Name = " + this.lastName + " Age = " + this.age);
	}
}
