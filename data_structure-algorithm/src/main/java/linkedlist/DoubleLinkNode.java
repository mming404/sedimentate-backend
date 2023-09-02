package linkedlist;

/**
 * @Description: TODO
 * @Author MiSinG
 * @Date 2023/9/2
 * @Version V1.0
 **/
public class DoubleLinkNode {

    public int data;
    public DoubleLinkNode pre;

    public DoubleLinkNode next;

    public DoubleLinkNode(int data, DoubleLinkNode pre, DoubleLinkNode next) {
        this.data = data;
        this.pre = pre;
        this.next = next;
    }
}
