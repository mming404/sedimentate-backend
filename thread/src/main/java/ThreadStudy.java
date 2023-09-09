import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description: TODO
 * @Author MiSinG
 * @Date 2023/9/7
 * @Version V1.0
 **/
public class ThreadStudy {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new ThreadStudy().test();
    }
    public void test() throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(() -> "hhhh");

        task.run();

        System.out.println(task.get());

    }
}
