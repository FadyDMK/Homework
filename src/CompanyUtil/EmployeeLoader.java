package CompanyUtil;

import CompanyObjects.Employee;
import CompanyObjects.Manager;
import CompanyObjects.Worker;


import java.util.ArrayList;

public class EmployeeLoader {



    //Task 1: Read the employees file
    public static void loadEmployeesData(EmployeeStorage<Employee> employees) {
        String fileName = "Data/employee_data.csv";
        ArrayList<String> data = FileRead.readFile(fileName);


        String[] sData = new String[data.size()];
        for (String datum : data) {
            sData = datum.split(";");
            Employee temp = null;
            switch (sData[2].toLowerCase()) {
                case "worker":
                    temp = new Worker(Integer.parseInt(sData[0])
                            , sData[1]   //id
                            , sData[2]   //name
                            , Integer.parseInt(sData[3]) //position
                            , Float.parseFloat(sData[4]) //required work hours
                            , Float.parseFloat(sData[5]  //basic or hourly wage
                    ));
                    break;
                case "manager":
                    temp = new Manager(Integer.parseInt(sData[0])
                            , sData[1]
                            , sData[2]
                            , Integer.parseInt(sData[3])
                            , Float.parseFloat(sData[4])
                            , Float.parseFloat(sData[5])
                    );
                    break;
                default:
                    System.out.print("there is an error in the file(Position of the employee not specified correctly)");

            }
            employees.add(temp);
        }
    }
}
