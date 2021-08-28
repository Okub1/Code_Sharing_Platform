import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int sum = 0;
        
        do {
            int input = scanner.nextInt();

            if (input == 0 ) {
                break;
            }

            if (input + sum >= 1000) {
                sum = sum + input - 1000;
                break;
            }

            sum += input;
            
        } while (true);

        System.out.println(sum);
    }
}