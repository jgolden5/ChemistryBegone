import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Task taskA = new Task("Thermochemistry worksheet",Task.Priority.HIGH);
        Task taskB = new Task("Stoichiometry quiz",Task.Priority.MEDIUM);
        Task taskC = new Task("Extra credit redox ws",Task.Priority.LOW);
        Task[] tasksArr = {taskA, taskB, taskC};

        TaskList tasks = new TaskList(tasksArr);
        tasks.read();

        Task taskD = new Task("Kahn Academy stoichiometry", Task.Priority.MEDIUM);
        tasks.addTask(taskD);
        System.out.println("");
        tasks.read();

        Task taskE = new Task("Chemistry textbook studies", Task.Priority.LOW);
        tasks.addTask(taskE);
        System.out.println("");
        tasks.read();
    }
}