import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        LocalDate start = LocalDate.of(scanner.nextInt(), scanner.nextInt(), 1);
        LocalDate end = LocalDate.of(start.getYear(), start.getMonth(), start.lengthOfMonth());
        System.out.println(start + " " + end);
    }
}