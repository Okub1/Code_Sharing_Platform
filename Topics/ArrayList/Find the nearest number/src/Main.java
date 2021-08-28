import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        String[] ints = scanner.nextLine().split(" ");

        int n = scanner.nextInt();

        for (String item : ints) {
            arrayList.add(Integer.parseInt(item));
        }

        int min = Integer.MAX_VALUE;

        for (Integer item : arrayList) {
            int distance = Math.abs(item - n);
            if (distance < min) {
                min = distance;
            }
        }

        ArrayList<Integer> temp = new ArrayList<>();

        for (Integer item : arrayList) {
            if (Math.abs(item - n) == min) {
                temp.add(item);
            }
        }

        Collections.sort(temp);

        for (Integer item : temp) {
            System.out.print(item + " ");
        }
    }
}