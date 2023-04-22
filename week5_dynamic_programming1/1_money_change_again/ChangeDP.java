import java.util.Arrays;
import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        int[] coins = new int[]{1, 3, 4};
        int[] dp = new int[m + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int n : coins) {
                if (i - n >= 0 && dp[i - n] != -1) {
                    if (dp[i] == -1 || dp[i - n] + 1 < dp[i]) {
                        dp[i] = dp[i - n] + 1;
                    }
                }
            }
        }
        return dp[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

