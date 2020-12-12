import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        double S = fractionSum(n);
        System.out.println(S);
        ArrayList<Integer> num = dividers(n);
        System.out.println(num);

        int fact = 1;
        int sqr = 1;
        for (int i = 1; i <= n; ++i) {
            fact *= i;
            sqr *= 2;
        }
        System.out.println(fact + "\n" + sqr + "\n" + fact(n));

        int x = input.nextInt();
        int task4 = maxDigit(x);
        System.out.println(task4);

        int k = input.nextInt();
        int task5 = sum(k);
        System.out.println(task5);



    }

    public static int task6(int x, int n) {
        int res = 0;
        for (int k = 3; k <= n; ++k) {
            if (k - 5 == 0)
                continue;
            int mult = 1;
            for (int i = 1; i <= k + 7; ++i) {
                if (i - 7 == 0)
                    continue;
                mult *= (Math.pow(i, 3) - 27) / (i - 7);
            }
            res += Math.pow(-2, k - 1) * mult / ((k - 5) * Math.pow(x, k));
        }
        return res;
    }

    public static int sum(int k) {
        int res = 0;
        for (int i = -2; i <= k; ++i) {
            if (i - 4 == 0)
                continue;
            res += Math.pow(-1, i) * fact(i + 3) / (2 * (i - 4));
        }
        return res;
    }

    public static int fact(int a) {
        return a == 1 ? 1 : a * fact( a - 1);
    }

    public static int maxDigit(int n) {
        int m = 0;
        while (n > 0) {
            if (n % 10 > m)
                m = n % 10;
            n /= 10;
        }
        return m;
    }

    public static double fractionSum(int n) {
        double result = 0;
        for (int i = 1; i <= n; ++i) {
            result += (double) 1 / i;
        }
        return result;
    }


    public static ArrayList<Integer> dividers(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(n);
        for (int i = n / 2; i > 0; --i) {
            if (n % i == 0)
                res.add(i);
        }
        return res;
    }


}
