import java.util.List;

public class MultiExecutor {

    List<Runnable> threads;

    public MultiExecutor(List<Runnable> tasks) {
        this.threads = tasks;
    }


    public void executeAll() {
        threads.forEach(Runnable::run);
    }
}