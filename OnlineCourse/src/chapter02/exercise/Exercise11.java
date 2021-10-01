package chapter02.exercise;

public class Exercise11 {
    public static class RingQueue {
        private int head;
        private int tail;
        private int size;
        private int defaultSize;
        private int[] arr;

        public RingQueue(int limit){
            this.head = 0;
            this.tail = 0;
            this.size = 0;
            this.defaultSize = limit;
            this.arr = new int[limit];
        }

        public void enqueue(int value) throws Exception {
            if(size == defaultSize) throw new Exception("Queue is full!");
            size++;
            arr[tail] = value;
            tail = checkIndex(tail);
        }

        public int dequeue() throws Exception {
            if(size == 0) throw new Exception("Queue is empty!");
            size--;
            int ans = arr[head];
            head = checkIndex(head);
            return ans;
        }

        public boolean isEmpty(){
            return size == 0;
        }

        public int checkIndex(int index){
            return size < defaultSize - 1? index + 1:0;
        }
    }
}

