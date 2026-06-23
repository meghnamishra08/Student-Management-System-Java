package studentmanagementsystem;
import java.util.ArrayList;
import java.util.Scanner;
public class StudentManagementSystem {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Display Topper");
            System.out.println("7. Sort Students by marks");
            System.out.println("8. Exit");
            System.out.print("Enter Choice: ");
            
        int choice = sc.nextInt();
        switch (choice) {
            
            case 1:
                
            System.out.print("Enter ID: ");
        int id = sc.nextInt();
        boolean idExists = false;
        for (Student s : students) {
        if (s.id == id) {
            idExists = true;
            break;
        }
    }
        if (idExists) {
            System.out.println("Student ID already exists!");
            break;
    }
            sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            int age;
        while (true) {
            System.out.print("Enter Age: ");
            age = sc.nextInt();
        if (age >= 18 && age <= 100) {
            break;
        }
            System.out.println("Invalid Age!");
    }
            sc.nextLine();
            String gender;
        while (true) {
            System.out.print("Enter Gender (Male/Female): ");
            gender = sc.nextLine();
        if (gender.equalsIgnoreCase("Male") ||
            gender.equalsIgnoreCase("Female")) {
            break;
        }
        System.out.println("Invalid Gender!");
    }
            System.out.print("Enter Address: ");
            String address = sc.nextLine();
            int semester;
        while (true) {
            System.out.print("Enter Semester: ");
            semester = sc.nextInt();
        if (semester >= 1 && semester <= 8) {
            break;
        }
            System.out.println("Invalid Semester!");
    }
        double marks;
        while (true) {
            System.out.print("Enter Marks: ");
            marks = sc.nextDouble();
        if (marks >= 0 && marks <= 100) {
            break;
        }
            System.out.println("Invalid Marks!");
    }
            sc.nextLine();
            String contactNumber;
        while (true) {
            System.out.print("Enter Contact Number (10 digits): ");
            contactNumber = sc.nextLine();
        if (contactNumber.matches("\\d{10}")) {
            break;
        }
            System.out.println("Invalid Contact Number!");
    }
            students.add(new Student(id,name,age,gender,address,semester,marks,contactNumber));
            System.out.println("Student Added Successfully!");
            break;

        case 2:
            
        if (students.isEmpty()) {
            System.out.println("No Students Found.");
                    } else {
            students.stream().map((s) -> {
            s.display();
                    return s;
            }).forEach((_item) -> {
            System.out.println("----------------");
            });
    }
            break;               

        case 3:

            System.out.println("1. Search by ID");
            System.out.println("2. Search by Name");
            System.out.print("Enter Choice: ");
        int searchChoice = sc.nextInt();
            sc.nextLine();
        boolean found = false;
        if (searchChoice == 1) {
            System.out.print("Enter Student ID: ");
        int searchId = sc.nextInt();
        for (Student s : students) {
        if  (s.id == searchId) {
            s.display();
            found = true;
            break;
            }
        }
    }   else if (searchChoice == 2) {
            System.out.print("Enter Student Name: ");
            String searchName = sc.nextLine();
        for (Student s : students) {
        if (s.name.equalsIgnoreCase(searchName)) {
            s.display();
            found = true;
            }
        }
    }   else {
            System.out.println("Invalid Choice!");
            break;
    }
        if (!found) {
            System.out.println("Student Not Found!");
    }
        break;
                
        case 4:
                
            System.out.print("Enter Student ID to Delete: ");
        int deleteId = sc.nextInt();
        boolean deleted = false;
        for (int i = 0; i < students.size(); i++) {
        if (students.get(i).id == deleteId) {
            students.remove(i);
            System.out.println("Student Deleted Successfully!");
            deleted = true;
            break;
        }
    }
        if (!deleted) {
            System.out.println("Student Not Found.");
    }
            break;
            
        case 5:
            
            System.out.print("Enter Student ID to Update: ");
        int updateId = sc.nextInt();
            sc.nextLine();
        boolean updated = false;
        for (Student s : students) {
        if (s.id == updateId) {
            System.out.print("Enter New Name: ");
            s.name = sc.nextLine();
            System.out.print("Enter New Age: ");
            s.age = sc.nextInt();
            System.out.println("Student Updated Successfully!");
            updated = true;
            break;
        }
    }
        if (!updated) {
            System.out.println("Student Not Found.");
    }
            break;
            
        case 6:

        if (students.isEmpty()) {
            System.out.println("No Students Found.");
            break;
    }
            Student topper = students.get(0);
        for (Student s : students) {
        if (s.marks > topper.marks) {
            topper = s;
        }
    }
            System.out.println("\n===== TOPPER =====");
            topper.display();

            break;
        
        case 7:

        if (students.isEmpty()) {
            System.out.println("No Students Found.");
            break;
    }
        for (int i = 0; i < students.size() - 1; i++) {
        for (int j = i + 1; j < students.size(); j++) {
        if (students.get(i).marks < students.get(j).marks) {
            Student temp = students.get(i);
            students.set(i, students.get(j));
            students.set(j, temp);
            }
        }
    }
            System.out.println("\n===== STUDENTS SORTED BY MARKS =====");
        for (Student s : students) {
            s.display();
            System.out.println("----------------");
    }
    break;
    
        case 8:
            
            System.out.println("Thank You!");
            System.exit(0);
            default:
            System.out.println("Invalid Choice!");
            }
        }
    }
}