package chapter04.exercise;

import java.util.Arrays;

public class Exercise02 {
    public static void main(String[] args) {
        int[] arr = {9,8,3,10,12,18,25};
        MyHeapSort myHeapSort = new MyHeapSort(arr.length);
        myHeapSort.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

class MyHeapSort {

    private int[] arr;
    private int heapSize;
    private int defaultCapacity;

    public MyHeapSort(int defaultCapacity) {
        this.arr = new int[defaultCapacity];
        this.defaultCapacity = defaultCapacity;
        this.heapSize = 0;
    }

    public boolean isFull(){
        return heapSize == defaultCapacity;
    }

    public boolean isEmpty(){return heapSize == 0;}

    private void swim(int[]arr, int index){
        while(arr[index] > arr[(index - 1) / 2]){
            swap(arr,index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void sink(int[] arr,int index,int heapSize){
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

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void heapSort(int[] arr){
        int N = arr.length;
        //从上至下排序
//        for(int i = 0; i < N; i++){
//            swim(arr,i);
//        }
        //从下至上排序
        for(int i = N - 1; i >= 0; i--){
            sink(arr,i,N);
        }
        while(N > 0){
            swap(arr,0,--N);
            sink(arr,0,N);
        }
    }
}
