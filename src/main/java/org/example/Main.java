package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {

    private static Map<Integer,Employee> employeeMap;
    private static List<Employee> duplicatedEmployees;
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1,"ömer","kenar"));
        employees.add(new Employee(2,"hatice","kenar"));
        employees.add(new Employee(2,"hanife","kenar"));
        employees.add(new Employee(3,"umut","kenar"));
        employees.add(new Employee(3,"fahri","kenar"));
        employees.add(new Employee(3,"deniz","kenar"));
        employees.add(new Employee(3,"eymen","kenar"));

        System.out.println(findDuplicates(employees).size());
        System.out.println(findDuplicates(employees));
        System.out.println(findUniques(employees).size());
        System.out.println(findUniques(employees));
        System.out.println(removeDuplicates(employees));

        System.out.println(WordCounter.calculatedWord());
    }

    public static List<Employee> findDuplicates(List<Employee> employees){
        employeeMap = new HashMap<>();
        duplicatedEmployees = new LinkedList<>();
        Iterator<Employee> iterator = employees.iterator();

        while (iterator.hasNext()){
            Employee employee = iterator.next();

            if (employee == null){
                System.out.println("kayıt hatalıdır..");
                continue;
            }

            if (employeeMap.containsKey(employee.getId())){
                duplicatedEmployees.add(employee);
            } else {
                employeeMap.put(employee.getId(), employee);
            }
        }
        return duplicatedEmployees;
    }

    public static Map<Integer,Employee> findUniques(List<Employee> employees){
        employeeMap = new HashMap<>();
        Iterator<Employee> iterator = employees.iterator();

        while (iterator.hasNext()){
            Employee employee = iterator.next();

            if (employee == null){
                System.out.println("kayıt hatalıdır..");
                continue;
            }

            if (!employeeMap.containsKey(employee.getId())){
                employeeMap.put(employee.getId(), employee);
            }
        }
        return employeeMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees){
        List<Employee> dublicates = findDuplicates(employees);
        Map<Integer, Employee> uniques = findUniques(employees);
        List<Employee> onlyUnique = new LinkedList<>(uniques.values());
        onlyUnique.removeAll(dublicates);
        return onlyUnique;
    }
}