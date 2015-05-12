import java.util.Random;

/**
 * author:  Adrian Kuta
 * indeks:  204423
 * date:    2015-04-08
 * email:   redione193 @ gmail.com
 */
public class Customer extends Thread {

    private String name;
    private Random random;

    public Customer() {
        name = "";
        random = new Random();
    }

    public Customer(String name) {
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
            String solvedTask = tryGetSolvedTask();
            if (solvedTask != null && Utils.TRYB == Utils.GADATLIWY)
                System.out.println("Customer received task: " + solvedTask);
        }
    }

    private synchronized String tryGetSolvedTask() {
        if (Utils.solvedTasks.size() != 0)
            return Utils.solvedTasks.remove(0).toString();
        return null;
    }

    private long getSleepTime() {
        long bound = Utils.CUSTOMER_MAX_INTERVAL - Utils.CUSTOMER_MIN_INTERVAL;
        return Utils.CUSTOMER_MIN_INTERVAL + (long) (random.nextDouble() * bound);
    }
}
