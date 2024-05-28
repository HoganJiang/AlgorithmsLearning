package chapter02.exercise;

import java.util.LinkedList;
import java.util.Queue;

public class Exercise10 {

    public static class StackBasedQueue {
        public Queue<Integer> dataQueue;
        public Queue<Integer> helpQueue;

        public StackBasedQueue(){
            this.dataQueue = new LinkedList<>();
            this.helpQueue = new LinkedList<>();
        }

        public void push(int value){
            dataQueue.offer(value);
        }

        public int pop(){
            while(dataQueue.size() > 1){
                helpQueue.offer(dataQueue.poll());
            }
            int val = dataQueue.poll();
            Queue<Integer> tmp = dataQueue;
            dataQueue = helpQueue;
            helpQueue = tmp;
            return val;
        }

        public int peek(){
            while(dataQueue.size() > 1){
                helpQueue.offer(dataQueue.poll());
            }
            int val = dataQueue.poll();
            helpQueue.offer(val);
            Queue<Integer> tmp = dataQueue;
            dataQueue = helpQueue;
            helpQueue = tmp;
            return val;
        }
        public boolean isEmpty(){
            return dataQueue.isEmpty();
        }
    }
}
