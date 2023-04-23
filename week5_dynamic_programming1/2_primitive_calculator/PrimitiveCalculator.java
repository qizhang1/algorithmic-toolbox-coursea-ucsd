import java.util.*;

public class PrimitiveCalculator {

    public static class Entry {
        public int cost;
        public int prev;
        public int op;
        public Entry(int cost, int prev, int op) {
            this.cost = cost;
            this.prev = prev;
            this.op = op;
        }
    }
    public static List<Integer> optimal_sequence(int n) {
        Entry[] dp = new Entry[n]; // number value is i + 1, right shift by one
        dp[0] = new Entry(0, 0, 0);
        for (int i = 1; i < n; i++) {
            int cost1 = dp[i - 1].cost + 1;
            int cost2 = (i + 1) % 2 == 0 ? dp[(i + 1) / 2 - 1].cost + 1 : Integer.MAX_VALUE;
            int cost3 = (i + 1) % 3 == 0 ? dp[(i + 1) / 3 - 1].cost + 1 : Integer.MAX_VALUE;

            int minCost = Math.min(Math.min(cost1, cost2), cost3);
            if (minCost == cost1) {
                dp[i] = new Entry(cost1, i - 1, 1 );
            } else if (minCost == cost2) {
                dp[i] = new Entry(cost2, (i + 1) / 2 - 1, 2 );
            } else {
                dp[i] = new Entry(cost3, (i + 1) / 3 - 1, 3 );
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        int index = n - 1;
        while (index != 0) {
            result.add(dp[index].op);
            index = dp[index].prev;
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size());
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

