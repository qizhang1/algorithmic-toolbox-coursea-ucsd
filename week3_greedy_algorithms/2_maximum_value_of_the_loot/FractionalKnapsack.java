import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        // unit value in decrease order
        for (int i = 0; i < values.length && capacity > 0; i++) {
            int bestItemIndex = getBestItem(values, weights);
            if (bestItemIndex != -1) {
                int bestItemWeight = Math.min(capacity, weights[bestItemIndex]);
                value += bestItemWeight * (values[bestItemIndex] * 1.0) / weights[bestItemIndex];
                weights[bestItemIndex] -= bestItemWeight;
                capacity = capacity - bestItemWeight;
            }
        }
        return value;
    }

    private static int getBestItem(int[] values, int[] weights) {
        double bestValue = 0;
        int bestItemIndex = -1;
        for (int i = 0; i < values.length; i++) {
            if (weights[i] > 0 && ( values[i] * 1.0) / weights [i] > bestValue) {
                bestValue = ( values[i] * 1.0) / weights [i];
                bestItemIndex = i;
            }
        }
        return bestItemIndex;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
