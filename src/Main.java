public class Main {
    public static void main(String[] args) {
        Task thermoHW = new Task("Thermochemistry worksheet",Task.Priority.HIGH);
        System.out.println("Current task name = " + thermoHW.taskName);
    }
}