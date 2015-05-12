import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * author:  Adrian Kuta
 * indeks:  204423
 * date:    2015-04-08
 * email:   redione193 @ gmail.com
 */
public class Main {

    public static void main(String[] args) {
        // write your code here
        Chief chief = new Chief();

        List<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < Utils.EMPLOYEE_NUMER; i++)
            employeeList.add(new Employee());

        Customer customer = new Customer();

        chief.start();
        for(Employee e : employeeList)
            e.start();
        customer.start();

        if(Utils.TRYB == Utils.SPOKOJNY)
            launchScanner();
    }

    private static void launchScanner(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            String command = scanner.nextLine();
            switch (command){
                case "task_count":
                    System.out.println(Utils.taskList.size());
                    break;
                case "solved_count":
                    System.out.println(Utils.solvedTasks.size());
                    break;
                case "gadatliwy_on":
                    Utils.TRYB = Utils.GADATLIWY;
                    break;
                case "gadatliwy_off":
                    Utils.TRYB = Utils.SPOKOJNY;
                    break;
                case "stop":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong command!");
                    System.out.println("Available commands:");
                    System.out.println("task_count");
                    System.out.println("solved_count");
                    System.out.println("gadatliwy_on");
                    System.out.println("gadatliwy_off");
                    System.out.println("stop");
            }
        }
    }
}
