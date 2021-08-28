import java.util.Scanner;

public class Main {

    public static long factorial(long n) {
        long result = n;

        for (long i = n; i > 1; i--) {
            result *= (i - 1);
        }

        return result == 0 ? 1 : result;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = Integer.parseInt(scanner.nextLine().trim());
        System.out.println(factorial(n));
    }
}