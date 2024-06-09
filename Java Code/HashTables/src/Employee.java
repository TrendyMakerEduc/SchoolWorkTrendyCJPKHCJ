public class Employee {

    // Name of the employee
    private String name;
    // Salary of the employee
    private double salary;
    // Seniority of the employee
    private int seniority;

    public Employee(String name, double salary, int seniority){
        this.name = name;
        this.salary = salary;
        this.seniority = seniority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getSeniority() {
        return seniority;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }
    @Override
    public int hashCode() {
        //return this.name.hashCode();
        //or
        int hashVal = 0;
        for(char c: getName()){
            hashVal = 37 * hashVal + c;
        }
        return hashVal; // % hashTable
    }

    //Hash function
    int hash(const String key, int tableSize){
        int hashVal = 0;
        for(char c: key){
            hashVal = 37 * hashVal + c;
        }
        return hashVal  % tableSize
    }
    }
