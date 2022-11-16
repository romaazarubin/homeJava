package lesson4;
import java.util.Scanner;


public class les {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите первую строку, длинна не менее 50");
        String a = scan.nextLine();
        if (a.length() < 50){
            System.out.println("Длина меньше чем 50 повторите ввод");
            a = scan.nextLine();
        }
        System.out.println("Введи вторую строку, длинна не менее 50");
        String b = scan.nextLine();
        if (b.length() < 50){
           System.out.println("Длина меньше чем 50 повторите ввод");
           b = scan.nextLine();
        }
        System.out.println(a);
        System.out.println(a.toLowerCase());
        System.out.println(b);
        System.out.println((b.toUpperCase()));
        System.out.println("Введите строчку на которую может заканчиваться");
        String u = scan.nextLine();
        System.out.println(a.endsWith(u));
        System.out.println(b.endsWith(u));
        System.out.println("Введите первую границу");
        int x = scan.nextInt();
        System.out.println("Введите вторую границу");
        int y = scan.nextInt();
        System.out.println(a.substring(x,y));
        System.out.println(b.substring(x,y));
        System.out.println("Введите первую границу");
        int x1 = scan.nextInt();
        System.out.println("Введите вторую границу");
        int y1 = scan.nextInt();
        System.out.println(a.toLowerCase().substring(x1,y1));
        System.out.println(b.toUpperCase().substring(x1,y1));
    }
}
