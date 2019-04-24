package SecretSanta;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GameMethods {

	public static void enterData(List<Person> personsPlaying) {
//        System.out.println("How many persons are playing this game? ");
//        Scanner peepsPlaying = new Scanner(System.in);
//        int noOfPeepsPlaying = peepsPlaying.nextInt();
//        if (noOfPeepsPlaying < 3) {
//            System.out.println("Atleast 3 person must play this Secret Santa game, returning to main menu");
//            return;
//        }
//        for (int i = 0; i < noOfPeepsPlaying; i++) {
//            if(i == 0) {
//                System.out.println("Enter your name: ");
//            }
//            System.out.println("Enter name for person " + (i));
//            Scanner personNameScanner = new Scanner(System.in);
//            String personName = personNameScanner.nextLine();
//            personsPlaying.add(new Person(personName));
//        }

		Person Dennis = new Person("Dennis");
		Person Oishi = new Person("Oishi");
		Person Rahul = new Person("Rahul");
		Person Sharon = new Person("Sharon");
		Person Rita = new Person("Rita");
		Person James = new Person("James");
		Person Russel = new Person("Russel");
		Person Nancy = new Person("Nancy");
		Person John = new Person("John");

		personsPlaying.add(Dennis);
		personsPlaying.add(Oishi);
		personsPlaying.add(Rahul);
		personsPlaying.add(Sharon);
		personsPlaying.add(Rita);
		personsPlaying.add(James);
		personsPlaying.add(Russel);
		personsPlaying.add(Nancy);
		personsPlaying.add(John);

		Dennis.setExclusions("Oishi");
		Dennis.setExclusions("Sharon");
		Oishi.setExclusions("Dennis");
		Oishi.setExclusions("Rita");
		Sharon.setExclusions("Dennis");
		Rita.setExclusions("Oishi");


	}

	public static void addPerson(List<Person> personsPlaying) {
		System.out.println("");
		System.out.println("Enter the name of person to add");
		Scanner addPersonScanner = new Scanner(System.in);
		String addPerson = addPersonScanner.nextLine();

		for (Person eachPerson : personsPlaying) {
			if (eachPerson.getName().equalsIgnoreCase(addPerson)) {
				System.out.println(addPerson + " is already on the list, hence cannot add");
				return;
			}
		}
		personsPlaying.add(new Person(addPerson));
	}

	public static void removePerson(List<Person> personsPlaying) {
		System.out.println("\nEnter the name of person to remove");
		Scanner removePersonScanner = new Scanner(System.in);
		String removePerson = removePersonScanner.nextLine();
		boolean personFlag = false;
		for (Person eachPerson : personsPlaying) {
			if (eachPerson.getName().equalsIgnoreCase(removePerson)) {
				personsPlaying.remove(eachPerson);
				personFlag = true;
				return;
			}
		}
		if (!personFlag) {
			System.out.println(removePerson + " is not on the list, hence cannot remove ");
		}
	}

	public static void printPersons(List<Person> personsPlaying) {
		if (personsPlaying.isEmpty()) {
			System.out.println("\nThe list is empty");
			return;
		}
		System.out.println("\nPerson List:");
		for (Person eachPerson : personsPlaying) {
			System.out.println(eachPerson.getName());
		}
	}

	public static void playSecretSanta(List<Person> personsPlaying) {

		System.out.println("\nStarting game: \n");

		shuffleAndAssignSecretSanta(personsPlaying);

		boolean shuffleFlag = false;
		boolean loopExitFlag = false;
		while (!loopExitFlag) {
			int count = 1;
			int count1 = 1;
			int count2 = 1;
			for (Person eachPerson : personsPlaying) {
				List<String> pastSecretSantaList = eachPerson.getSecrectSantaFor();
				Collections.reverse(pastSecretSantaList);
				if ((eachPerson.getName().equalsIgnoreCase(pastSecretSantaList.get(0))) // Person is secret santa for himself/herself
						|| (eachPerson.getExclusions().contains(pastSecretSantaList.get(0)))  // Checking exclusions (Secret Santa part 3)
						) {
					shuffleFlag = true;
				} else {
					loopExitFlag = true;
					count++;
					// Secret Santa Part 2: same person can be secret santa only after 3 years
					if (pastSecretSantaList.size() == 2) {
						loopExitFlag = false;
						if (pastSecretSantaList.get(0).equalsIgnoreCase(pastSecretSantaList.get(1))) {
							shuffleFlag = true;
						} else {
							loopExitFlag = true;
							count1++;
						}
					}
					if (pastSecretSantaList.size() > 2) {
						loopExitFlag = false;
						if ((pastSecretSantaList.get(0).equalsIgnoreCase(pastSecretSantaList.get(1))) || ((pastSecretSantaList.get(0).equalsIgnoreCase(pastSecretSantaList.get(2))))) {
							shuffleFlag = true;
						} else {
							loopExitFlag = true;
							count2++;
						}
					}
				}
				Collections.reverse(pastSecretSantaList);
			}
			if (shuffleFlag) {
				for (Person eachPerson : personsPlaying) {
					List<String> secretSantaList = eachPerson.getSecrectSantaFor();
					Collections.reverse(secretSantaList);
					secretSantaList.remove(0);
					Collections.reverse(secretSantaList);
				}
				shuffleAndAssignSecretSanta(personsPlaying);
				shuffleFlag = false;
				loopExitFlag = false;
			}

			// Condition to exit loop
			if (loopExitFlag && (count == personsPlaying.size())) {
				int pastSecretSantaListSize = 0;
				for (Person eachPerson : personsPlaying) {
					pastSecretSantaListSize = eachPerson.getSecrectSantaFor().size();
				}
				if (pastSecretSantaListSize == 2) {
					if (loopExitFlag && (count1 == personsPlaying.size())) {
						break;
					}
				}
				if (pastSecretSantaListSize > 2) {
					if (loopExitFlag && (count2 == personsPlaying.size())) {
						break;
					}
				}
				break;
			}
		}

		System.out.println("You have to buy gift for " + personsPlaying.get(0).getSecrectSantaFor().get(personsPlaying.get(0).getSecrectSantaFor().size() - 1) + "\n");
		System.out.println("See all Secret Santa game results(Y/N)? ");
		Scanner viewAllConditionScanner = new Scanner(System.in);
		String viewAllCondition = viewAllConditionScanner.nextLine();
		if (viewAllCondition.equalsIgnoreCase("Y")) {
			for (Person eachPerson : personsPlaying) {
				System.out.println(eachPerson.getName() + " is the secret santa of " + eachPerson.getSecrectSantaFor().get(eachPerson.getSecrectSantaFor().size() - 1));
			}
		}
	}

	public static void shuffleAndAssignSecretSanta(List<Person> personsPlaying) {
		LinkedList<Person> copyOfPersonsPlaying = new LinkedList<Person>();
		copyOfPersonsPlaying.addAll(personsPlaying);
		Collections.shuffle(copyOfPersonsPlaying);
		for (int i = 0; i < personsPlaying.size(); i++) {
			personsPlaying.get(i).setSecrectSantaFor(copyOfPersonsPlaying.get(i).getName());
		}
	}


	//Part of Secret Santa Part 3 section
	public static void setExclusions(List<Person> personsPlaying) {
		for (Person eachPerson : personsPlaying) {
			boolean quitExclusions = false;
			LinkedList<Person> copyOfPersonsPlaying = new LinkedList<Person>();
			copyOfPersonsPlaying.addAll(personsPlaying);
			for (int i = 0; i < copyOfPersonsPlaying.size(); i++) {
				if (eachPerson.getName().equalsIgnoreCase(copyOfPersonsPlaying.get(i).getName())) {
					copyOfPersonsPlaying.remove(i);
				}
			}
			System.out.println("Exclusions options for " + eachPerson.getName());
			while (!quitExclusions) {
				System.out.println("0. Quit Exclusions for " + eachPerson.getName());
				for (int i = 0; i < copyOfPersonsPlaying.size(); i++) {
					System.out.println((i + 1) + ". " + copyOfPersonsPlaying.get(i).getName());
				}
				System.out.println("Enter Option: ");
				Scanner exclusionOptionScanner = new Scanner(System.in);
				int exclusionOption = exclusionOptionScanner.nextInt();
				if (exclusionOption == 0) {
					quitExclusions = true;
					break;
				}
				eachPerson.setExclusions(copyOfPersonsPlaying.get(exclusionOption - 1).getName());
				System.out.println(copyOfPersonsPlaying.get(exclusionOption - 1).getName() + " has been added as exclusion for " + eachPerson.getName());
				copyOfPersonsPlaying.remove(exclusionOption - 1);
			}
		}
	}
}
