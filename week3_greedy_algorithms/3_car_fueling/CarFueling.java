import java.util.*;
public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int curDist = tank; // car starts with a full tank.
        int count = 0;
        for (int i = 0; i < stops.length && curDist < dist; i++) {
            if (stops[i] <= curDist && (i + 1 == stops.length || stops[i + 1] > curDist)) {
                count++;
                curDist = stops[i] + tank;
            }
        }
        return curDist >= dist ? count : -1;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
