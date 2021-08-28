import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        int[] numbers = new int[length];

        for (int i = 0; i < length; i++) {
            numbers[i] = scanner.nextInt();
        }

        int found = 0;

        for (int i = 2; i < length; i++) {
            if (numbers[i - 1] == (numbers[i - 2] + 1) && numbers[i] == (numbers[i - 2] + 2)) {
                found++;
            }
        }

        System.out.println(found);
    }
}