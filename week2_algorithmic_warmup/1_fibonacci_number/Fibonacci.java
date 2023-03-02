import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    if (n <= 1) {
      return n;
    }

    int num1 = 0;
    int num2 = 1;
    int tempNthTerm= 0;
    for (int i = 2; i <= n; i++) {
      tempNthTerm = num1 + num2;
      num1 = num2;
      num2 = tempNthTerm;
    }
    return tempNthTerm;
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    System.out.println(calc_fib(n));
  }
}
