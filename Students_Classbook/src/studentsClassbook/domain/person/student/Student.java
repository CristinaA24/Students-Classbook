package studentsClassbook.domain.person.student;

import studentsClassbook.domain.person.Person;


import java.util.Objects;
import java.util.Scanner;

public class Student extends Person {

    private String studentEmail;
    private String phoneNumber;
    private int year;
    private int semester;

    public Student() {
    }

    public Student(String cnp, String firstName, String lastName, int age) {
        super(cnp, firstName, lastName, age);
    }


    public Student(String cnp, String firstName, String lastName, int age, String studentEmail, String phoneNumber, int year, int semester) {
        super(cnp, firstName, lastName, age);
        this.studentEmail = studentEmail;
        this.phoneNumber = phoneNumber;
        this.year = year;
        this.semester = semester;
    }



    public void setStudent() {
        super.setPerson();
        Scanner myInput = new Scanner(System.in);

        System.out.println("Enter student email: ");
        this.studentEmail = myInput.nextLine();

        System.out.println("Enter phone number: ");
        this.phoneNumber = myInput.nextLine();

        System.out.println("Enter year: ");
        this.year = myInput.nextInt();

        System.out.println("Enter semester: ");
        this.semester = myInput.nextInt();

    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
       return  "Student{" +
                "cnp=" + cnp + '\'' +
                ", first Name=" + firstName + '\'' +
                ", last Name=" + lastName + '\'' +
                ", age=" + age +
                ", student email=" + studentEmail + '\'' +
                ", phone number=" + phoneNumber + '\'' +
                ", year=" + year + '\'' +
                ", semester=" + semester + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student that = (Student) o;
        return studentEmail == that.studentEmail && phoneNumber == that.phoneNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), studentEmail, phoneNumber);
    }

}
