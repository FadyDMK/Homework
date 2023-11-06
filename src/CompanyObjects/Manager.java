package CompanyObjects;

import UI.*;

public class Manager extends Employee{

    private float basicWage;
    private float overtimeWage;




    //Constructor
    public Manager(int id, String name, String isManager, int dailyRequiredHours,float basicWage,float overtimeWage) {
        super(id, name, isManager, dailyRequiredHours);
        this.overtimeWage=overtimeWage;
        this.basicWage= basicWage;
    }

    //Getters
    public float getBasicWage() {
        return basicWage;
    }



    //Setters
    public void setWage() {
        wage = basicWage + (overtimeWage * getOvertimeHours());
    }





    //Others
    public void printEmployee(){
        super.printEmployee();
        setWage();
        System.out.print("Wage: "+wage+"\n");
    }

    //Calculate the losses by the company for each employee
    public float companyLoss(){
        return this.basicWage*getMissedHours()/(Menu.getMonthDays()*getDailyRequiredHours());
    }

}
