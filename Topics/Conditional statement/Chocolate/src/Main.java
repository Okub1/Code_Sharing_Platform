import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        int width = scanner.nextInt();
        int desired = scanner.nextInt();

        boolean possible = false;

        for (int i = 0; i < length; i++) {
            if (length * width - i * width == desired) {
                possible = true;
                break;
            }
        }

        for (int i = 0; i < width; i++) {
            if (length * width - i * length == desired) {
                possible = true;
                break;
            }
        }

        if (possible) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}