package chapter11.exercise;

import java.util.Stack;

public class Exercise02 {

    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()) return;
        Integer i = f(stack);
        reverse(stack);
        stack.push(i);
    }

    public static int f(Stack<Integer> stack){
        Integer res = stack.pop();
        if(stack.isEmpty()){
            return res;
        } else {
            Integer last = f(stack);
            stack.push(res);
            return last;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> test = new Stack<Integer>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        reverse(test);
        while (!test.isEmpty()) {
            System.out.println(test.pop());
        }
    }

}
