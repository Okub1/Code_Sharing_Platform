import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String shape = scanner.next();

        double area = 0.0;

        switch (shape) {
            case "triangle":
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                double c = scanner.nextDouble();

                double temp = (a + b + c) / 2.0;

                // Heron's formula
                area = Math.sqrt(temp * (temp - a) * (temp - b) * (temp - c));

                break;
            case "rectangle":

                a = scanner.nextDouble();
                b = scanner.nextDouble();

                area = a * b;

                break;
            case "circle":

                double r = scanner.nextDouble();

                area = 3.14 * r * r;

                break;
        }

        System.out.println(area);
    }
}