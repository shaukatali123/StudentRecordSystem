package com.student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        StudentDao dao = new StudentDao();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Student Record System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Update Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Name: ");
                    String name = sc.next();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    System.out.print("Enter Course: ");
                    String course = sc.next();

                    if (id <= 0 || name.isEmpty() || age <= 0 || course.isEmpty()) {
                        System.out.println("Please enter all student details properly!");
                    } else {
                        Student s = new Student(id, name, age, course);
                        dao.addStudent(s);
                    }
                    break;

                case 2:
                    System.out.println("\n--- Student List ---");
                    for (Student st : dao.getAllStudents()) {
                        System.out.println("ID: " + st.id + ", Name: " + st.name + ", Age: " + st.age + ", Course: " + st.course);
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    dao.deleteStudent(deleteId);
                    break;

                case 4:
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();

                    System.out.print("Enter New Name: ");
                    String newName = sc.next();

                    System.out.print("Enter New Age: ");
                    int newAge = sc.nextInt();

                    System.out.print("Enter New Course: ");
                    String newCourse = sc.next();

                    if (updateId <= 0 || newName.isEmpty() || newAge <= 0 || newCourse.isEmpty()) {
                        System.out.println("Please enter all updated student details properly!");
                    } else {
                        Student updatedStudent = new Student(updateId, newName, newAge, newCourse);
                        dao.updateStudent(updatedStudent);
                    }
                    break;

                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
