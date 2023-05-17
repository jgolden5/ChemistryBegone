import java.util.ArrayList;

public class TaskList {
    Task[] tasks;

    TaskList(Task[] tasks) {
        this.tasks = tasks;
    }

    public Task get(int index) {
        return tasks[index];
    }

    public void replaceTask(int index, Task taskToReplace) {
        tasks[index] = taskToReplace;
    }

    public void read() {
        System.out.println();
        if (tasks.length == 0) {
            System.out.println("No tasks to show");
        } else {
            for (int i = 0; i < tasks.length; i++) {
                Task currentTask = tasks[i];
                String checkboxEmoji;
                if (currentTask.completed) {
                    checkboxEmoji = "✅";
                } else {
                    switch (currentTask.priority) {
                        case HIGH:
                            checkboxEmoji = "🟥";
                            break;
                        case MEDIUM:
                            checkboxEmoji = "🟨";
                            break;
                        case LOW:
                            checkboxEmoji = "🟦";
                            break;
                        default:
                            checkboxEmoji = "";
                    }
                }

                System.out.println(checkboxEmoji + " " + currentTask.taskName + ". " +
                        "Priority level: " + currentTask.priority + ".");
            }
        }
        System.out.println();
    }

    public void add(Task newTask) {
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
