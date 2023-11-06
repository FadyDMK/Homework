package CompanyUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import CompanyObjects.Employee;


public class EmployeeStorage<T extends Employee> {

    protected ArrayList < T > employees = new ArrayList < > ();
    public void add(T newEmployee) {employees.add(newEmployee);}
    public T get(int index) {
        return employees.get(index);
    }
    public int size() {
        return employees.size();
    }

    public ArrayList<T> getEmployees(){return employees;}

    //Comparator to sort alphabetically
    public void sortAlphabetically(){
        employees.sort(
                (p1,p2)->p1.getName().compareToIgnoreCase(p2.getName())
        );
    }

    //Comparator to sort by missed hours
    public void sortByMissedHours(){
        employees.sort(
                Comparator.comparingInt(Employee::getMissedHours)
        );
        Collections.reverse(employees);//this is a built-in function that reverses the order of the ArrayList(or we can use a for loop)
    }

}