package ds.queue;

public class LinkQueue<E> {
    private QueueNode<E> head;// 队列的头。
    private QueueNode<E> tail;// 队列的尾。
    private int size;// 队列中元素的个数。

    // 往队列中添加元素。
    public void add(E val) {
        if (isEmpty()) {// 如果队列为空。
            head = new QueueNode(val, null, null);
            tail = head;
        } else {// 如果不为空就添加到末尾。
            tail = new QueueNode<>(val, tail, null);
            tail.pre.next = tail;
        }
        size++;
    }

    // 删除队列的头部元素。
    public E remove() {
        if (isEmpty())// 队列为空，没法删除。
        {
            throw new NullPointerException("队列为空");
        }
        E res = head.val;
        if (size() == 1) {// 只有一个节点，全部删除。
            head = null;
            tail = null;
        } else {// 否则删除头节点。
            QueueNode headNext = head.next;
            head.next = null;
            headNext.pre = null;
            head = headNext;
        }
        size--;
        return res;
    }

    // 获取队列头部元素。
    public E top() {
        if (isEmpty()) {
            throw new NullPointerException("队列为空");
        }
        return head.val;
    }

    // 队列中元素的个数。
    public int size() {
        return size;
    }

    // 队列是否为空。
    public boolean isEmpty() {
        return size == 0;
    }
}
