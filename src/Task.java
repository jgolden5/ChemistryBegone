public class Task {
    enum Priority {
        LOW,
        MEDIUM,
        HIGH
    }
    String taskName;
    Priority priority;
    boolean completed = false;

    Task(String taskName, Priority priority) {
        this.taskName = taskName;
        this.priority = priority;
    }
}
