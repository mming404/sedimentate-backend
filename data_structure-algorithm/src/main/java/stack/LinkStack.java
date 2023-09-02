package stack;

import linkedlist.SinglyLinkNode;

import java.util.EmptyStackException;

/**
 * @Description: TODO
 * @Author MiSinG
 * @Date 2023/9/2
 * @Version V1.0
 **/
public class LinkStack {


    private SinglyLinkNode top;

    public void push(int data){
        top  = new SinglyLinkNode(data,top);
    }

    public int pop(){
        if (top == null){
            throw new EmptyStackException();
        }
        SinglyLinkNode topNode = top;
        if (topNode.next != null){
            top = topNode.next;
        }
        topNode.next = null;
        return topNode.data;
    }
}
