package threadpool;

import java.util.LinkedList;

/**
 * @Description: TODO
 * @Author MiSinG
 * @Date 2023/9/10
 * @Version V1.0
 **/
public class MyThreadPool<Job extends Runnable> implements ThreadPool<Job>{

    private static final int MAX_WORKER_NUMBERS = 10;

    private static final int DEFAULT_WORKER_NUMBERS = 5;

    private static final int MIN_WORKER_NUMBERS = 1;

    private final LinkedList<Job> jobList = new LinkedList<>();
    private final LinkedList<Thread> threadPool = new LinkedList<>();

    @Override
    public void execute(Runnable runnable) {

    }

    @Override
    public void shutdown() {

    }

    @Override
    public void addWorkerThreads(int num) {

    }

    @Override
    public void removeWorkerThreads(int num) {

    }

    @Override
    public int getJobSize() {
        return 0;
    }
}
