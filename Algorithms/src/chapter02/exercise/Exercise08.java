package chapter02.exercise;

import java.util.Stack;

public class Exercise08 {

    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public Exercise08() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value){
        if(minStack.isEmpty() || value < getMin()){
            minStack.push(value);
        }
        dataStack.push(value);
    }

    public int pop(){
        if(dataStack.isEmpty()) return -1;
        minStack.pop();
        return dataStack.pop();
    }

    public int getMin(){
        if(!minStack.isEmpty()){
            return minStack.peek();
        }
        return -1;
    }

    public static void main(String[] args) {
        Exercise08 stack = new Exercise08();
        stack.push(3);
        System.out.println(stack.getMin());
        stack.push(4);
        System.out.println(stack.getMin());
        stack.push(1);
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
    }
}
