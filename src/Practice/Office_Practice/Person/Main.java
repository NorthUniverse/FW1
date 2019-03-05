package Practice.Office_Practice.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Person sankeerth = new Person("Sankeerth","Kakarna", 29);
		Person richard = new Person("Richard","McLeggon", 40);
		Person dennis = new Person("Dennis","Richard", 32);
		Person mizan = new Person("Mizan","Mossain", 27);
		Person john = new Person("John","Cunningham", 32);
		Person lisa = new Person("Lisa","Caton", 30);
		Person anuj = new Person("Anuj","Arora", 28);

		List<Person> persons = new ArrayList<>();

		persons.add(sankeerth);
		persons.add(richard);
		persons.add(dennis);
		persons.add(mizan);
		persons.add(john);
		persons.add(lisa);
		persons.add(anuj);

		System.out.println(" ");
		System.out.println("Printing Persons: ");
		printPersons(persons);
		System.out.println(" ");
		System.out.println("Persons after sorting with Last Name field: ");
		sortPersonsLastName(persons);
		printPersons(persons);
		System.out.println(" ");
		System.out.println("Persons with Last Name starting with C: ");
		printLastNameWithCs(persons);

		System.out.println(" ");
		System.out.println("Printing Persons using Lambdas: ");
		printPersonsUsingLambdas(persons);
		System.out.println(" ");
		System.out.println("Persons after sorting with Last Name field using Lambdas: ");
		sortPersonsLastNameUsingLambdas(persons);
		printPersons(persons);
		System.out.println(" ");
		System.out.println("Persons with Last Name starting with C using Lambdas: ");
		printLastNameWithCsUsingLambdas(persons);
	}

	public static void printPersons(List<Person> persons) {
		for(Person person : persons) {
			System.out.println(person.getPerson());
		}
	}

	public static void sortPersonsLastName(List<Person> persons) {
		Collections.sort(persons, new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return p1.getLastName().compareToIgnoreCase(p2.getLastName());
			}
		});
	}

	public static void printLastNameWithCs(List<Person> persons) {
		for(Person person : persons) {
			if(person.getUpperLastName().startsWith("C")){
				System.out.println(person.getPerson());
			}
		}
	}

	public static void printPersonsUsingLambdas(List<Person> persons) {
		persons.forEach(a -> System.out.println(a.getPerson()));
	}

	public static void sortPersonsLastNameUsingLambdas(List<Person> persons) {
		Collections.sort(persons, (Person p1, Person p2) -> p1.getLastName().compareToIgnoreCase(p2.getLastName()));
	}

	public static void printLastNameWithCsUsingLambdas(List<Person> persons) {
		persons
                .stream()
                .filter(x -> x.getUpperLastName().startsWith("C"))
                .forEach(y -> System.out.println(y.getPerson()));
	}

}
