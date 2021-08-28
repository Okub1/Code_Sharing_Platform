import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();

        int hundreds = input / 100;
        int tens = (input % 100) / 10;
        int ones = input % 10;

        if (ones != 0) {
            System.out.println("" + ones + tens + hundreds);
        } else {
            System.out.println("" + tens + hundreds);
        }
    }
}
