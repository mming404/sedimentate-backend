package ds.array;

/**
 * @Description: TODO
 * @Author MiSinG
 * @Date 2023/8/1
 * @Version V1.0
 **/
public class DynamicArray {


    private int size = 0;

    private int capacity = 8;

    private int[] array = new int[capacity];

    public void addLast(int element) {
        array[size] = element;
        size++;
    }


    public void add(int index, int element) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }

        array[index] = element;
        size++;
    }


    public int remove(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

        int removed = array[index];
        for (int i = index+1; i <size; i++) {
           array[i-1] = array[i];
        }
        array[size-1] = 0;
        size--;
        return removed;
    }


    public int get(int index) {
        if (index <= size - 1 || index < 0) {
            return array[index];
        } else {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
    }

    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(9);
        dynamicArray.add(2, 7);

        System.out.println(dynamicArray.get(2));
        dynamicArray.remove(2);
        System.out.println(dynamicArray.get(2));
    }
}
