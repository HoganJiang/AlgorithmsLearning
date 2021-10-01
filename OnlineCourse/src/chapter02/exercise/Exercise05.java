package chapter02.exercise;

public class Exercise05 {

    public class StackBasedArray {
        public int[] arr;
        public int size;

        public StackBasedArray(int len){
            arr = new int[len];
            this.size = 0;
        }

        public int pop(){
            if(!isEmpty()){
                return arr[size--];
            }
            return -1;
        }

        public void push(int value){
            if(!isFull()){
                arr[size++] = value;
            }
        }

        public boolean isEmpty(){
            return size == 0;
        }

        public boolean isFull(){
            return size == arr.length;
        }
        
        public int peek(){
            if(!isEmpty() && size < arr.length){
                return arr[size];
            }
            return -1;
        }
    }
}
