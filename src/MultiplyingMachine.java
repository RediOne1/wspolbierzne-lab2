/**
 * authot:  Adrian Kuta
 * index:   204423
 * date:    01.06.15
 */
public class MultiplyingMachine extends Machine implements Employee.CommunicationInterface {
    @Override
    public void onTaskSolved() {
        if (Settings.TRYB == Settings.GADATLIWY) {
            System.out.println("Employee " + employee1 + " leaved machine with solved task");
            System.out.println("Employee " + employee2 + " pressed first button");
        }
        employee1 = employee2;
        employee2 = null;
        solvingInProgress = false;
    }

    @Override
    public Task solveTask(Task task) {
        if (checkDestroy())
            return null;
        task.result = "" + (task.arg1 + task.arg2);
        if (Settings.TRYB == Settings.GADATLIWY)
            System.out.println("MultiplyingMachine solved task: " + task.arg1 + task.operator + task.arg2 + "=" + task.result);
        return task;
    }
}
