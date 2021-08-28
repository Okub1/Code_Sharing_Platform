import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        int[] numbers = new int[length];

        for (int i = 0; i < length; i++) {
            numbers[i] = scanner.nextInt();
        }

        int first = scanner.nextInt();
        int second = scanner.nextInt();
        boolean found = true;

        for (int i = 1; i < length; i++) {
            if (numbers[i - 1] == first && numbers[i] == second
                || numbers[i - 1] == second && numbers[i] == first) {
                found = false;
                break;
            }
        }

        System.out.println(found);
    }
}