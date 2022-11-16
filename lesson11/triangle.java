package lesson11;
import java.util.Scanner;


public class triangle {

    public static int site1 = 0;
    public static int site2 = 0;
    public static int site3 = 0;

    public static int[] inputt(){
        Scanner scan = new Scanner(System.in);
        site1 = scan.nextInt();
        site2 = scan.nextInt();
        site3 = scan.nextInt();

        int perimetr = site1 + site2 + site3;
        int s = (int)Math.sqrt(perimetr*(perimetr - site1)*(perimetr - site2)*(perimetr - site3));
        System.out.println("Периметр: " + perimetr);
        System.out.println("Площадь: " + s);


        return new int[]{site1, site2, site3};
    }
}

