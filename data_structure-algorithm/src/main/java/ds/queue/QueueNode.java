package ds.queue;

/**
 * @Description: TODO
 * @Author MiSinG
 * @Date 2023/9/2
 * @Version V1.0
 **/
class QueueNode<E> {
    E val;// 节点值。
    QueueNode pre;// 指向前一个节点。
    QueueNode next;// 指向后一个节点。

    public QueueNode(E val, QueueNode pre, QueueNode next) {
        this.val = val;
        this.pre = pre;
        this.next = next;
    }
}

