package ArrayMinElement;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the number of element(s) in the array: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        int[] array = getIntegers(count);
        System.out.println("Entered array is: ");
        printArray(array);
        System.out.println("Minium element in array is: " + findMin(array));

    }

    public static int[] getIntegers(int count) {
        int[] array = new int[count];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter integer for array[" + i + "]: ");
            array[i] = scanner.nextInt();
            scanner.nextLine();
        }
        return array;
    }

    public static void printArray(int[] passedArray) {
        for (int i = 0; i < passedArray.length; i++) {
            System.out.println(passedArray[i]);
        }
    }

    public static int findMin(int[] passedArray) {
        int minElement = Integer.MAX_VALUE;
        for (int i = 0; i < passedArray.length; i++) {
            if (minElement > passedArray[i]) {
                minElement = passedArray[i];
            }
        }

        return minElement;
    }

}

