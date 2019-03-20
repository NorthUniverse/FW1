package Practice.My_Practice_Coding_Exercise;

public class Fibonacci {
    public static void main(String[] args) {

        int n = 10;
        System.out.println("Fibonacci number upto " + n + " using recursion: ");
        System.out.println(fibonacci(n));

        System.out.println("Fibonacci series upto " + n +" numbers : ");
        for(int i=1; i<=n; i++) {
            System.out.print(fibonacci2(i) +" ");
        }
    }

    private static int fibonacci(int n) {
        if(n == 1 || n == 2){
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n -2);
    }

    private static int fibonacci2(int n) {
        if(n == 1 || n == 2){
            return 1;
        }
        int fibo1=1, fibo2=1, fibonacci=1;
        for(int i= 3; i<= n; i++){
            fibonacci = fibo1 + fibo2;
            fibo1 = fibo2;
            fibo2 = fibonacci;
        }
        return fibonacci;
    }
}
