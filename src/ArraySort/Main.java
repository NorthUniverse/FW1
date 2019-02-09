package ArraySort;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the number of element(s) in the array: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        int[] array = getIntegers(count);
        printArray(array);
        sortArray(array);
        System.out.println("Sorted array is: ");
        printArray(array);

    }

    public static int[] getIntegers(int count) {
        int[] array = new int[count];
        for(int i = 0; i < array.length; i++) {
            System.out.println("Enter the number: ");
            array[i] = scanner.nextInt();
            scanner.nextLine();
        }
        return array;
    }

    public static void printArray(int[] passedArray) {
        for(int i = 0; i < passedArray.length; i++) {
            System.out.println(passedArray[i]);
        }
    }

    public static void sortArray(int[] passedArray) {
        boolean flag = true;

        while(flag){
            flag = false;
            for(int i = 0; i < passedArray.length-1; i++) {
                if(passedArray[i] < passedArray[i+1]) {
                    int temp = passedArray[i];
                    passedArray[i] = passedArray[i+1];
                    passedArray[i+1] = temp;
                    flag = true;
                }
            }
        }

    }


}
