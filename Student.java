package studentmanagementsystem;

public class Student {

    int id;
    String name;
    int age;
    String gender;
    String address;
    int semester;
    double marks;
    String contactNumber;

    public Student(int id,
                   String name,
                   int age,
                   String gender,
                   String address,
                   int semester,
                   double marks,
                   String contactNumber) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.semester = semester;
        this.marks = marks;
        this.contactNumber = contactNumber;
    }

    public void display() {

        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Address: " + address);
        System.out.println("Semester: " + semester);
        System.out.println("Marks: " + marks);
        System.out.println("Contact: " + contactNumber);
    }
}