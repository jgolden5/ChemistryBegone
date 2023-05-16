import java.util.ArrayList;

public class TaskList {
    ArrayList<Task> tasks;

    TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void read() {
        System.out.println("To do: ");
        for(int i = 0; i < tasks.size(); i++) {
            Task currentTask = tasks.get(i);
            System.out.println("Task name: " + currentTask.taskName + ", " +
                    "Priority level: " + currentTask.priority + ".");
        }
    }

}
