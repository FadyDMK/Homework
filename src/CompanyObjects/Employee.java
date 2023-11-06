package CompanyObjects;





public abstract class Employee {
    private final int id;
    private final String name;
    private String isManager;
    private final int dailyRequiredHours;
    private int sumWorkHours;
    private int MissedHours=0;
    private int OvertimeHours=0;

    protected float wage;


    //Constructor
    public Employee(int id, String name, String isManager, int dailyRequiredHours) {
        this.id = id;
        this.name = name;
        this.isManager = isManager;
        this.dailyRequiredHours = dailyRequiredHours;
    }

    //Getters



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIsManager() {
        return isManager;
    }

    public int getDailyRequiredHours() {
        return dailyRequiredHours;
    }

    public int getSumWorkHours() {
        return sumWorkHours;
    }

    public int getMissedHours() {
        return MissedHours;
    }

    public float getBasicWage(){return 0;}
    public int getOvertimeHours() {
        return OvertimeHours;
    }

    public float getWage() {
        setWage();
        return wage;
    }


    //Setters
    public void addWorkHours(int addedHours) {
        sumWorkHours += addedHours;
    }
    public abstract void setWage();

    public void setOvertimeHours(int n) {
        OvertimeHours += n;
    }
    public void setMissedHours(int n) {
        MissedHours += n;
    }


    //Other methods

    public void printEmployee(){
        System.out.print("ID: "+this.getId()+"\tName: "+this.getName()+"\tPosition:"+this.getIsManager()+"\tOvertime:"+this.getOvertimeHours()+"\tRequired hours:"+this.getDailyRequiredHours()+"\tHours Worked: "+this.getSumWorkHours()+"\tMissed hours: "+this.getMissedHours()+"\t");
    }

    public abstract float companyLoss();

    //Calculate Overtime hours in one specific day
    public int calcOvertime(int hWork){
        int dif=hWork-getDailyRequiredHours();
        return Math.max(dif, 0);
    }

    //Calculate missed hours in one specific day
    public int calcMissed(int hWork){
        int dif=getDailyRequiredHours()-hWork;
        return Math.max(dif, 0);
    }

}
