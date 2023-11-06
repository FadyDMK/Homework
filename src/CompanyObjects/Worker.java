package CompanyObjects;

import UI.*;

public class Worker extends Employee{


    private float overtimeWage;
    private float hourlyWage;


    //Worker
    //o hourly wage [$]
    //o overtime wage [hourly %]
    //o Wage: (basic work hours * hourly wage) + (overtime hours * hourly wage * (1 + overtime wage))


    //Constructor
    public Worker(int id, String name, String isManager, int dailyRequiredHours,float hourlyWage,float overtimeWage) {
        super(id, name, isManager, dailyRequiredHours);
        this.hourlyWage=hourlyWage;
        this.overtimeWage=overtimeWage;
    }


    //Setters
    public void setWage() {
        wage=(this.getDailyRequiredHours()*this.hourlyWage*Menu.getDays())+ this.getOvertimeHours()*this.hourlyWage*(1+this.getOvertimeWage());
    }


    //Getters
    public float getBasicWage(){return this.getDailyRequiredHours()*this.hourlyWage*Menu.getDays();}
    public float getOvertimeWage() {
        return overtimeWage;
    }





    //Others
    public void printEmployee(){
        super.printEmployee();
        setWage();
        System.out.print("Wage: "+wage+"\n");
    }


    //Calculate the losses by the company for each employee
    public float companyLoss(){
        return this.getMissedHours()*this.hourlyWage;
    }
}
