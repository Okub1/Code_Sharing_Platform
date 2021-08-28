import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int busHeight = scanner.nextInt();
        int numberOfBridges = scanner.nextInt();

        int crashes = 0;
        boolean crashed = false;
        int crashedBridge = -1;
        int i = 1;

        while (scanner.hasNext()) {
            int bridgeHeight = scanner.nextInt();

            if (bridgeHeight <= busHeight) {
                crashes++;

                if (!crashed) {
                    crashedBridge = i;
                    crashed = true;
                }
            }

            i++;
        }

        if (crashes > 0) {
            System.out.println("Will crash on bridge " + crashedBridge);
        } else {
            System.out.println("Will not crash");
        }
    }
}