package Practice.My_Practice_Coding_Exercise;

public class StairsProblem {
    public static void main(String[] args) {

        int n = 5;
        System.out.println("Number of ways = "+ countNoOFWays(n));
    }

    public static int countNoOFWays(int n)
    {
        return fibonacci(n + 1);
    }

    public static int fibonacci(int n)
    {
        if (n <= 1)
            return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
