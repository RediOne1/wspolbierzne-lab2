import java.util.Random;

/**
 * author:  Adrian Kuta
 * indeks:  204423
 * date:    2015-04-08
 * email:   redione193 @ gmail.com
 */
public class Chief extends Thread {

    private Random random;
    private String name;

    public Chief(){
        name = "";
        random = new Random();
    }

    public Chief(String name) {
        this.name = name;
        random = new Random();
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            try {
                sleep(getSleepTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Task task = new Task();
            task.arg1 = random.nextInt(1024);
            task.arg2 = random.nextInt(1024);
            int operator = random.nextInt(Utils.operators.length);
            task.operator = Utils.operators[operator];
            addTask(task);
        }
    }

    private synchronized void addTask(Task task) {
        Utils.taskList.add(task);
        if (Utils.TRYB == Utils.GADATLIWY)
            System.out.println(name + " Add task: " + task.arg1 + task.operator + task.arg2);
    }

    private long getSleepTime() {
        long bound = Utils.ADD_TASK_MAX_INTERVAL - Utils.ADD_TASK_MIN_INTERVAL;
        return Utils.ADD_TASK_MIN_INTERVAL + (long) (random.nextDouble() * bound);
    }
}
