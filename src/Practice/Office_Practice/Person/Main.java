package Practice.Office_Practice.Person;

import java.util.ArrayList;
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
		System.out.println("Printing Persons using functional Interfaces: ");
		printPersonsUsingFunctionalInterface(persons);
		System.out.println(" ");
		System.out.println("Persons after sorting with Last Name field using functional Interfaces: ");
		sortPersonsLastNameUsingFunctionalInterface(persons);
		printPersons(persons);
		System.out.println(" ");
		System.out.println("Persons with Last Name starting with C using functional Interfaces: ");
		printLastNameWithCsUsingFunctionalInterface(persons);
	}

	public static void printPersons(List<Person> persons) {
		for(Person person : persons) {
			System.out.println(person.getPerson());
		}
	}

	public static void sortPersonsLastName(List<Person> persons) {
        for(int i = 0; i < persons.size(); i++) {
            for(int j = i+1; j < persons.size(); j++) {
                if (persons.get(i).getUpperLastName().compareTo(persons.get(j).getUpperLastName()) > 0) {
                    Person temp = persons.get(i);
                    persons.set(i, persons.get(j));
                    persons.set(j,temp);
                }
            }
        }
    }

	public static void printLastNameWithCs(List<Person> persons) {
		for(Person person : persons) {
			if(person.getUpperLastName().startsWith("C")){
				System.out.println(person.getPerson());
			}
		}
	}

	public static void printPersonsUsingFunctionalInterface(List<Person> persons) {
		PrintNames printEachName = new PrintNames() {
			@Override
			public void PrintNamesMethod(List<Person> persons) {
				for(Person person : persons) {
					System.out.println(person.getPerson());
				}
			}
		};
		printEachName.PrintNamesMethod(persons);
	}

	public static void sortPersonsLastNameUsingFunctionalInterface(List<Person> persons) {
	    MySort toSort = new MySort() {
            @Override
            public void myInterfaceSort(List<Person> personsInMethodOverride) {
                for(int i = 0; i < personsInMethodOverride.size(); i++) {
                    for(int j = i+1; j < personsInMethodOverride.size(); j++) {
                        if (personsInMethodOverride.get(i).getUpperLastName().compareTo(personsInMethodOverride.get(j).getUpperLastName()) > 0) {
                            Person temp = personsInMethodOverride.get(i);
                            personsInMethodOverride.set(i, personsInMethodOverride.get(j));
                            personsInMethodOverride.set(j,temp);
                        }
                    }
                }
            }
        };
	    toSort.myInterfaceSort(persons);
	}

	public static void printLastNameWithCsUsingFunctionalInterface(List<Person> persons) {
		PrintNames printEachName = new PrintNames() {
			@Override
			public void PrintNamesMethod(List<Person> persons) {
				for(Person person : persons) {
					if(person.getUpperLastName().startsWith("C")){
						System.out.println(person.getPerson());
					}
				}
			}
		};
        printEachName.PrintNamesMethod(persons);
	}

}
