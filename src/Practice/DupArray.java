package Practice;

public class DupArray {

    public static void main(String[] args) {
        int[] myArray = {1,2,2,3,4,4,};
        printDups(myArray);
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

}
