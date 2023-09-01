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
    public void add(int data){
        insert(size,data);
    }

    //删除头节点
//    public int poll(){
//
//    }

    //插入节点
    public void insert(int index,int data){
        //如果是头节点
        if (index == 0){
            head  = new SinglyLinkNode(data,head);
            if (size == 0){
                tail = head;
            }
        }else if (index == size){//在末尾加
            tail.next= new SinglyLinkNode(data,null);
            tail = tail.next;
        }else {//在中间加
            //找出前一个节点
            SinglyLinkNode linkNode = findPre(index);
            //将前一个节点的next给新节点的next 同时前一个节点的next指向新节点
            linkNode.next = new SinglyLinkNode(data,linkNode.next);
        }
        size++;
    }

    /**
     * 查找index前一个节点
     */
    SinglyLinkNode findPre(int index){
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

    /**
     * 查找index后一个节点
     */
    SinglyLinkNode findNext(int index){
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
}
