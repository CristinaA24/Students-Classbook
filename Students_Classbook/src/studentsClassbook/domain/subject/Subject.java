package studentsClassbook.domain.subject;

import java.util.Objects;
import java.util.Scanner;

public class Subject {

    protected String subjectName;
    protected int passGrade;
    protected int credits;


//    public Subject() {
//        this.subjectName = "";
//        this.passGrade = 5;
//        this.credits = 1;
//    }

    public Subject(String subjectName, int passGrade, int credits) {
        this.subjectName = subjectName;
        this.passGrade = passGrade;
        this.credits = credits;
    }

    public Subject() {
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getPassGrade() {
        return passGrade;
    }

    public void setPassGrade(int passGrade) {
        this.passGrade = passGrade;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setSubject() {
        Scanner myInput = new Scanner(System.in);

        System.out.print("Enter subject name: ");
        this.subjectName = myInput.nextLine();

        System.out.print("Enter passing grade: ");
        this.passGrade = myInput.nextInt();

        myInput.nextLine();
    }


    @Override
    public String toString() {
        return "Subject{" +
                " subject name=" + subjectName + '\'' +
                ", passing grade=" + passGrade + '\'' +
                ", number of credits=" + credits + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OptionalSubject that = (OptionalSubject) o;
        return subjectName == that.subjectName && passGrade == that.passGrade && credits == that.credits;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subjectName, passGrade, credits);
    }

}
