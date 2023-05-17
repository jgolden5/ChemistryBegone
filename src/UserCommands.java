import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserCommands {
    public static void launchCommands(TaskList tasks) {
        boolean userOnline = true;

        while(userOnline) {
            System.out.println("Enter a command below");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.next();
//        System.out.println("Command recognized as " + "'" + command + "'.");
//        System.out.println("Parameters recognized as " + "'" + parameter1 + "'.");
            switch (command) {
                case "add":
                    System.out.println("Enter task name to be added:");
                    String parameter = scanner.nextLine().trim();
                    userAddTask(parameter, tasks);
                    break;
                case "help":
                    help();
                    break;
                case "show":
                    show(tasks);
                    break;
                case "quit":
                    userOnline = false;
                    break;
                default:
                    System.out.println("Command not recognzied. For help, please type the command help.");
            }
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
        tasks.add((new Task(taskName,priority)));
        System.out.println("Added task '" + taskName + "' with priority '" + priority + "' successfully.");
    }

    public static void help() {
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("/Users/jgolden1/IdeaProjects/ChemistryBegone/src/UserCommandHelp")
            );
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void show(TaskList tasks) {
        tasks.read();
    }

}
