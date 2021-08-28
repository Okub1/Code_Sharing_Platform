import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ascending = 0;
        int descending = 0;

        int prev = -1;
        int input;

        do {
            input = scanner.nextInt();

            if (input == 0) {
                break;
            }

            if (prev != -1) {
                if (prev > input) {
                    descending++;
                } else if (prev < input) {
                    ascending++;
                }
            }

            prev = input;
        } while (true);

        if (ascending == 0 || descending == 0) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}