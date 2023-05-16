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

//    public void sortByPriority() {
//        for(int i = 0; i < tasks.length - 1; i++) {
//            for(int j = i + 1; j < tasks.length; j++) {
//                private static void swap(Task.Priority a, Task.Priority b) {
//                    if;
//                }
//                Task.Priority priorityA = tasks[i].priority;
//                Task.Priority priorityB = tasks[j].priority;
//                switch(priorityA) {
//                    case HIGH:
//                        if (priorityB == Task.Priority.MEDIUM) {
//                            swap(priorityA, priorityB);
//                        }
//                }
//            }
//        }
//    }

}
