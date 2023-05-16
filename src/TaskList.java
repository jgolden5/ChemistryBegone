import java.util.ArrayList;

public class TaskList {
    Task[] tasks;

    TaskList(Task[] tasks) {
        this.tasks = tasks;
    }

    public void read() {
//        System.out.println("To do: ");
        for(int i = 0; i < tasks.length; i++) {
            Task currentTask = tasks[i];
            System.out.println("Task name: " + currentTask.taskName + ", " +
                    "Priority level: " + currentTask.priority + ".");
        }
    }

    public void addTask(Task newTask) {
        Task[] newTaskArray = new Task[tasks.length + 1];
        for(int i = 0; i < tasks.length + 1; i++) {
            if(i == tasks.length) {
                newTaskArray[i] = newTask;
            } else {
                newTaskArray[i] = tasks[i];
            }
        }
        this.tasks = newTaskArray;
    }

    public void sortByPriority() {
        for(int i = 0; i < tasks.length - 1; i++) {
            for(int j = i + 1; j < tasks.length; j++) {
                switch(tasks[i].priority) {
                    case HIGH:
                        break;
                    case MEDIUM:
                        if(tasks[j].priority == Task.Priority.HIGH) {
                            Task temp = tasks[i];
                            tasks[i] = tasks[j];
                            tasks[j] = temp;
                        }
                        break;
                    case LOW:
                        if(tasks[j].priority != Task.Priority.LOW) {
                            Task temp = tasks[i];
                            tasks[i] = tasks[j];
                            tasks[j] = temp;
                        }
                        break;
                }
            }
        }
    }
}