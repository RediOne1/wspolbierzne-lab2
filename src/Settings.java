import java.util.ArrayList;
import java.util.List;

/**
 * author:  Adrian Kuta
 * indeks:  204423
 * date:    2015-04-08
 * email:   redione193 @ gmail.com
 */
public class Settings {

    public static final int GADATLIWY = 1;
    public static final int SPOKOJNY = 2;
    //Machine settings
    public static final long SOLVING_TIME = 1000;
    public static final float BREAK_PROBABILITY = 0f;
    public static final int ADDING_MACHINES_COUNT = 2;
    public static final int MULTIPLYING_MACHINES_COUNT = 2;
    //Chief settings
    public static final long ADD_TASK_MIN_INTERVAL = 1000;
    public static final long ADD_TASK_MAX_INTERVAL = 5000;
    //Employee settings
    public static final int EMPLOYEE_NUMER = 2;
    public static final long GET_TASK_MIN_INTERVAL = 1000;
    public static final long GET_TASK_MAX_INTERVAL = 10000;
    //Customer interval
    public static final long CUSTOMER_MIN_INTERVAL = 1000;
    public static final long CUSTOMER_MAX_INTERVAL = 10000;
    public static int TRYB = GADATLIWY;
    public static char operators[] = {'+', '*'};
    public static List<Task> taskList = new ArrayList<>();
    public static List<Task> solvedTasks = new ArrayList<>();
    public static List<AddingMachine> addingMachines = new ArrayList<>();
    public static List<MultiplyingMachine> multiplyingMachines = new ArrayList<>();
}