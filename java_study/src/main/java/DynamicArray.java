import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicArray {
    public static void main(String[] args) {
        List list = new ArrayList();
    }

//    初始容量
    private static final int DEFAULT_CAPACITY = 10;
//    数据存储(不可序列化的数组)
    private transient Object[] elementData;
//    当前容量
    private int size;

//    private void grow(int minCapacity) {
////        原数组长度
//        int oldCapacityp = elementData.length;
////        长度加1.5倍
//        int newCapacity = oldCapacityp + (oldCapacityp >> 1);
////        如果长度扩展后小于当前所需容量则取当前所需容量
//        if (newCapacity - minCapacity < 0)
//            newCapacity = minCapacity;
//        if (newCapacity - MAX_ARRAY_SIZE > 0)
//            newCapacity = hugeCapacity(minCapacity);
//        elementData = Arrays.copyOf(elementData, newCapacity);
//
//
//    }

}
