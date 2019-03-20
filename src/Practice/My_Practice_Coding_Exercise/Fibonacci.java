package Practice.My_Practice_Coding_Exercise;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 10;
        System.out.println("0" + " " + "1");
        fib(n-2);
    }

    private static void fib(int n) {
        if(n > 0) {
            int n1 = 0;
            int n2 = 1;
            int n3;
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            System.out.println(" " + n3);
            fib(n-1);
        }
    }
}
