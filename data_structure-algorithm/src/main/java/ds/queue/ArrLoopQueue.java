package ds.queue;

/**
 * @Description: TODO
 * @Author MiSinG
 * @Date 2023/9/2
 * @Version V1.0
 **/
public class ArrLoopQueue {

    public int[] datas;

    public int front = 0;

    public int tail = 0;

    private int size = 0;

    private int maxSize;

    public ArrLoopQueue(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("队列容量必须大于0 : " + maxSize);
        }
        this.maxSize = maxSize;
        datas = new int[maxSize];
    }

    //计算循环队列长度
    public int queueLength() {
        return (tail - front + maxSize) % maxSize;
    }

    public void add(int data) {
        if (front == (tail + 1) % maxSize) {//取模就是整合tail和front大小问题
            throw new IllegalArgumentException("队列已满");
        }
        datas[tail] = data;
        tail = (tail + 1) % maxSize;
    }

    public int remove() {
        if (queueLength() == 0) {
            throw new IllegalArgumentException("队列为空");
        }
        int target = datas[front];
        datas[front++] = Integer.parseInt(null);
        front = front % maxSize;
        return target;
    }


}
