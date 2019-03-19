package Practice.My_Practice_Coding_Exercise;

import java.util.HashMap;
import java.util.Map;

public class DupArray {

    public static void main(String[] args) {
        int[] myArray = {4,4,4};
		printDupsWithOccurance(myArray);
    }

    public static void printDups(int[] passedArray) {
        for(int i = 0; i < passedArray.length; i++) {
            for(int j = i+1; j < passedArray.length; j++) {
                if(passedArray[i] == passedArray[j]) {
                    System.out.print(passedArray[i] + " ");
                }
            }
        }
    }
    public static void printDupsWithOccurance(int[] passedArray) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < passedArray.length; i++) {
			int noOfOccurance = 1;
            for(int j = i+1; j < passedArray.length; j++) {
                if(passedArray[i] == passedArray[j]) {
                    noOfOccurance++;
                    if(map.containsKey(passedArray[j])) {
                    	noOfOccurance++;
					}
                    else {
						map.put(passedArray[i], noOfOccurance);
					}
                }
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println("Element " + entry.getKey() + " with no. of occurance " + entry.getValue());
		}
    }


}
