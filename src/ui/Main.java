package ui;
import service.StudentService;
import model.Student;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();
        System.out.print("Username: ");
        String user = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();
        if(!(user.equals("admin") && pass.equals("1234"))){
            System.out.println("Access Denied.");
            return;
        }
        while (true){
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch){
                case 1 -> {
                    System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Age: "); int age = sc.nextInt(); sc.nextLine();
                    System.out.print("Grade: "); String grade = sc.nextLine();
                    service.addStudent(new Student(id, name, age, grade));
                }
                case 2 -> service.viewStudents();
                case 3 -> {
                    System.out.print("ID to update: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("New Name: "); String name = sc.nextLine();
                    System.out.print("New Age: "); int age = sc.nextInt(); sc.nextLine();
                    System.out.print("New Grade: "); String grade = sc.nextLine();
                    service.updateStudent(id, name, age, grade);
                }
                case 4 -> {
                    System.out.print("ID to delete: "); int id = sc.nextInt(); sc.nextLine();
                    service.deleteStudent(id);
                }
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
