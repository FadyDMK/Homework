import java.io.IOException;
import java.util.Scanner;

import CompanyObjects.Employee;
import CompanyUtil.EmployeeStorage;
import UI.*;




public class Main {
    public static void main(String[] arg) throws IOException {
        EmployeeStorage<Employee> employees = new EmployeeStorage<>();
        Scanner reader = new Scanner(System.in);
        Menu.initialize(reader,employees);
        Menu.menu(reader,employees);
    }


}