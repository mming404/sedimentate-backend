package ds.linkedlist;

import java.util.NoSuchElementException;

/**
 * @Description: TODO
 * @Author MiSinG
 * @Date 2023/9/2
 * @Version V1.0
 **/
public class DoubleLinkedList {
    private DoubleLinkNode head;// 头节点。
    private DoubleLinkNode tail;// 尾节点。
    private int size;// 链表的长度。


    /**
     * 在尾部添加节点
     * @param data
     */
    public void addEnd(int data){
        DoubleLinkNode end  = tail;
        DoubleLinkNode linkNode = new DoubleLinkNode(data, end, null);
        tail = linkNode;
        if (end == null){//原链表为空
            head = linkNode;
        }else {
            end.next = linkNode;
        }
        size++;
    }


    /**
     * 在头部添加节点
     * @param data
     */
    public void addHead(int data){
        DoubleLinkNode oldHead = head;
        DoubleLinkNode linkNode = new DoubleLinkNode(data, null, oldHead);
        head = linkNode;

        if (oldHead == null){//原链表为空
            tail = linkNode;
        }else {
            oldHead.pre = linkNode;
        }
        size++;
    }


    //查找指定下标的节点
    public DoubleLinkNode findNode(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalStateException("越界..");
        }
        //哪边找快一点
        if (index < (size / 2)) {
            DoubleLinkNode x = head;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            DoubleLinkNode x = tail;
            for (int i = size-1; i > index; i--) {
                x = x.pre;
            }
            return x;
        }
    }


    /**
     * 在node节点前插入一个新节点
     *
     * @param data
     * @param node
     */
    public void addBefore(int data, DoubleLinkNode node) {
        DoubleLinkNode pre = node.pre;
        DoubleLinkNode linkNode = new DoubleLinkNode(data, pre, node);
        node.pre = linkNode;
        if (pre == null)// 在头节点之前插入。
        {
            head = linkNode;
        } else {
            pre.next = linkNode;
        }
        size++;
    }


    public int remove(DoubleLinkNode x) {
        DoubleLinkNode pre = x.pre;
        DoubleLinkNode next = x.next;


        if (pre == null) {//是否是头节点
            head = next;
        } else {
            pre.next = next;
            x.pre = null;
        }

        //是否是尾节点
        if (next == null) {
            tail = pre;
        } else {
            next.pre = pre;
            x.next = null;
        }
        size--;

        return x.data;
    }

    // 获取头部节点值。
    public int getFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    // 获取尾部节点值。
    public int getLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        return tail.data;
    }

}
