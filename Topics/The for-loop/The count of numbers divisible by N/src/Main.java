import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        System.out.println("" + (new Scanner(System.in).nextInt() - new Scanner(System.in).nextInt() + n) / n);
    }
}