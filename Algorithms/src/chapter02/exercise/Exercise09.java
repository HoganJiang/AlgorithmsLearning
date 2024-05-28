package chapter02.exercise;

import java.util.Stack;

public class Exercise09 {

    public static class QueueBasedStack {

        private Stack<Integer> popStack;
        private  Stack<Integer> pushStack;

        public QueueBasedStack(){
            popStack = new Stack<>();
            pushStack = new Stack<>();
        }

        private void getFromPushStackToPopStack(){
            while (!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }

        public void enqueue(int value){
            pushStack.push(value);
            if(popStack.isEmpty()){
                this.getFromPushStackToPopStack();
            }
        }

        public int dequeue(){
            if(popStack.isEmpty()){
                this.getFromPushStackToPopStack();
            }
            return popStack.pop();
        }

        public int peek() {
            if (popStack.empty() && pushStack.empty()) {
                throw new RuntimeException("Queue is empty!");
            }
            if(popStack.isEmpty()){
                this.getFromPushStackToPopStack();
            }
            return popStack.peek();
        }

        public static void main(String[] args) {
            QueueBasedStack test = new QueueBasedStack();
            test.enqueue(1);
            test.enqueue(2);
            test.enqueue(3);
            System.out.println(test.peek());
            System.out.println(test.dequeue());
            System.out.println(test.peek());
            System.out.println(test.dequeue());
            System.out.println(test.peek());
            System.out.println(test.dequeue());
        }
    }
}
