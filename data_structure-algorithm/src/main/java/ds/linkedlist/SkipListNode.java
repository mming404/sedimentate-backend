package ds.linkedlist;

/**
 * @Description: TODO  跳表节点类
 * @Author MiSinG
 * @Date 2023/9/2
 * @Version V1.0
 **/
public class SkipListNode {
    public int data;

    //后一个节点
    public SkipListNode next;

    //下一个节点
    public SkipListNode down;

    public SkipListNode(int data, SkipListNode next) {
        this.data = data;
        this.next = next;
    }
}
