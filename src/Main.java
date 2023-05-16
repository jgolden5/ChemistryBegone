import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Task taskA = new Task("Homework",Task.Priority.HIGH);
        Task taskB = new Task("Practice Quiz",Task.Priority.LOW);
        Task taskC = new Task("Study guide",Task.Priority.MEDIUM);
        Task taskD = new Task("Exam",Task.Priority.HIGH);
        Task[] tasksArr = {taskA, taskB, taskC, taskD};

        TaskList tasks = new TaskList(tasksArr);

        System.out.println("Unsorted");
        tasks.read();
        System.out.println("");

        tasks.sortByPriority();
        System.out.println("Sorted by priority");
        tasks.read();
    }
}