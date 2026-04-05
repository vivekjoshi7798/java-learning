package scenario;


/*
* 2 Stream questions -
        Student class → id, name, rollNo, division, percentage.
Top 3 highest percentage students -


*
* Division wise 3 highest percentage students -
* Function<List<Student>, List<Student>> top3 = list ->Unknown macro: { return list.stream().sorted((s1, s2) -> Double.compare(s2.getPercentage(), s1.getPercentage())).limit(3).toList(); };
Map<String, List<Student>> top3Student= students.stream().collect(Collectors.groupingBy(Student::getSectionName,
Collectors.collectingAndThen(Collectors.toList(), top3)));
System.out.println(top3Student);
*
*
*6.	How would you use Streams API to count students in each department from a list of student objects?
*
*
* */

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Student {
    // Attributes (instance variables)
    private int id;
    private String name;
    private int rollNo;
    private String division;
    private double percentage;

    public Student(int id, String name, int rollNo, String division, double percentage) {
        this.id = id;
        this.name = name;
        this.rollNo = rollNo;
        this.division = division;
        this.percentage = percentage;
    }

    // Optional: Getter and Setter methods for the attributes
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getRollNo() { return rollNo; }
    public void setRollNo(int rollNo) { this.rollNo = rollNo; }
    public String getDivision() { return division; }
    public void setDivision(String division) { this.division = division; }
    public double getPercentage() { return percentage; }
    public void setPercentage(double percentage) { this.percentage = percentage; }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rollNo=" + rollNo +
                ", division='" + division + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}

public class Solution {

    public static void main(String[] args) {

        List<Student> students = List.of(
                new Student(1, "Alice", 101, "A", 85.5),
                new Student(2, "Bob", 102, "B", 90.0),
                new Student(3, "Charlie", 103, "A", 78.0),
                new Student(4, "David", 104, "B", 88.5),
                new Student(5, "Eve", 105, "A", 92.0),
                new Student(6, "Frank", 106, "B", 75.5),
                new Student(7, "Grace", 107, "A", 80.0),
                new Student(8, "Hannah", 108, "B", 95.0),
                new Student(9, "Ivy", 109, "A", 89.5),
                new Student(10, "Jack", 110, "B", 82.0),
                new Student(11, "Kevin", 111, "C", 91.0),
                new Student(12, "Liam", 112, "C", 87.5),
                new Student(13, "Mia", 113, "C", 93.0),
                new Student(14, "Nina", 114, "C", 79.0)
        );

//        4. How would you use Streams API to count students in each department from a list of student objects?
        Map<String, List<Student>> data=students.stream().collect(Collectors.groupingBy(Student::getDivision,Collectors.toList()));
        System.out.println(data);

        List<Student> top3HighestPercentageStudents= students.stream().sorted(Comparator.comparingDouble(Student::getPercentage).reversed()).limit(3).toList();
        System.out.println("Top 3 highest percentage students:");
        System.out.println(top3HighestPercentageStudents);



        Map<String, List<Student>> top3InDivisionA= students.stream().collect(Collectors.groupingBy(
                Student::getDivision,
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        list->list.stream().sorted(Comparator.comparingDouble(Student::getPercentage).reversed()).limit(3).toList()
                )));

        System.out.println("Division wise 3 highest percentage students:");
        System.out.println(top3InDivisionA);

        Map<String, Long> studentCountByDivision = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getDivision,
                        LinkedHashMap::new, // Preserves insertion order
                        Collectors.counting()
                ));

        System.out.println("Student count by division:");
        System.out.println(studentCountByDivision);



    }

}
