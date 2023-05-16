import java.util.ArrayList;

public class TaskList {
    Task[] tasks;

    TaskList(Task[] tasks) {
        this.tasks = tasks;
    }

    public void read() {
        System.out.println("To do: ");
        for(int i = 0; i < tasks.length; i++) {
            Task currentTask = tasks[i];
            System.out.println("Task name: " + currentTask.taskName + ", " +
                    "Priority level: " + currentTask.priority + ".");
        }
    }

//    public void sort() {
//        for(int i = 0; i < tasks.length; i++) {
//            Task currentTask = tasks[i];
//        }
//    }

}
