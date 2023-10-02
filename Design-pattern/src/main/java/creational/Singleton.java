package creational;

/**
 * @Description: TODO 使用静态内部类 的线程安全的 懒汉式单例
 * @Author MiSinG
 * @Date 2023/10/2
 * @Version V1.0
 **/
public class Singleton {
    ;
    private final static class SingletonIn{
        private static Singleton instance = new Singleton();
    }

    private Singleton(){}

    public static Singleton getInstance(){
        return SingletonIn.instance;
    }
}
