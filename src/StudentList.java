import java.util.ArrayList;

class StudentList {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void editStudent(String id, double newMarks) {
        Student student = searchStudent(id);
        if (student != null) {
            student.setMarks(newMarks);
            System.out.println("Student's marks updated.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void deleteStudent(String id) {
        Student student = searchStudent(id);
        if (student != null) {
            students.remove(student);
            System.out.println("Student removed.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public Student searchStudent(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public void sortStudentsByMarks() {
        // Bubble sort by marks in descending order
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = 0; j < students.size() - 1 - i; j++) {
                if (students.get(j).getMarks() < students.get(j + 1).getMarks()) {
                    // Swap students[j] and students[j+1]
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
    }

    public void sortStudentsByName() {
        // Bubble sort by name in ascending order
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = 0; j < students.size() - 1 - i; j++) {
                if (students.get(j).getName().compareTo(students.get(j + 1).getName()) > 0) {
                    // Swap students[j] and students[j+1]
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
    }
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}