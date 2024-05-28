package chapter09.exercise;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Exercise04 {

//    public static int lowestPrice1(int[] arr){
//        Arrays.sort(arr);
//        int N = arr.length - 1;
//        int sum = 0;
//        for(int i = 0; i < arr.length; i++){
//            sum += arr[i];
//        }
//
//        int price = 60;
//        int rest = 0;
//        for(int i = N; i > 0; i--){
//            rest = sum - arr[i];
//            price += rest;
//            sum = rest;
//        }
//        return price;
//    }

    public static int lowestPrice(int[] arr){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        for(int i = 0; i < arr.length; i++){
            priorityQueue.add(arr[i]);
        }

        int sum = 0;
        int cur = 0;
        while (priorityQueue.size() > 1){
            cur = priorityQueue.poll() + priorityQueue.poll();
            sum += cur;
            priorityQueue.add(cur);
        }

        return sum;
    }
}
