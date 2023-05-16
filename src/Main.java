public class Main {
    public static void main(String[] args) {
        Task thermoHW = new Task("Thermochemistry worksheet",Task.Priority.HIGH);
        System.out.println("Current task completed? = " + thermoHW.completed);
        thermoHW.finish();
        System.out.println("Current task completed? = " + thermoHW.completed);
    }
}