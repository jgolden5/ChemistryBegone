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

    public void readTask(int index) {
        Task currentTask = tasks[index];
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

    public int getLength() {
        return tasks.length;
    }
    public void read() {
        System.out.println();
        if (tasks.length == 0) {
            System.out.println("No tasks to show");
        } else {
            for (int i = 0; i < tasks.length; i++) {
                readTask(i);
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


    public void swapTasksByIndex(int index1, int index2) {
        Task temp = tasks[index1];
        tasks[index1] = tasks[index2];
        tasks[index2] = temp;
    }

    public void sortByPriority() {
        for(int i = 0; i < tasks.length - 1; i++) {
            for(int j = i + 1; j < tasks.length; j++) {
                if(tasks[i].priority == Task.Priority.MEDIUM) {
                    if (tasks[j].priority == Task.Priority.HIGH) {
                        swapTasksByIndex(i, j);
                    }
                } else if(tasks[i].priority == Task.Priority.LOW && tasks[j].priority != Task.Priority.LOW) {
                    swapTasksByIndex(i, j);
                }
            }
        }
    }

    public void sortByCompletion() {
        for(int i = 0; i < tasks.length - 1; i++) {
            for(int j = i + 1; j < tasks.length; j++) {
                if(tasks[i].completed && !tasks[j].completed) {
                    swapTasksByIndex(i, j);
                }
            }
        }
    }

    public void sort() {
        sortByPriority();
        sortByCompletion();
    }

    public int searchByName(String desiredTaskName) {
        int desiredTaskIndex = -1;
        for(int i = 0; i < tasks.length; i++) {
            if(tasks[i].taskName.equals(desiredTaskName)) {
                desiredTaskIndex = i;
                break;
            }
        }
        if (desiredTaskIndex == -1) {
            System.out.println("Desired task '" + desiredTaskName + "' not found :(");
        }
        return desiredTaskIndex;
    }

}
