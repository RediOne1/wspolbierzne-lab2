/**
 * author:  Adrian
 * index:   204423
 * data:    2015-05-12
 */
public abstract class Machine extends Thread{
    public Task task = null;
    public Employee employee1 = null, employee2 = null;
    public boolean working = true;

    public synchronized boolean tryBookPlace(Employee employee, Task task) {
        if(!working)
            return false;
        if (employee1 == null) {
            this.task = task;
            employee1 = employee;
            newEmployee();
            return true;
        } else if (employee2 == null) {
            employee2 = employee;
            newEmployee();
            return true;
        }
        return false;
    }

    private void newEmployee(){
        if(employee1 != null && employee2 != null)
            startSolving();
    }

    public abstract void startSolving();
}
