package threadpool;

/**
 * @Description: TODO
 * @Author MiSinG
 * @Date 2023/9/10
 * @Version V1.0
 **/
public interface ThreadPool<Job extends Runnable> {
    //执行任务
    void execute(Job job);

    //关闭线程池
    void shutdown();

    //增加工作线程
    void addWorkerThreads(int num);

    //减少工作线程
    void removeWorkerThreads(int num);

    int getJobSize();
}
