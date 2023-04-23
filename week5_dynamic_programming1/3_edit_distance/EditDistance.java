import java.util.*;

class EditDistance {
    public static int EditDistance(String s, String t) {
      int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= t.length(); j++) {
                if (i == 0) {
                    // If first string is empty, only option is to
                    // insert all characters of second string
                    dp[i][j] = j; // Min. operations = j
                } else if (j == 0) {
                    // If second string is empty, only option is to
                    // remove all characters of second string
                    dp[i][j] = i; // Min. operations = i
                } else if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // If last characters are same, ignore last char
                    // and recur for remaining string
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // If the last character is different, consider
                    // all possibilities and find the minimum
                    dp[i][j] = 1 + min(dp[i][j - 1], // Insert
                            dp[i - 1][j], // Remove
                            dp[i - 1][j - 1]); // Replace
                }
            }
        }

      return dp[s.length()][t.length()];
    }
    public static void main(String args[]) {
      Scanner scan = new Scanner(System.in);

      String s = scan.next();
      String t = scan.next();

      System.out.println(EditDistance(s, t));
    }

    public static int min(int x, int y, int z)
    {
          if (x <= y && x <= z) {
            return x;
          } else if (y <= x && y <= z) {
            return y;
          } else {
            return z;
          }
    }
}
