package Practice;

public class ArrayDups {
    public static void main(String[] args) {
        int[] array = {0, 1, 1, 2, 3, 4, 4, 4, 5, 5, 6, 7, 8, 9, 9};
        printdups(array);
//        duplicates(array);

    }

    private static void printdups(int[] array) {
        int[] duparray = {};
        for(int i = 0; i < array.length; i++) {
            for(int j = i+1; j < array.length; j++) {
                if((array[i] == array[j]) && (i!=j)) {
                    System.out.print(array[i]);
                }
            }
        }
    }
//
//    private static void duplicates(final int[] passedArray)
//    {
//        Set<Integer> dump = new HashSet<Integer>();
//        for (int i : passedArray)
//        {
//            if (dump.contains(i)) {
//                dump.add(i);
//            }
//        }
//        for (int i : dump)
//        {
//            System.out.println(dump.get(i));
//        }
//    }
}
