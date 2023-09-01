package linkedlist;

import org.yaml.snakeyaml.events.Event;

/**
 * @Description: TODO
 * @Author MiSinG
 * @Date 2023/9/1
 * @Version V1.0
 **/
public class SinglyLinkedList {
    private SinglyLinkNode head;// 头节点。
    private SinglyLinkNode tail;// 尾节点。
    private int size;// 链表的长度。

    //尾部添加
    public void add(int data) {
        insert(size, data);
    }

    //删除头节点
    public int poll() {
        return remove(0);
    }

    //插入节点
    public void insert(int index, int data) {
        //如果是头节点
        if (index == 0) {
            head = new SinglyLinkNode(data, head);
            if (size == 0) {
                tail = head;
            }
        } else if (index == size) {//在末尾加
            tail.next = new SinglyLinkNode(data, null);
            tail = tail.next;
        } else {//在中间加
            //找出前一个节点
            SinglyLinkNode linkNode = findPre(index);
            //将前一个节点的next给新节点的next 同时前一个节点的next指向新节点
            linkNode.next = new SinglyLinkNode(data, linkNode.next);
        }
        size++;
    }

    public int remove(int index) {
        SinglyLinkNode delete = null;
        if (size == 0) {
            throw new IllegalStateException("链表为空");
        }
        //删头部节点
        if (index == 0) {
            head = head.next;
            if (head == null) {// 如果链表为空，让 tail 也为空。
                tail = null;
            }
        } else {// 删除的不是头节点。
            SinglyLinkNode preNode = findPre(index);// 查找删除节点的前一个节点。
            if (index == size - 1) {// 删除的是尾节点。
                delete = preNode.next;
                preNode.next = null;// 删除尾节点。
                tail = preNode;// 更新尾节点。
            } else {// 删除的是中间节点。
                delete = preNode.next;
                preNode.next = delete.next;// 删除节点。
            }
        }
        size --;
        return delete.data;
    }

    /**
     * 查找index前一个节点  单向链表只能从前往后遍历 所以只能拿前一个节点
     */
    SinglyLinkNode findPre(int index) {
        // index 必须是有效的，不能越界。查找前一个，index可以等于size。
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("越界了……");
        }
        if (index == 0)// 头节点的前一个是空节点。
        {
            return null;
        }
        SinglyLinkNode preNode = head;
        for (int i = 0; i < index - 1; i++) {
            preNode = preNode.next;
        }
        return preNode;
    }

    // 节点的个数。
    public int size() {
        return size;
    }

    // 清空链表。
    public void clear() {
        while (head != null) {
            SinglyLinkNode next = head.next;
            head.next = head;// 自己指向自己。
            head = next;
        }
        tail = null;
        size = 0;
    }
}
