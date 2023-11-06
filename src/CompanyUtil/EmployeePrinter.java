package CompanyUtil;

import CompanyObjects.*;

public class EmployeePrinter {

    private final EmployeeStorage<Employee> employees ;

    public EmployeePrinter(EmployeeStorage<Employee> employees){
        this.employees = employees;
    }


    //Task 3: Print the employees in alphabetical order
    public void printSortedAlphabetically(){
        employees.sortAlphabetically();
        this.printEmployees();
    }

    //Task 4 Sort the employees by missed hours
    public void printSortByMissedHours(){
        employees.sortByMissedHours();
        this.printEmployees();
    }



    //Task 5
    public void printTotalWage(){
        float total=0;
        for (Employee emp:employees.getEmployees()){
            total += emp.getWage();
        }
        System.out.println("Total amount to be paid: "+ total);
    }
    public void printBasicWage(){
        float total=0;
        for (Employee emp:employees.getEmployees()){
            total += emp.getBasicWage();
        }
        System.out.println("Total amount to be paid for normal wage: "+ total);
    }
    public void printOvertimeWage(){
        float total=0;
        for (Employee emp:employees.getEmployees()){
            total += Math.max(emp.getWage()- emp.getBasicWage(),0);
        }
        System.out.println("Total amount to be paid for overtime work: "+ total);
    }

    //adds up all the losses made by the company
    public void printLoss(){
        float total=0;
        for(Employee emp:employees.getEmployees()){total += emp.companyLoss();}
        System.out.println("Total amount lost due to missed hours: "+ total);

    }
    public void printEmployees() {
        for (int i = 0; i < employees.size(); i++) {
            Employee emp = employees.get(i);
            emp.printEmployee();

        }
    }
}
