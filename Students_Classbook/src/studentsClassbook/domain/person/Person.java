package studentsClassbook.domain.person;

import java.util.Objects;
import java.util.Scanner;


public class Person {


    protected String cnp;
    protected String firstName;
    protected String lastName;
    protected int age;


    public Person() {
    }

    public Person(String cnp, String firstName, String lastName, int age) {
        this.cnp = cnp;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Person(String cnp, String firstName, String lastName) {
        this.cnp = cnp;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public void setPerson(){
        Scanner myInput = new Scanner(System.in);

        System.out.println("\n--- Set person ---\n");
        System.out.println("Enter first name: ");
        this.firstName = myInput.nextLine();

        System.out.println("Enter last name: ");
        this.lastName = myInput.nextLine();

        System.out.println("Enter cnp: ");
        this.cnp = myInput.nextLine();

        System.out.println("Enter age: ");
        this.age = myInput.nextInt();

    }

    @Override
    public String toString() {
        return "Person{" +
                "cnp='" + cnp + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return cnp.equals(person.cnp)
                && firstName.equals(person.firstName)
                && lastName.equals(person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnp, firstName, lastName);
    }
}
