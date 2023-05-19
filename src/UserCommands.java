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
                case "h":
                    help();
                    break;
                case "read":
                case "r":
                    tasks.read();
                    break;
                case "sort":
                case "s":
                    tasks.sort();
                    System.out.println("Task list sorted successfully.");
                    tasks.read();
                    break;
                case "quit":
                case "q":
                    userOnline = false;
                    break;
                    //the following commands require a parameter:
                case "add":
                case "a":
                    userParameter = scanner.nextLine().trim();
                    userAddTask(userParameter, tasks);
                    tasks.read();
                    break;
                case "find":
                case "f":
                    userParameter = scanner.nextLine().trim();
                    int desiredTaskIndex = tasks.searchByName(userParameter);
                    if(desiredTaskIndex != -1) {
                        System.out.println("Here is the task you are looking for:");
                        System.out.print("Task #" + (desiredTaskIndex + 1) + "/" + tasks.getLength() + ": ");
                        tasks.readTask(desiredTaskIndex);
                    } else {
                        System.out.println("Desired task '" + userParameter + "' not found :(");
                    }
                    break;
                case "complete":
                case "c":
                    userParameter = scanner.nextLine().trim();
                    if (userParameter.equals("all")) {
                        for(int i = 0; i < tasks.getLength(); i++) {
                            tasks.get(i).complete();
                        }
                        System.out.println("All tasks marked as completed.");
                    } else {
                        int taskFinishedIndex = tasks.searchByName(userParameter);
                        if (taskFinishedIndex != -1) {
                            Task taskFinished = tasks.get(taskFinishedIndex);
                            taskFinished.complete();
                            System.out.println("Task '" + taskFinished.taskName + "' marked as complete.");
                            tasks.sort();
                            tasks.read();
                        } else {
                            System.out.println("Task '" + userParameter + "' not found.");
                        }
                    }
                    break;
                case "uncomplete":
                case "u":
                    userParameter = scanner.nextLine().trim();
                    if (userParameter.equals("all")) {
                        for(int i = 0; i < tasks.getLength(); i++) {
                            tasks.get(i).uncomplete();
                        }
                        System.out.println("All tasks marked as not completed.");
                        tasks.read();
                    } else {
                        int taskFinishedIndex = tasks.searchByName(userParameter);
                        if (taskFinishedIndex != -1) {
                            Task taskFinished = tasks.get(taskFinishedIndex);
                            taskFinished.uncomplete();
                            System.out.println("Task '" + taskFinished.taskName + "' marked as not complete.");
                            tasks.sort();
                            tasks.read();
                        } else {
                            System.out.println("Task '" + userParameter + "' not found.");
                        }
                        break;
                    }
                case "delete":
                case "d":
                    userParameter = scanner.nextLine().trim();
                    int desiredIndexOfTaskToDelete = tasks.searchByName(userParameter);
                    tasks.deleteTask(userParameter);
                    if(desiredIndexOfTaskToDelete != -1) {
                        System.out.println("Task '" + userParameter + "' deleted successfully.");
                        tasks.read();
                    } else {
                        System.out.println("Desired task '" + userParameter + "' not found :(");
                    }
                    break;
                default:
                    System.out.println("Command not recognized. For help, please type the command h or help.");
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
