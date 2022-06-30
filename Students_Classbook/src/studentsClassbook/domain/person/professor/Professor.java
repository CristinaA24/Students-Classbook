package studentsClassbook.domain.person.professor;

import studentsClassbook.domain.person.Person;

import java.util.Objects;
import java.util.Scanner;



public class Professor extends Person {

    private String professorEmail;
    private int salary;
    private String academicRank;

    public Professor() {
        super();
    }


    public Professor(String professorEmail, int salary, String academicRank) {
        this.professorEmail = professorEmail;
        this.salary = salary;
        this.academicRank = academicRank;
    }

    public Professor(String cnp, String firstName, String lastName, String professorEmail, String academicRank, int salary) {
        super(cnp, firstName, lastName);
        this.professorEmail = professorEmail;
        this.academicRank = academicRank;
        this.salary = salary;

    }


    public String getProfessorEmail() {
        return professorEmail;
    }

    public void setProfessorEmail(String professorEmail) {
        this.professorEmail = professorEmail;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getAcademicRank() {
        return academicRank;
    }

    public void setAcademicRank(String academicRank) {
        this.academicRank = academicRank;
    }

    public void setProfessor() {
        super.setPerson();
        Scanner myInput = new Scanner(System.in);

//        System.out.println("Enter rank: ");
//        String aux = myInput.nextLine();
//        setRank(aux);

        System.out.println("Enter salary: ");
        this.salary = myInput.nextInt();
    }



    @Override
    public String toString() {
        return "Professor{" +
                "cnp=" + cnp + '\'' +
                ", first Name=" + firstName + '\'' +
                ", last Name=" + lastName + '\'' +
                ", age=" + age +
                ", professor email=" + professorEmail + '\'' +
                ", salary=" + salary + '\'' +
                ", academic rank=" + academicRank +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Professor that = (Professor) o;
        return professorEmail == that.professorEmail && salary == that.salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), professorEmail, salary);
    }

}

