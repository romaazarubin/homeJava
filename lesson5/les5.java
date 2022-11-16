package lesson5;
import java.sql.*;
import java.util.Scanner;


public class les5 {
    public static void main(String[] args) throws SQLException {
        String mysqlUtr = "jdbc:mysql://localhost/les_fin";
        Connection con = DriverManager.getConnection(mysqlUtr, "root", "1997");
        System.out.println("Успешное подключение");

        Scanner scan = new Scanner(System.in);

        int x = 0;
        System.out.println("Введите название таблицы");
        String TableName = scan.nextLine();

        String a1 = "";
        String a2 = "";


        while (x != 5) {
            System.out.println("1-Вывести все таблицы");
            System.out.println("2-Cоздать таблицу");
            System.out.println("3-Сохранить результат в бд и результат сохранить в MySQL");
            System.out.println("4-Обьеденить и ");
            System.out.println("5-Выход результат в бд и результат сохранить в MySQL");


            try {
                x = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Невереный формат ввода");
                break;
            }
            switch (x) {
                case 1 -> {
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("Show tables");
                    System.out.println("Таблицы из текущей бд: ");
                    while (rs.next()) {
                        System.out.println(rs.getString(1));
                    }
                }
                case 2 -> {
                    Statement stmt2 = con.createStatement();
                    String query = "CREATE TABLE IF NOT EXISTS " + TableName + " (ID int, str1 varchar(100), str2 varchar(100), rts1 varchar(100), rts2 varchar(100), str varchar(200))";
                    stmt2.executeUpdate(query);
                    ResultSet rs1 = stmt2.executeQuery("Show tables");
                    while (rs1.next()) {
                        System.out.println(rs1.getString(1));
                    }
                }





        /*String a = scan.nextLine();
        String b = scan.nextLine();
        if (a.length() >= 50 & b.length() >=50){
            StringBuffer ab = new StringBuffer(a);
            StringBuffer bb = new StringBuffer(b);
            System.out.println(a);
            System.out.println(b);
            System.out.println(ab.reverse());
            System.out.println(bb.reverse());
            System.out.println(ab.append(bb));
        }else{
            System.out.println("Ваша строка меньше 50 символов");
        }*/
            }
        }
    }
}

