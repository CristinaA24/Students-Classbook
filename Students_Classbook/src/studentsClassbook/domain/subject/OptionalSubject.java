package studentsClassbook.domain.subject;

import java.util.Objects;
import java.util.Scanner;

public class OptionalSubject extends Subject{

    private boolean mandatory;


    public OptionalSubject() {
    }

    public OptionalSubject(boolean mendatory) {
        this.mandatory = mendatory;
    }

    public OptionalSubject(String name, int passGrade, int credits, boolean mendatory) {
        super(name, passGrade, credits);
        this.mandatory = mendatory;
    }

    public boolean isMendatory() {
        return mandatory;
    }

    public void setMendatory(boolean mendatory) {
        this.mandatory = mendatory;
    }

    public void setOptionalSubject() {
        Scanner myInput = new Scanner(System.in);

        System.out.print("Is the optional subject mandatory? (Y/N): ");
        String aux;
        aux = myInput.nextLine();
        if(aux.equals("Y") || aux.equals("Yes")) {
            System.out.println("The Optional Subject is mandatory");
            } else {
            System.out.println("The Optional Subject is not mandatory");

        }
    }

    @Override
    public String toString() {
        return "OptionalSubject{" +
                "mendatory=" + mandatory +
                ", name='" + subjectName + '\'' +
                ", passGrade=" + passGrade +
                ", credits=" + credits +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OptionalSubject that = (OptionalSubject) o;
        return mandatory == that.mandatory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mandatory);
    }

}
