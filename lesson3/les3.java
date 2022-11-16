package lesson3;

import java.util.Scanner;
import java.sql.*;


public class les3 {
    public static void main(String[] args) throws SQLException {
        String mysqlUtr = "jdbc:mysql://localhost/les_fin";
        Connection con = DriverManager.getConnection(mysqlUtr, "root", "1997");
        System.out.println("Успешное подключение!cle");

        Scanner scan = new Scanner(System.in);

        int x = 0;
        System.out.println("Введите название таблицы");
        String TableName = scan.nextLine();

        String a1 = "";
        String a2 = "";


        while (x != 4) {
            System.out.println("1-Вывести все таблицы");
            System.out.println("2-Cоздать таблицу");
            System.out.println("3-Сохранить результат в бд и результат сохранить в MySQL");
            System.out.println("4-Выход");

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
                    String query = "CREATE TABLE IF NOT EXISTS " + TableName + " (ID int, number_1 int, number_2 int, rst1 varchar(100), rst2 varchar(100))";
                    stmt2.executeUpdate(query);
                    ResultSet rs1 = stmt2.executeQuery("Show tables");
                    while (rs1.next()) {
                        System.out.println(rs1.getString(1));
                    }
                }
                case 3 -> {
                    System.out.println("Введите id");
                    int ids = scan.nextInt();
                    System.out.println("Введите первое число");
                    int s1 = scan.nextInt();
                    System.out.println("Введите второе число");
                    int s2 = scan.nextInt();
                    if (s1 % 2 == 0) {
                        a1 = "четное";
                    } else {
                        a1 = "нечетное";
                    }
                    if (s2 % 2 == 0) {
                        a2 = "четное";
                    } else {
                        a2 = "нечетное";
                    }
                    String query = "INSERT INTO " + TableName + " (ID, number_1, number_2, rst1, rst2) VALUES (?,?,?,?,?)";
                    PreparedStatement stmt3 = con.prepareStatement(query);
                    stmt3.setInt(1, ids);
                    stmt3.setInt(2, s1);
                    stmt3.setInt(3, s2);
                    stmt3.setString(4, a1);
                    stmt3.setString(5, a2);
                    stmt3.executeUpdate();
                    String strSelect = "SELECT ID, number_1, number_2, rst1, rst2 FROM " + TableName + " WHERE ID= ?";
                    PreparedStatement st = con.prepareStatement(strSelect);
                    st.setInt(1, ids);
                    ResultSet rs3 = st.executeQuery();
                    System.out.println("Введенные данные");
                    while (rs3.next()) {
                        System.out.println(rs3.getString("ID"));
                        System.out.println(rs3.getString("number_1"));
                        System.out.println(rs3.getString("number_2"));
                        System.out.println(rs3.getString("rst1"));
                        System.out.println(rs3.getString("rst2"));
                    }
                }
            }
        }
    }
}