/**
 * @Description: TODO 一个基于双重检查锁与volatile的的懒汉单例模式
 * @Author MiSinG
 * @Date 2023/9/15
 * @Version V1.0
 **/
public class Singleton {
    private static volatile Singleton instance;

    private Singleton(){}

    public static Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
