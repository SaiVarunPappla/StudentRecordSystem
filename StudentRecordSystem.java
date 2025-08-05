import java.util.ArrayList;
import java.util.Scanner;
class Student {
    private int id;
    private String name;
    private double marks;
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public double getMarks() { return marks; }
    public void setName(String name) { this.name = name; }
    public void setMarks(double marks) { this.marks = marks; }
    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Marks: " + marks;
    }
}
public class StudentRecordSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Student Record Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: updateStudent(); break;
                case 4: deleteStudent(); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);
    }
    private static void addStudent() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }
    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            System.out.println("\n--- Student Records ---");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean found = false;
        for (Student s : students) {
            if (s.getId() == id) {
                System.out.print("Enter new Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new Marks: ");
                double marks = scanner.nextDouble();
                s.setName(name);
                s.setMarks(marks);
                System.out.println("Student updated successfully!");
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Student not found.");
    }
    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();
        boolean removed = students.removeIf(s -> s.getId() == id);
        if (removed) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }
}