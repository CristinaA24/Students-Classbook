package studentsClassbook.domain.group;

import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;
import studentsClassbook.domain.person.student.Student;

import static java.lang.Math.max;

public abstract class Group implements Comparable<Group>{
    private static int counter = 0;
    private final int groupID;
    private String name;
    private TreeSet<Student> students;

    public static void SetGlobalId(int newID) {
        counter = newID;
    }

    public static int getGlobalID() {
        return counter;
    }

    public int getID() {
        return groupID;
    }

    public Group() {
        counter += 1;
        groupID = counter;
        this.name = "";
        this.students = new TreeSet<>();
    }

    public Group(String name) {
        counter += 1;
        groupID = counter;
        this.name = name;
        this.students = new TreeSet<>();
    }

    public Group(int groupID, String name) {
        counter = max(counter, groupID);
        this.groupID = groupID;
        this.name = name;
        this.students = new TreeSet<>();
    }

    public Group(int groupID, String name, TreeSet<Student> students) {
        counter = max(counter, groupID);
        this.groupID = groupID;
        this.name = name;
        this.students = students;
    }


    public void setGroup() {
        Scanner myInput = new Scanner(System.in);
        System.out.println("Group:");
        System.out.print("name = ");
        this.name = myInput.nextLine();
        System.out.println();
    }



    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Group.counter = counter;
    }

    public int getGroupID() {
        return groupID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeSet<Student> getStudents() {
        return students;
    }

    public void setStudents(TreeSet<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group{ " + groupID + '\'' +
                "name= " + name + '\'' +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return name.equals(group.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Group o) {
        return this.getName().compareTo(o.getName());
    }
}
