package stream;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String a[]){
        List<Employee> employees =  new ArrayList<>();
        List<Employee> employeeList = getDetails(employees);
        List<Double> list = employeeList.stream().map(emp -> emp.getSalary()).distinct().toList();
        System.out.println(list);
    }

    public static List<Employee> getDetails(List<Employee> employeeList){
        employeeList.add(new Employee(1, "Alice", "HR", 50000));
        employeeList.add(new Employee(2, "Bob", "Finance", 60000));
        employeeList.add(new Employee(3, "Charlie", "IT", 70000));
        employeeList.add(new Employee(4, "David", "Marketing", 55000));
        employeeList.add(new Employee(5, "Eva", "Sales", 45000));
        employeeList.add(new Employee(6, "Frank", "IT", 72000));
        employeeList.add(new Employee(7, "Grace", "HR", 48000));
        employeeList.add(new Employee(8, "Hank", "Finance", 63000));
        employeeList.add(new Employee(9, "Ivy", "Marketing", 51000));
        employeeList.add(new Employee(10, "Jack", "Sales", 46000));
        employeeList.add(new Employee(11, "Kara", "IT", 75000));
        employeeList.add(new Employee(12, "Leo", "HR", 49000));
        employeeList.add(new Employee(13, "Mona", "Finance", 61000));
        employeeList.add(new Employee(14, "Nina", "Marketing", 52000));
        employeeList.add(new Employee(15, "Oscar", "Sales", 47000));
        employeeList.add(new Employee(16, "Paul", "IT", 74000));
        employeeList.add(new Employee(17, "Quinn", "HR", 49500));
        employeeList.add(new Employee(18, "Rita", "Finance", 62000));
        employeeList.add(new Employee(19, "Sam", "Marketing", 53000));
        employeeList.add(new Employee(20, "Tom", "Sales", 48000));
        return employeeList;
    }
}
