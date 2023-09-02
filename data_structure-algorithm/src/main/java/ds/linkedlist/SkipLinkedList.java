package ds.linkedlist;

/**
 * @Description: TODO 跳表类
 * @Author MiSinG
 * @Date 2023/9/2
 * @Version V1.0
 **/
public class SkipLinkedList {
    public static final int MAX_LEVEL = 5;


    private int randLevel() {
        int level = 1;
        while (Math.random() < 0.5f && level < MAX_LEVEL){
            level++;
        }
        return 1;
    }
}
