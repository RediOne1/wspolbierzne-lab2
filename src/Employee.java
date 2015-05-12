import java.util.Random;

/**
 * author:  Adrian Kuta
 * indeks:  204423
 * date:    2015-04-08
 * email:   redione193 @ gmail.com
 */
public class Employee extends Thread {

    private Random random;
    private String name;

    public Employee() {
        name = "";
        random = new Random();
    }

    public Employee(String name) {
        this.name = name;
        random = new Random();
    }

    @Override
    public void run() {
        super.run();
        Task task = tryGetTask();
        solveTask(task);
    }

    private synchronized Task tryGetTask() {
        Task task = null;
        while (task == null) {
            try {
                sleep(getSleepTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (Utils.taskList.size() != 0)
                task = Utils.taskList.remove(0);
        }
        return task;
    }

    private void solveTask(Task task) {
        switch (task.operator) {
            case '+':
                goToAddingMachine(task);
                break;
            case '*':
                goToMultiplyingMachine(task);
        }
    }

    private void goToAddingMachine(Task task) {
        boolean hasMachine = false;
        while (!hasMachine) {
            for (AddingMachine addingMachine : Utils.addingMachines) {
                if (hasMachine = addingMachine.tryBookPlace(this, task))
                    break;
            }
        }
    }

    private void goToMultiplyingMachine(Task task) {
        boolean hasMachine = false;
        while (!hasMachine) {
            for (MultiplyingMachine multiplyingMachine : Utils.multiplyingMachines) {
                if (hasMachine = multiplyingMachine.tryBookPlace(this, task))
                    break;
            }
        }
    }

    private synchronized void addResult(Task result) {
        Utils.solvedTasks.add(result);
    }

    private long getSleepTime() {
        long bound = Utils.GET_TASK_MAX_INTERVAL - Utils.GET_TASK_MIN_INTERVAL;
        return Utils.GET_TASK_MIN_INTERVAL + (long) (random.nextDouble() * bound);
    }

    public void taskSolved() {
        Task task = tryGetTask();
        solveTask(task);
    }

    public void taskNotSolved(Task task) {
        solveTask(task);
    }
}
