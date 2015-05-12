import java.util.Random;

/**
 * author:  Adrian
 * index:   204423
 * data:    2015-05-12
 */
public class AddingMachine extends Machine{

    @Override
    public void startSolving() {
        try {
            sleep(Utils.SOLVING_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        float randomFloat = new Random().nextFloat();
        if(randomFloat < Utils.BREAK_PROBABILITY)
            working = false;
    }
}
