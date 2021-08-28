import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] box1 = new int[3];
        box1[0] = scanner.nextInt();
        box1[1] = scanner.nextInt();
        box1[2] = scanner.nextInt();

        int[] box2 = new int[3];
        box2[0] = scanner.nextInt();
        box2[1] = scanner.nextInt();
        box2[2] = scanner.nextInt();

        Arrays.sort(box1);
        Arrays.sort(box2);

        int first = 0;
        int second = 0;

        for (int i = 0; i < 3; i++) {
            if (box1[i] > box2[i]) {
                first++;
            } else if (box1[i] < box2[i]) {
                second++;
            }
        }

        if (first == 3) {
            System.out.println("Box 1 > Box 2");
        } else if (second == 3) {
            System.out.println("Box 1 < Box 2");
        } else {
            System.out.println("Incompatible");
        }

    }
}