import java.util.Random;

/**
 * author:  Adrian Kuta
 * indeks:  204423
 * date:    2015-04-08
 * email:   redione193 @ gmail.com
 */
public class Employee extends Thread implements Machine.CommunicationInterface {

    private Random random;
    private String name;
    private Machine machine;
    private Task task = null;

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
        getTask();
    }

    private void getTask() {
        machine = null;
        task = null;
        while (task == null) {
            try {
                sleep(getSleepTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            task = tryGetTask();
        }
        if (Settings.TRYB == Settings.GADATLIWY)
            System.out.println("Employee " + name + " get task: " + task.arg1 + task.operator + task.arg2);
        solveTask(task);
    }

    private synchronized Task tryGetTask() {
        if (Settings.taskList.size() != 0)
            return Settings.taskList.remove(0);
        return null;
    }

    private void solveTask(Task task) {
        if (task.operator == '+')
            goToAddingMachine();
        else
            goToMultiplyingMachine();
    }

    private void goToMultiplyingMachine() {
        if (Settings.TRYB == Settings.GADATLIWY)
            System.out.println("Employee " + name + " searching Multiplying Machine");
        while (machine == null)
            for (int i = 0; machine == null && i < Settings.MULTIPLYING_MACHINES_COUNT; i++) {
                machine = Settings.multiplyingMachines.get(i).tryBookMachine(this);
            }
    }

    private void goToAddingMachine() {
        if (Settings.TRYB == Settings.GADATLIWY)
            System.out.println("Employee " + name + " searching Adding Machine");
        while (machine == null)
            for (int i = 0; machine == null && i < Settings.ADDING_MACHINES_COUNT; i++) {
                machine = Settings.addingMachines.get(i).tryBookMachine(this);
            }
    }

    private synchronized void addResult(Task task) {
        Settings.solvedTasks.add(task);
    }

    private long getSleepTime() {
        long bound = Settings.GET_TASK_MAX_INTERVAL - Settings.GET_TASK_MIN_INTERVAL;
        return Settings.GET_TASK_MIN_INTERVAL + (long) (random.nextDouble() * bound);
    }

    @Override
    public void startSolvingTask() {
        if (Settings.TRYB == Settings.GADATLIWY)
            System.out.println("Employee " + name + " started solving task");
        try {
            sleep(Settings.SOLVING_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Task solvedTask = machine.solveTask(task);
        if (solvedTask != null) {
            task = solvedTask;
            addResult(task);
            ((CommunicationInterface) machine).onTaskSolved();
        } else {
            machineDestroyed();
        }
        getTask();

    }

    public boolean canHelp() {
        if (machine == null)
            return true;
        else
            return !machine.solvingInProgress;
    }

    public void help(Machine machine) {

    }

    private void callForHelp() {
    }

    @Override
    public void machineDestroyed() {
        if (Settings.TRYB == Settings.GADATLIWY)
            System.out.println("Employee " + name + "leaved broken machine");
        leaveTask();
        getTask();
    }

    private synchronized void leaveTask() {
        Settings.taskList.add(task);
    }

    @Override
    public String toString() {
        return name != null ? name : "";
    }

    public interface CommunicationInterface {
        void onTaskSolved();
    }
}
