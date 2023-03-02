import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int num1 = 0;
        int num2  = 1;
        int tempNthTerm = 0;

        for (int i = 0; i < n - 1; ++i) {
            tempNthTerm = num1 % 10 + num2 % 10;
            num1 = num2 % 10;
            num2 = tempNthTerm % 10;
        }

        return tempNthTerm % 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}

