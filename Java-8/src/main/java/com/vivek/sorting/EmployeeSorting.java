package sorting;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Employee domain model representing basic employee details.
 */
class Employee {
    private String name;
    private String deptName;
    private int age;
    private double salary;

    public Employee(String name, String deptName, int age, double salary) {
        this.name = name;
        this.deptName = deptName;
        this.age = age;
        this.salary = salary;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", deptName='" + deptName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}

/**
 * Demonstrates various Java 8 Stream operations on Employee data.
 */
public class EmployeeSorting {
    public static void main(String[] args) {

        // Immutable list of employees
        List<Employee> employees = List.of(
                new Employee("Alice", "HR", 30, 60000),
                new Employee("Bob", "IT", 25, 75000),
                new Employee("sita", "IT", 25, 80000),
                new Employee("virBahadur", "IT", 25, 80000),
                new Employee("Charlie", "Finance", 28, 70000),
                new Employee("David", "IT", 35, 80000),
                new Employee("Eve", "HR", 29, 65000),
                new Employee("Ram", "HR", 27, 65000),
                new Employee("aba", "HR", 27, 65000),
                new Employee("Frank", "Finance", 32, 72000),
                new Employee("Grace", "IT", 27, 78000),
                new Employee("Heidi", "HR", 31, 62000),
                new Employee("Ivan", "Finance", 26, 71000),
                new Employee("Ayesha", "Finance", 50, 76000),
                new Employee("himanshu", "Finance", 31, 76000),
                new Employee("Judy", "IT", 34, 79000),
                new Employee("Mallory", "HR", 33, 64000)
        );

        // Print all employees
        System.out.println("\nAll Employees:");
        System.out.println(employees);

        // Sort employees by salary in ascending order
        List<Employee> sortedAscending = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .collect(Collectors.toList());
        System.out.println("\nEmployees sorted by salary (Ascending):");
        System.out.println(sortedAscending);

        // Sort employees by salary in descending order
        List<Employee> sortedDescending = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());
        System.out.println("\nEmployees sorted by salary (Descending):");
        System.out.println(sortedDescending);

        // Find the youngest employee
        System.out.println("\nYoungest Employee:");
        employees.stream()
                .min(Comparator.comparingInt(Employee::getAge))
                .ifPresent(System.out::println);

        // Find the oldest employee
        System.out.println("\nOldest Employee:");
        employees.stream()
                .max(Comparator.comparingInt(Employee::getAge))
                .ifPresent(System.out::println);

        // Group employees by department
        Map<String, List<Employee>> map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName, LinkedHashMap::new, Collectors.toList()));
        System.out.println("\nEmployees grouped by department:");
        System.out.println(map);

        // Count employees per department
        Map<String, Long> employeeCounter = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));
        System.out.println("\nEmployee count per department:");
        System.out.println(employeeCounter);

        // Salary statistics (min, max, avg, sum) per department
        Map<String, DoubleSummaryStatistics> employeeDoubleSummaryStatistics = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName,
                        Collectors.summarizingDouble(Employee::getSalary)));
        System.out.println("\nSalary statistics per department:");
        System.out.println(employeeDoubleSummaryStatistics);

        // Average salary per department
        Map<String, Double> employeeAverageSalaryPerDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName,
                        Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("\nAverage salary per department:");
        System.out.println(employeeAverageSalaryPerDepartment);

        // Find second-highest salary (value only)
        System.out.println("\nSecond-highest salary in the company:");
        Optional<Double> sal = employees.stream()
                .map(Employee::getSalary)
                .sorted(Comparator.reverseOrder())
                .distinct()
                .skip(1)
                .findFirst();
        sal.ifPresent(System.out::println);

        // Find employee with second-highest salary
        System.out.println("\nEmployee with second-highest salary:");
        Optional<Employee> secondHighestSalaryEmployee = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(1)
                .findFirst();
        secondHighestSalaryEmployee.ifPresent(System.out::println);

        // Highest salary employee per department
        LinkedHashMap<String, Optional<Employee>> employeeHighestSalaryPerDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName, LinkedHashMap::new,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
        System.out.println("\nHighest-paid employee per department:");
        System.out.println(employeeHighestSalaryPerDepartment);

        // Second-highest salary employee per department
        Map<String, Optional<Employee>> employeeSecondHighestSalaryPerDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDeptName,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                        .skip(1)
                                        .findFirst())));
        System.out.println("\nSecond-highest-paid employee per department:");
        System.out.println(employeeSecondHighestSalaryPerDepartment);

        // Top 3 highest-paid employees per department
        Map<String, List<Employee>> top3SalariesPerDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDeptName,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                        .limit(3)
                                        .collect(Collectors.toList())
                        )
                ));
        System.out.println("\nTop 3 highest-paid employees per department:");
        System.out.println(top3SalariesPerDepartment);

        // Find the youngest employee in each department.
        // If multiple employees have the same age, select the one with the higher salary.
        Map<String, Optional<Employee>> youngestEmployeePerDept = employees.stream().collect(Collectors.groupingBy(
                Employee::getDeptName,
                Collectors.minBy(
                        Comparator.comparingInt(Employee::getAge)
                                .thenComparing(Comparator.comparingDouble(Employee::getSalary).reversed()))
        ));


        System.out.println("\nYoungest employee per department (tie → higher salary wins):");
        System.out.println(youngestEmployeePerDept);


        /*
        Find the oldest employee in each department.
        If multiple employees have the same age, select the one with the lowest salary.
        */

        Map<String, Optional<Employee>> oldestEmployeePerDept = employees.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.minBy(
                Comparator.comparingInt(Employee::getAge).reversed().thenComparingDouble(Employee::getSalary)
        )));

        System.out.println("\n oldest employee per department (tie → lowest salary wins):");
        System.out.println(oldestEmployeePerDept);


        /*🧠 Problem 2 — Triple Condition (Classic Interview Trap)

        Find the employee with the highest salary in each department.
        If salaries are equal → pick the younger employee.
        If age is also equal → pick the employee whose name comes first alphabetically.
        */

        Map<String, Optional<Employee>> highestSalaryYoungerEmployeePerDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName, Collectors.minBy(
                                Comparator.comparingDouble(Employee::getSalary).reversed()
                                        .thenComparingDouble(Employee::getAge)
                                        .thenComparing(Employee::getName, String.CASE_INSENSITIVE_ORDER)
                        )

                ));

        System.out.println("\n highest Salary Younger Employee Per Dept:");
        System.out.println(highestSalaryYoungerEmployeePerDept);

        /*
        “Why didn’t you use maxBy?”
        Because tie-breaking rules conflict in direction. Using minBy with a properly ordered comparator avoids reversal confusion.

        Golden rule:
        🔥 Never call .reversed() in the middle of a comparator chain unless you want to reverse ALL previous rules.

        🧠 Problem 3 — Triple Condition (Opposite Direction)

        Find the youngest employee in each department.
        If ages are equal → pick the one with the highest salary.
        If salary is also equal → pick the employee with the longest name.
        */
        Map<String, Optional<Employee>> youngestHighestSalaryLongestNamePerDept= employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDeptName,
                        Collectors.minBy(
                                Comparator.comparingInt(Employee::getAge)
                                        .thenComparing(Comparator.comparingDouble(Employee::getSalary).reversed())
                                        .thenComparing(Comparator.comparingInt((Employee e)->e.getName().length()).reversed())
                        )

                ));

        System.out.println("\n youngest Highest Salary Longest Name Per Dept :");
        System.out.println(youngestHighestSalaryLongestNamePerDept);



                /*
        🧠 Problem 4 — Filtering + Multi Comparator

        From each department, find the highest-paid employee who is older than 30.
        If multiple match → pick the one with the lowest age.
        */

        Map<String, Optional<Employee>> highestSalaryEmployeeAbove30PerDept=employees.stream().filter(s->s.getAge()>30).collect(Collectors.groupingBy(
                Employee::getDeptName,
                Collectors.maxBy(
                        Comparator.comparingDouble(Employee::getSalary)
                                .thenComparing(Comparator.comparingInt(Employee::getAge).reversed()))

        ));


        System.out.println("\n highest Salary Employee Above 30 PerDept :");
        System.out.println(highestSalaryEmployeeAbove30PerDept);


                /*
        🧠 Problem 5 — Company Level (Not grouping)

        Find the third-highest salary employee in the entire company.
        If multiple employees share that salary → return the youngest among them.
        */
        Optional<Employee> thirdHighestSalaryYoungestEmployee=employees.stream()
                        .map(Employee::getSalary)
                        .distinct()
                        .sorted(Comparator.reverseOrder()).skip(2).findFirst()
                .flatMap(salary-> employees.stream().filter(e-> e.getSalary()==salary).min(Comparator.comparingInt(Employee::getAge)));

        System.out.println("\nthird Highest Salary Youngest Employee :");
        thirdHighestSalaryYoungestEmployee.ifPresent(System.out::println);

        /*
        🧠 Problem 6 — Real Business Rule Style
        For each department, find the employee with salary closest to the department average.
        If two are equally close → pick the younger one.
        */

        Map<String, Double> averageBYDept= employees
                .stream()
                .collect(Collectors.groupingBy(
                        Employee::getDeptName,
                        Collectors.averagingDouble(Employee::getSalary)));


        Map<String, Optional<Employee>> salaryClosestToAveragePerDept=employees
                .stream()
                .collect(Collectors.groupingBy(
                        Employee::getDeptName,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list-> list.stream().min(
                                        Comparator.comparingDouble((Employee e)->Math.abs(e.getSalary()-averageBYDept.get(e.getDeptName())))
                                                .thenComparingInt(Employee::getAge)
                                ))));

        System.out.println("\nsalary Closest To AveragePerDept :" +salaryClosestToAveragePerDept);

        /*
        🧠 Problem 7 — Promotion Rule Type Question
        Eligible employees per department:
        Age < 35
        Salary > department average
        From eligible employees → pick the one with highest salary.
        If tie → pick youngest.
        */

        Map<String, Optional<Employee>>  promotionEligibleTopPerformerPerDept =employees.stream().filter(s->s.getAge()<35 && s.getSalary()>averageBYDept.get(s.getDeptName())).collect(Collectors.groupingBy(
                Employee::getDeptName,
                Collectors.maxBy(
                     Comparator.comparingDouble(Employee::getSalary).reversed()
                )));


        System.out.println("\n Promotion Eligibility Rule\n :");
        System.out.println(promotionEligibleTopPerformerPerDept);

//        6.
        System.out.println("\n Sort a list of employees by salary using Stream API. \n :");
        employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).forEach(System.out::println);



    }
}

