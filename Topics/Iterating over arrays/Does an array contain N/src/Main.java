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
        boolean found = false;

        for (int item : numbers) {
            if (item == input) {
                found = true;
                break;
            }
        }

        System.out.println(found);
    }
}