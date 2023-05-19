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
            String userParameter = "";
            switch (command) {
                case "help":
                    help();
                    break;
                case "read":
                    tasks.read();
                    break;
                case "sort":
                    tasks.sort();
                    System.out.println("Task list sorted successsfully.");
                    tasks.read();
                    break;
                case "quit":
                    userOnline = false;
                    break;
                    //the following commands require a parameter:
                case "add":
                    userParameter = scanner.nextLine().trim();
                    userAddTask(userParameter, tasks);
                    break;
                case "find":
                    userParameter = scanner.nextLine().trim();
                    int desiredTaskIndex = tasks.searchByName(userParameter);
                    if(desiredTaskIndex != -1) {
                        System.out.println("Here is the task you are looking for:");
                        System.out.print("Task #" + (desiredTaskIndex + 1) + "/" + tasks.getLength() + ": ");
                        tasks.readTask(desiredTaskIndex);
                    }
                    break;
                case "finish":
                    userParameter = scanner.nextLine().trim();
                    int taskFinishedIndex = tasks.searchByName(userParameter);
                    if(taskFinishedIndex != -1) {
                        Task taskFinished = tasks.get(taskFinishedIndex);
                        taskFinished.finish();
                        System.out.println("Task '" + taskFinished.taskName + "' marked as complete.");
                        tasks.sort();
                        tasks.read();
                    }
                    break;
                default:
                    System.out.println("Command not recognized. For help, please type the command help.");
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

}
