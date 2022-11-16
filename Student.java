import java.util.Scanner;
public abstract class Student {
    private String name;
    private int age;
    public Student(String name, int age) {
        this.name=name;
        this.age=age;
    }
    public Student(){
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age=age;
    }
}
class Worker extends Student {
    private int salary;

    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Worker std = new Worker();
        System.out.println("Введите Имя");
        std.setName(scan.nextLine());
        System.out.println("Введите возвраст");
        std.setAge(scan.nextInt());
        System.out.println("Введите размер заработной платы");
        std.setSalary(scan.nextInt());
        System.out.println("Имя: " + std.getName());
        System.out.println("Возраст: " + std.getAge());
        System.out.println("Зарплата: " + std.getSalary());
    }
}