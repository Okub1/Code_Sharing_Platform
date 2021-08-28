import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        for (int i = a; i <= b; i++) {

            if (i % 3 != 0 && i % 5 != 0) {
                System.out.print(i);
            }

            if (i % 3 == 0) {
                System.out.print("Fizz");
            }

            if (i % 5 == 0) {
                System.out.print("Buzz");
            }

            System.out.println();
        }
    }
}