package UI;


import CompanyObjects.*;
import CompanyUtil.*;
import java.io.IOException;
import java.util.Scanner;

import static CompanyUtil.WorkHoursLoader.*;

public class Menu {
    private static int monthDays=30;
    private static int days=1;


    //initializes the program by asking for details we will need for the calculations afterward.
    public static void initialize(Scanner reader, EmployeeStorage<Employee> employees){

        EmployeeLoader.loadEmployeesData(employees);

        int newMonthDays = getValidIntegerInput(reader, "How many days are there in this month:");
        setMonthDays(newMonthDays);

        int newDays = getValidIntegerInput(reader, "How many days have passed this month:");
        setDays(newDays);

        for (int i = 0 ; i<days;i++){
            System.out.println("How many files for day number: " + (i+1) );
            int nFiles = reader.nextInt();
            for(int j = 0 ; j < nFiles;j++){
                System.out.print("File number "+(j+1));
                System.out.print("\n");
                VerifyWorkHoursFile(reader,employees);

            }

        }

    }
    //This is the main menu where u can select which action to execute
    public static void menu(Scanner reader, EmployeeStorage<Employee> employees) throws IOException {
        EmployeePrinter printer = new EmployeePrinter(employees);
        printOptions();
        int c = reader.nextInt();

        switch (c){
            case 1:
                printer.printEmployees();
                back(reader,employees);
                break;
            case 2:
                printer.printSortedAlphabetically();
                back(reader,employees);
                break;
            case 3:
                printer.printSortByMissedHours();
                back(reader,employees);
                break;
            case 4:
                System.out.print("\n---------------------------------\n");
                System.out.print("Company's Financial Report:\n");

                printer.printTotalWage();

                printer.printBasicWage();

                printer.printOvertimeWage();

                printer.printLoss();
                System.out.print("\n---------------------------------\n");
                back(reader,employees);
                break;
            case 5:

                System.out.println("Write the path of the additional work hour file for TODAY:\n");
                VerifyWorkHoursFile(reader,employees);
                System.out.println("File successfully read!");
                back(reader,employees);
                break;
            default:
                menu(reader,employees);
                break;
        }

    }


    //Prints the options to choose from
    private static void printOptions(){
        System.out.println("Choose one of the following choices by typing the corresponding number!");
        System.out.println("1) Print all employees");
        System.out.println("2) Print current wages of employees in alphabetic order of employee name");
        System.out.println("3) Print list of employees in order of missed hours (most in front)");
        System.out.println("4) Print the total amount the company has to pay for normal wage, overtime wage and the loss resulted by hours employees did not work");
        System.out.println("5) Read more daily work hour files\n");

    }

    //Allows to come back to the main menu to execute other actions
    private static void back(Scanner reader,EmployeeStorage<Employee> employees) throws IOException {
        System.out.println("\nEnter 0 to go back to the main menu!\n");
        int c = reader.nextInt();
        if (c==0){menu(reader,employees);}
    }

    //Setters
    public static void setMonthDays(int monthDays) {
        Menu.monthDays = monthDays;
    }

    public static void setDays(int days) {
        Menu.days = days;
    }


    //Getters

    public static int getDays() {
        return days;
    }

    public static int getMonthDays() {
        return monthDays;
    }


    //Insures a valid integer input
    private static int getValidIntegerInput(Scanner reader, String prompt) {
        int input = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println(prompt);
                input = Integer.parseInt(reader.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }

        return input;
    }
}
