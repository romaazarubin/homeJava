package lesson7;

import java.util.Scanner;

public class ArrayPI21 {
    int n = 10;
    int[] arr = new int[n];
    public void inarr() {
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < n; i++) {
            System.out.println("Вводите число в массив");
            arr[i] = scan.nextInt();
        }
    }
}

