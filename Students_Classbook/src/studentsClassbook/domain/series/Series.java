package studentsClassbook.domain.series;

import studentsClassbook.domain.group.Group;

import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

public class Series {

    private static int counter = 0;
    private final int seriesID;
    private String seriesName;
    private TreeSet<Group> groups;

    public Series() {
        counter += 1;
        seriesID = counter;
        seriesName = "";
        groups = new TreeSet<>();
    }

    public Series(int seriesID, String seriesName, TreeSet<Group> groups) {
        this.seriesID = seriesID;
        this.seriesName = seriesName;
        this.groups = groups;
    }

    public void setSeries()
    {
        Scanner myInput = new Scanner(System.in);
        System.out.println("Series:");
        System.out.print("name = ");
        this.seriesName = myInput.nextLine();
        System.out.println();
    }


    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Series.counter = counter;
    }

    public int getSeriesID() {
        return seriesID;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public TreeSet<Group> getGroups() {
        return groups;
    }

    public void setGroups(TreeSet<Group> groups) {
        this.groups = groups;
    }


    @Override
    public String toString() {
        return "Series{ " + seriesID + '\'' +
                "series name= " + seriesName + '\'' +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Series series = (Series) o;
        return seriesName.equals(series.seriesName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seriesName);
    }
}
