import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Task thermoHW = new Task("Thermochemistry worksheet",Task.Priority.HIGH);
        Task stoichiometryQuiz = new Task("Stoichiometry quiz",Task.Priority.MEDIUM);
        Task extraCreditWorksheet = new Task("Extra credit redox ws",Task.Priority.LOW);
        Task[] tasksArr = {thermoHW, stoichiometryQuiz, extraCreditWorksheet};

        TaskList tasks = new TaskList(tasksArr);
        tasks.read();
    }
}