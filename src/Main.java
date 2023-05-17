import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Task taskA = new Task("Homework", Task.Priority.HIGH);
        Task taskB = new Task("Practice Quiz", Task.Priority.LOW);
        Task taskC = new Task("Study guide", Task.Priority.MEDIUM);
        Task taskD = new Task("Exam", Task.Priority.HIGH);
        Task[] tasksArr = {taskA, taskB, taskC, taskD};

        TaskList tasks = new TaskList(tasksArr);

        tasks.read();

        System.out.println();
        UserCommands.launchCommands(tasks);

        System.out.println();
        tasks.sortByPriority();
        tasks.read();
    }
}