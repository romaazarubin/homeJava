import java.util.Scanner;

import java.sql.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws SQLException {
        String mysqlUtr = "jdbc:mysql://localhost/les_fin";
        Connection con = DriverManager.getConnection(mysqlUtr, "root", "1997");
        System.out.println("Успешное подключение");

        Scanner scan = new Scanner(System.in);
        int x = 0;
        String s = "";
        System.out.println("Введите название таблицы");
        String TableName = scan.nextLine();

        while (!"7".equals(s)) {
            System.out.println("1-Вывести все таблицы");
            System.out.println("2-Cоздать таблицу");
            System.out.println("3-Ввести две строки с клавиатуры и результат сохранить в MySQL");
            System.out.println("4-Подсчитать размер");
            System.out.println("5-Обьединить строки");
            System.out.println("6-Сравнить строки");
            System.out.println("7-Выход из программы");
            System.out.println("Выберите действие");
            s = scan.nextLine();


            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Невереный формат ввода");
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
                    String query = "CREATE TABLE IF NOT EXISTS " + TableName + " (ID int, lenght_1 int, lenght_2 int, str_1 varchar(100), str_2 varchar(100), str varchar(200), bool boolean)";
                    stmt2.executeUpdate(query);
                    ResultSet rs1 = stmt2.executeQuery("Show tables");
                    while (rs1.next()) {
                        System.out.println(rs1.getString(1));
                    }
                }
                case 3 -> {
                    System.out.println("Введите id");
                    int ids = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Введите первую строчку");
                    String s1 = scan.nextLine();
                    System.out.println("Введите вторую строчку");
                    String s2 = scan.nextLine();
                    String query = "INSERT INTO " + TableName + " (str_1, str_2, ID) VALUES (?, ? ,?)";
                    PreparedStatement stmt3 = con.prepareStatement(query);
                    stmt3.setString(1, s1);
                    stmt3.setString(2, s2);
                    stmt3.setInt(3, ids);
                    stmt3.executeUpdate();
                    String strSelect = "SELECT ID,str_1, str_2 FROM " + TableName + " WHERE ID= ?";
                    PreparedStatement st = con.prepareStatement(strSelect);
                    st.setInt(1,ids);
                    ResultSet rs3 = st.executeQuery();
                    System.out.println("Введенные данные");
                    while (rs3.next()) {
                        System.out.println(rs3.getString("ID"));
                        System.out.println(rs3.getString("str_1"));
                        System.out.println(rs3.getString("str_2"));
                    }
                }
                case 4 -> {
                    System.out.println("Введите id");
                    int ids = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Введите первую строку");
                    String str1 = scan.nextLine();
                    System.out.println("Введите вторую строку");
                    String str2 = scan.nextLine();
                    String query = "INSERT INTO " + TableName + " (str_1, str_2,lenght_1, lenght_2, ID) VALUES (?,?,?,?,?)";
                    PreparedStatement stmt4 = con.prepareStatement(query);
                    stmt4.setString(1, str1);
                    stmt4.setString(2, str2);
                    stmt4.setInt(3,str1.length());
                    stmt4.setInt(4,str2.length());
                    stmt4.setInt(5,ids);
                    stmt4.executeUpdate();
                    String strSelect = "SELECT ID,str_1, str_2, lenght_1 , lenght_2 FROM " + TableName + " WHERE ID= ?";
                    PreparedStatement st = con.prepareStatement(strSelect);
                    st.setInt(1,ids);
                    ResultSet rs3 = st.executeQuery();
                    System.out.println("Введенные данные");
                    while (rs3.next()) {
                        System.out.println(rs3.getString("ID"));
                        System.out.println(rs3.getString("str_1"));
                        System.out.println(rs3.getString("str_2"));
                        System.out.println(rs3.getString("lenght_1"));
                        System.out.println(rs3.getString("lenght_2"));
                    }

                }
                case 5 -> {
                    System.out.println("Введите id");
                    int ids = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Введите первую строку");
                    String str1 = scan.nextLine();
                    System.out.println("Введите вторую строку");
                    String str2 = scan.nextLine();
                    String query = "INSERT INTO " + TableName + " (ID, str_1, str_2, str) VALUES (?,?,?,?)";
                    PreparedStatement stmt5 = con.prepareStatement(query);
                    stmt5.setInt(1,ids);
                    stmt5.setString(2,str1);
                    stmt5.setString(3,str2);
                    stmt5.setString(4,str1+str2);
                    stmt5.executeUpdate();
                    String strSelect = "SELECT ID,str_1, str_2, str FROM " + TableName + " WHERE ID= ?";
                    PreparedStatement st = con.prepareStatement(strSelect);
                    st.setInt(1,ids);
                    ResultSet rs3 = st.executeQuery();
                    System.out.println("Введенные данные");
                    while (rs3.next()) {
                        System.out.println(rs3.getString("ID"));
                        System.out.println(rs3.getString("str_1"));
                        System.out.println(rs3.getString("str_2"));
                        System.out.println(rs3.getString("str"));
                    }

                }
                case 6 -> {
                    System.out.println("Введите id");
                    int ids = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Введите первую строку");
                    String str1 = scan.nextLine();
                    System.out.println("Введите вторую строку");
                    String str2 = scan.nextLine();
                    boolean t = str1.equals(str2);
                    String query = "INSERT INTO " + TableName + " (ID, str_1, str_2, bool) VALUES (?,?,?,?)";
                    PreparedStatement stmt5 = con.prepareStatement(query);
                    stmt5.setInt(1,ids);
                    stmt5.setString(2,str1);
                    stmt5.setString(3,str2);
                    stmt5.setBoolean(4, t);
                    stmt5.executeUpdate();
                    String strSelect = "SELECT ID,str_1, str_2, bool FROM " + TableName + " WHERE ID= ?";
                    PreparedStatement st = con.prepareStatement(strSelect);
                    st.setInt(1,ids);
                    ResultSet rs3 = st.executeQuery();
                    System.out.println("Введенные данные");
                    while (rs3.next()) {
                        System.out.println(rs3.getString("ID"));
                        System.out.println(rs3.getString("str_1"));
                        System.out.println(rs3.getString("str_2"));
                        System.out.println(rs3.getString("bool"));
                    }
                }
            }
        }
    }
}