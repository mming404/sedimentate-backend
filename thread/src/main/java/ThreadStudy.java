import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Description: TODO
 * @Author MiSinG
 * @Date 2023/9/7
 * @Version V1.0
 **/
public class ThreadStudy {
    public void test(){
        FutureTask<String> task = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hhhh";
            }
        });
    }
}
