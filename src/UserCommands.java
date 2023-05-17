import java.util.Scanner;

public class UserCommands {
    public static void launchCommands(TaskList tasks) {
        System.out.println("Enter a command below");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.next();
        String parameter1 = scanner.next();
//        System.out.println("Command recognized as " + "'" + command + "'.");
//        System.out.println("Parameters recognized as " + "'" + parameter1 + "'.");
        switch(command) {
            case "addtask":
                if(parameter1.trim() == "") {
                    System.out.println("Enter task name to be added:");
                    parameter1 = scanner.nextLine();
                }
                userAddTask(parameter1, tasks);
                break;
                default:
                    System.out.println("Command not recognzied. For help, please type the command help.");
        }
    }
    public static void userAddTask(String taskName, TaskList tasks) {
        System.out.println("Task '" + taskName + "' added.");
        System.out.println("Please enter priority");
        Scanner scanner = new Scanner(System.in);
        String priorityInput = scanner.nextLine();
        Task.Priority priority;
        if(priorityInput.contains("h")) {
            priority = Task.Priority.HIGH;
        } else if(priorityInput.contains("m")) {
            priority = Task.Priority.MEDIUM;
        } else if(priorityInput.contains("l")) {
            priority = Task.Priority.LOW;
        } else {
            priority = Task.Priority.LOW;
            System.out.println("Priority not recognized. Set to low by default.");
        }
        tasks.addTask((new Task(taskName,priority)));
        System.out.println("Added task '" + taskName + "' with priority '" + priority + "' successfully.");
    }

}
