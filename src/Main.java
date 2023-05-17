import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Task taskA = new Task("hw", Task.Priority.HIGH);
        Task taskB = new Task("quiz", Task.Priority.LOW);
        Task taskC = new Task("study guide", Task.Priority.MEDIUM);
        Task taskD = new Task("exam", Task.Priority.HIGH);
        Task[] tasksArr = {taskA, taskB, taskC, taskD};
//        Task[] tasksArr = {};

        TaskList tasks = new TaskList(tasksArr);

        UserCommands.launchCommands(tasks);
    }
}