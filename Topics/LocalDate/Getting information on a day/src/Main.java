import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here

        Scanner scanner = new Scanner(System.in);

        LocalDate date = LocalDate.parse(scanner.nextLine());
        System.out.print(date.getDayOfYear()+ " ");
        System.out.println(date.getDayOfMonth());
    }
}