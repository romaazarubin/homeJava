package lesson11;

public class check extends triangle {
    public static int[] arr = inputt();
    public static int site1 = arr[0];
    public static int site2 = arr[1];
    public static int site3 = arr[2];
    public static void test() {

        int m = 0;
        if (site1 > m){
            m = site1;
        }
        if (site2 > m){
            m = site1;
        }
        if (site3 > m){
            m = site1;
        }
        if ((m == site1) && (m*m == site2*site2 + site3*site3)) {
            System.out.print("Треугольник прямоугольный");
        }
        else {
            if ((m == site2) && (m*m == site1*site1 + site3*site3)) {
                System.out.print("Треугольник прямоугольный");
            }
            else {
                if ((m == site3) && (m*m == site1*site1 + site2*site2)) {
                    System.out.print("Треугольник прямоугольный");
                }
                else {
                    System.out.print("Треугольник не прямоугольный");
                }
            }
        }
    }

    public static void main(String[] args) {
        test();
    }
}
