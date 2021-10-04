package chapter04.exercise;

public class Exercise01 {
    public static void main(String[] args) {
        int value = 1000;
        int limit = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            int curLimit = (int) (Math.random() * limit) + 1;
            MyHeap my = new MyHeap(curLimit);
            HeapVerifier test = new HeapVerifier(curLimit);
            int curOpTimes = (int) (Math.random() * limit);
            for (int j = 0; j < curOpTimes; j++) {
                if (my.isEmpty() != test.isEmpty()) {
                    System.out.println("isEmpty() failed, Oops!");
                }
                if (my.isFull() != test.isFull()) {
                    System.out.println("isFull() failed Oops!");
                }
                if (my.isEmpty()) {
                    int curValue = (int) (Math.random() * value);
                    my.insert(curValue);
                    test.push(curValue);
                } else if (my.isFull()) {
                    if (my.delMax() != test.pop()) {
                        System.out.println("dexMax() 1 failed Oops!");
                    }
                } else {
                    if (Math.random() < 0.5) {
                        int curValue = (int) (Math.random() * value);
                        my.insert(curValue);
                        test.push(curValue);
                    } else {
                        int delMax = my.delMax();
                        int pop = test.pop();
                        if (delMax != pop) {
                            System.out.println("dexMax() 2 failed Oops! delMax=" + delMax + " pop= " + pop);
                        }
                    }
                }
            }
        }
        System.out.println("finish!");
    }


}

class MyHeap {

    private int[] arr;
    private int heapSize;
    private int defaultCapacity;

    public MyHeap(int defaultCapacity) {
        this.arr = new int[defaultCapacity];
        this.defaultCapacity = defaultCapacity;
        this.heapSize = 0;
    }

    public boolean isFull(){
        return heapSize == defaultCapacity;
    }

    public boolean isEmpty(){return heapSize == 0;}

    private void swim(int index){
        while(arr[index] > arr[(index - 1) / 2]){
            swap(arr,index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void sink(int index){
        int left = 2 * index + 1;
        while (left < heapSize) {
            int largestIndex = left + 1 < heapSize && (arr[left + 1] > arr[left]) ? left + 1 : left;
            largestIndex = arr[largestIndex] > arr[index] ? largestIndex : index;
            if(largestIndex == index) break;
            swap(arr, index, largestIndex);
            index = largestIndex;
            left = 2 * index + 1;
        }
    }

    public void insert(int item) {
        if(isFull()) throw new RuntimeException("Heap is full!");
        arr[heapSize] = item;
        swim(heapSize++);
    }

    public int delMax(){
        if(isEmpty()) throw new RuntimeException("Heap is empty");
        int max = arr[0];
        swap(arr,0, --heapSize);
        sink(0);
        return max;
    }

    public void swap(int[]arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

class HeapVerifier {

    private int[] arr;
    private final int limit;
    private int size;

    public HeapVerifier(int limit) {
        arr = new int[limit];
        this.limit = limit;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == limit;
    }

    public void push(int value) {
        if (size == limit) {
            throw new RuntimeException("heap is full");
        }
        arr[size++] = value;
    }

    public int pop() {
        int maxIndex = 0;
        for (int i = 1; i < size; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        int ans = arr[maxIndex];
        arr[maxIndex] = arr[--size];
        return ans;
    }

}