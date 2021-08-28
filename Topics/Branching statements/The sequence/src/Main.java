import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();
        int temp = 1;

        while (input > 0) {

            for (int i = 0; i < temp && input > 0; i++) {
                System.out.print(temp + " ");
                input--;
            }

            temp++;
        }
    }
}