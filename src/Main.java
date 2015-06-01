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
        for (int i = 0; i < Settings.ADDING_MACHINES_COUNT; i++)
            Settings.addingMachines.add(new AddingMachine());

        for (int i = 0; i < Settings.MULTIPLYING_MACHINES_COUNT; i++)
            Settings.multiplyingMachines.add(new MultiplyingMachine());
        Chief chief = new Chief("Chief");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Jan"));
        employeeList.add(new Employee("Adam"));
        employeeList.add(new Employee("Staś"));

        Customer customer = new Customer();

        chief.start();
        for(Employee e : employeeList)
            e.start();
        customer.start();

        if (Settings.TRYB == Settings.SPOKOJNY)
            launchScanner();
    }

    private static void launchScanner(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            String command = scanner.nextLine();
            switch (command){
                case "task_count":
                    System.out.println(Settings.taskList.size());
                    break;
                case "solved_count":
                    System.out.println(Settings.solvedTasks.size());
                    break;
                case "gadatliwy_on":
                    Settings.TRYB = Settings.GADATLIWY;
                    break;
                case "gadatliwy_off":
                    Settings.TRYB = Settings.SPOKOJNY;
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
