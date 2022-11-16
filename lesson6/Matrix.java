package lesson6;

import java.util.Scanner;

public class Matrix extends ArrayPI {
    //System.out.print("ввод");
    int[][] arr3 = new int[7][7];

    public void umnoz() {
        int a = arr1.length;
        int b = arr2[0].length;
        int c = arr2.length;
        arr3 = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                for (int k = 0; k < c; k++) {
                    this.arr3[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        for (int i = 0; i < arr3.length; i++) {
            for (int j = 0; j < arr3[i].length; j++) {
                System.out.print(arr3[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        /*Scanner scan = new Scanner(System.in);
        System.out.print("ввод");
        int i = scan.nextInt();
        int j = scan.nextInt();
        int[][] arr1 = new int[i][j];
        int[][] arr2 = new int[i][j];*/
        Matrix arr = new Matrix();
        arr.inarr();
        arr.umnoz();
    }
}
