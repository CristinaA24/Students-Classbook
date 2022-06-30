package studentsClassbook.domain.curriculum;


import java.util.Objects;
import java.util.Scanner;

public class Curriculum {

    private String major;
    private int reqCredits;

    public Curriculum() {
        this.major = "";
        this.reqCredits = 0;
    }

    public Curriculum(String major, int reqCredits) {

        this.major = major;
        this.reqCredits = reqCredits;
    }

//    public void setCurriculum(){
//        Scanner myInput = new Scanner(System.in);
//        System.out.println("Curriculum:");
//        System.out.print("major = ");
//        this.major = myInput.nextLine();
//        System.out.print("required credits = ");
//        this.reqCredits = myInput.nextInt();
//        System.out.println();
//    }


    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getReqCredits() {
        return reqCredits;
    }

    public void setReqCredits(int reqCredits) {
        this.reqCredits = reqCredits;
    }

    @Override
    public String toString() {
        return "Curriculum{" + "major= "  + major + '\'' +
                "required credits= " + reqCredits + '\'' +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curriculum curriculum= (Curriculum) o;
        return major.equals(curriculum.major);
    }

    @Override
    public int hashCode() {
        return Objects.hash(major);
    }
}
