package lesson6;

import java.util.Scanner;


public class ArrayPI {
    int[][] arr1 = new int[2][2];
    int[][] arr2 = new int[2][2];
    public void inarr() {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("Введите элемент массива 1:");
                arr1[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("Введите элемент массива 2:");
                arr2[i][j] = in.nextInt();
            }
        }
    }
}
