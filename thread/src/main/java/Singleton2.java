/**
 * @Description: TODO 一个基于静态内部类的的懒汉单例模式 更加常用,方便
 * @Author MiSinG
 * @Date 2023/9/15
 * @Version V1.0
 **/
public class Singleton2 {
    private static class LazyHolder{
        private static final Singleton2 SINGLETON_2 = new Singleton2();
    }

    private Singleton2(){}

    public static final Singleton2 getInstance(){
        return LazyHolder.SINGLETON_2;
    }
}
