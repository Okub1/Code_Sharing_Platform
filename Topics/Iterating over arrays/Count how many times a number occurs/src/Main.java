import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();

        int[] numbers = new int[length];

        for (int i = 0; i < length; i++) {
            numbers[i] = scanner.nextInt();
        }

        int input = scanner.nextInt();
        int counter = 0;

        for (int item : numbers) {
            if (item == input) {
                counter++;
            }
        }

        System.out.println(counter);
    }
}