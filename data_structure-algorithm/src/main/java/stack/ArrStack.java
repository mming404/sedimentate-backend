package stack;


/**
 * @Description: TODO
 * @Author MiSinG
 * @Date 2023/9/2
 * @Version V1.0
 **/
public class ArrStack {

    private int[] datas;

    private int maxSize;

    private int top = -1;

    public ArrStack(int maxSize) {

        if (maxSize<=0){
            throw new IllegalArgumentException("容量必须大于0");
        }
        this.maxSize = maxSize;
        datas = new int[maxSize];
    }

    public void push(int data){
        if (top == maxSize -1){
            throw new IllegalArgumentException("栈已满");
        }
        datas[++top] = data;
    }


    public int pop(){
        if (top<0){
            throw new IllegalArgumentException("栈已空");
        }
        int data = datas[top];
        datas[top--] = Integer.parseInt(null);
        return data;
    }


}
