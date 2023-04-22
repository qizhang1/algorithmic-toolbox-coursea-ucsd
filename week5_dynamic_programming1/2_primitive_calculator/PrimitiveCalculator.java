import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer>[] sequence = new LinkedList[n + 1];
        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = new LinkedList<>();
        }
        int[] dp = new int[n + 1];
        dp[1] = 0;
        sequence[1].add(1);
        for (int i = 2; i < dp.length; i++) {
            int n1 = dp[i - 1] + 1;
            int n2 = (i % 2 == 0 && i / 2 >= 0) ? dp[i / 2] + 1 : Integer.MAX_VALUE;
            int n3 = (i % 3 == 0 && i / 3 >= 0) ? dp[i / 3] + 1 :  Integer.MAX_VALUE;

            dp[i] = Math.min(Math.min(n1, n2), n3);
            if ( dp[i] == n3) {
                sequence[i].addAll(sequence[i / 3]);
                sequence[i].add(3);
            } else if (dp[i] == n2){
                sequence[i].addAll(sequence[i / 2]);
                sequence[i].add(2);
            } else {
                sequence[i].addAll(sequence[i - 1]);
                sequence[i].add(1);
            }

        }
        //System.out.println(sequence[i].toString());
        return sequence[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

