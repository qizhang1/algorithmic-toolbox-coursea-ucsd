import java.util.*;

// Knapsack without repetitions max{ value(w - wi, i - 1) + vi, value(w, i - 1}
public class Knapsack {
    static int optimalWeight(int capacity, int[] weights) {
    	
    	int numBars = weights.length;
        int[][] value = new int[weights.length + 1][capacity + 1];

        for (int i = 1; i <= numBars; i++) {
            for (int j = 1; j <= capacity; j++) {
                value[i][j] = value[i - 1][j];
                if (weights[i - 1] <= j) {
                    int altValue = value[i - 1][j - weights[i - 1]] + weights[i - 1];
                    if (altValue > value[i][j]) {
                        value[i][j] = altValue;
                    }
                }
            }
        }
        return value[numBars][capacity];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt(); // capacity of the backpack
        n = scanner.nextInt(); // the number n of gold bars
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

