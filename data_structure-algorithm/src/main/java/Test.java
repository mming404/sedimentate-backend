import ds.linkedlist.DoubleLinkedList;

/**
 * @Description: TODO
 * @Author MiSinG
 * @Date 2023/7/27
 * @Version V1.0
 **/
public class Test {

    public static void main(String[] args) {
//        System.out.println("hello world!!");
//        SinglyLinkedList linkedList = new SinglyLinkedList();
//        linkedList.add(1);
//        linkedList.add(2);
//        linkedList.add(3);
//        linkedList.insert(1,8);
//        linkedList.remove(1);
//        System.out.println(linkedList.size());

        DoubleLinkedList linkedList = new DoubleLinkedList();
        linkedList.addEnd(1);
        linkedList.addEnd(2);
        linkedList.addEnd(3);
        linkedList.addEnd(4);
        linkedList.addHead(0);
        System.out.println(linkedList.findNode(3).data);

    }

}
