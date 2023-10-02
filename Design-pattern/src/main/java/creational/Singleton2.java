package creational;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description: TODO 基于CAS实现的单例模式
 * @Author MiSinG
 * @Date 2023/10/2
 * @Version V1.0
 **/
public class Singleton2 {
    private static final AtomicReference<Singleton2> INSTANCE = new AtomicReference<>();

    private static Singleton2 singleton2;

    private Singleton2(){}

    public final static Singleton2 getInstance(){
        for (;;){
            Singleton2 singleton = INSTANCE.get();
            if (singleton != null) return singleton;
            INSTANCE.compareAndSet(null,new Singleton2());
            return INSTANCE.get();
        }
    }
}
