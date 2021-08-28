import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        int[] ints = new int[size];
        for (int i = 0; i < size; i++) {
            ints[i] = scanner.nextInt();
        }

        int max = 0;

        for (int i = 0; i < size - 1; i++) {
            int temp = ints[i] * ints[i + 1];
            if (temp > max) {
                max = temp;
            }
        }

        System.out.println(max);
    }
}