package CompanyUtil;

import CompanyObjects.Employee;

import java.util.ArrayList;
import java.util.Scanner;

public class WorkHoursLoader {

    //this loads the work hours from ONE file of employees in a given array list
    public static void loadDailyHours(String fileName, EmployeeStorage<Employee> employees) {
       ArrayList<String> data =  FileRead.readFile(fileName);
        for (String datum : data) {
            for (Employee emp : employees.getEmployees())  {
                String[] sData = datum.split(";");
                if (Integer.parseInt(sData[0]) == emp.getId()) {
                    int hWorks =Integer.parseInt(sData[1]);
                    emp.setOvertimeHours(emp.calcOvertime(hWorks));
                    emp.setMissedHours(emp.calcMissed(hWorks));
                    emp.addWorkHours(hWorks);

                    }

                }
            }

    }

    //Verifies and reads a work hours file
    public static void VerifyWorkHoursFile(Scanner reader,EmployeeStorage<Employee> employees){

        String name1="";
        reader.nextLine();
        //This will keep reading the User input until he provides a valid filename
        while (!FileRead.fileExists("Data/"+ name1)) {
            System.out.println("name of file (just the name + extension, the file must be in the Data folder):");
            name1 = reader.nextLine();
        }

        WorkHoursLoader.loadDailyHours("Data/"+ name1,employees);
    }
}
