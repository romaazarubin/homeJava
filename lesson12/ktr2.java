package lesson12;
import java.util.Scanner;


public class ktr2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("введите число: ");
        int n = scan.nextInt();
        System.out.println("четный факториал: ");
        System.out.println(factorial(n));
        System.out.println("нечетный факториал: ");
        System.out.println(nfactorial(n));
    }

    public static int factorial(int n) {
        int result = 1;

        for(int f = 1; f <= n; ++f) {
            if (f % 2 == 0) {
                result *= f;
            }
        }

        return result;
    }

    public static int nfactorial(int n) {
        int result = 1;

        for(int f = 1; f <= n; ++f) {
            if (f % 2 != 0) {
                result *= f;
            }
        }

        return result;
    }
}
