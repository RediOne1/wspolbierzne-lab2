import java.util.Random;

/**
 * authot:  Adrian Kuta
 * index:   204423
 * date:    01.06.15
 */
public abstract class Machine {

    public Employee employee1 = null, employee2 = null;
    public boolean solvingInProgress;
    private boolean destroyed = false;

    public Machine tryBookMachine(Employee employee) {
        if (destroyed)
            return null;
        if (employee1 == null) {
            employee1 = employee;
            if (Settings.TRYB == Settings.GADATLIWY)
                System.out.println("Employee " + employee1 + " pressed first button");
            return this;
        } else if (employee2 == null) {
            employee2 = employee;
            if (Settings.TRYB == Settings.GADATLIWY)
                System.out.println("Employee " + employee2 + " pressed second button");
            solvingInProgress = true;
            ((CommunicationInterface) employee1).startSolvingTask();
            return this;
        } else
            return null;
    }

    public boolean checkDestroy() {
        Random random = new Random();
        float randFloat = random.nextFloat();
        if (randFloat < Settings.BREAK_PROBABILITY) {
            if (Settings.TRYB == Settings.GADATLIWY)
                System.out.println("Machine destroyed");
            ((CommunicationInterface) employee2).machineDestroyed();
            return true;
        }
        return false;
    }

    public abstract Task solveTask(Task task);

    public interface CommunicationInterface {
        void startSolvingTask();

        void machineDestroyed();
    }
}
