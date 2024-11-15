import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentList studentList = new StudentList();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Sort Students by Marks");
            System.out.println("5. Sort Students by Name");
            System.out.println("6. Search Student");
            System.out.println("7. Display All Students");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 7.");
                scanner.nextLine();  // Clear the invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = scanner.next();
                    scanner.nextLine();  // Clear the buffer
                    String name;
                    while (true) {
                        System.out.print("Enter Name: ");
                        name = scanner.nextLine();
                        if (name.matches("[a-zA-Z\\s]+")) {
                            break;
                        } else {
                            System.out.println("Invalid name. Please enter only letters.");
                        }
                    }

                    double marks;
                    while (true) {
                        System.out.print("Enter Marks: ");
                        try {
                            marks = scanner.nextDouble();
                            if (marks >= 0.0 && marks <= 10.0) {
                                break;
                            } else {
                                System.out.println("Marks should be between 0.0 and 10.0.");
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input. Marks should be a number.");
                            scanner.nextLine();  // Clear the invalid input
                        }
                    }
                    studentList.addStudent(new Student(id, name, marks));
                    break;

                case 2:
                    System.out.print("Enter ID of student to edit: ");
                    String editId = scanner.next();
                    System.out.print("Enter new Marks: ");
                    double newMarks;
                    try {
                        newMarks = scanner.nextDouble();
                        if (newMarks < 0.0 || newMarks > 10.0) {
                            System.out.println("Marks should be between 0.0 and 10.0.");
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input. Marks should be a number.");
                        scanner.nextLine();  // Clear the invalid input
                        break;
                    }
                    studentList.editStudent(editId, newMarks);
                    break;

                case 3:
                    System.out.print("Enter ID of student to delete: ");
                    String deleteId = scanner.next();
                    studentList.deleteStudent(deleteId);
                    break;

                case 4:
                    studentList.sortStudentsByMarks();
                    System.out.println("Students sorted by marks.");
                    studentList.displayStudents();
                    break;

                case 5:
                    studentList.sortStudentsByName();
                    System.out.println("Students sorted by name.");
                    studentList.displayStudents();
                    break;

                case 6:
                    System.out.print("Enter ID of student to search: ");
                    String searchId = scanner.next();
                    Student student = studentList.searchStudent(searchId);
                    if (student != null) {
                        System.out.println(student);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 7:
                    studentList.displayStudents();
                    break;

                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}