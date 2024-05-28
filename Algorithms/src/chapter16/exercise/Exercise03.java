package chapter16.exercise;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

public class Exercise03 {

    public static int largestRectangleArea(int[] height){
        if (height == null || height.length == 0 ) return 0;

        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < height.length; i++){
            while(!stack.isEmpty() && height[i] <= height[stack.peek()]){
                int j = stack.pop();
                int k = stack.isEmpty()? -1 : stack.peek();
                int curArea = (i - k - 1) * height[j];
                maxArea = Math.max(maxArea,curArea);
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int j = stack.pop();
            int k = stack.isEmpty()? -1 : stack.peek();
            int curArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(maxArea,curArea);
        }

        return maxArea;
    }

}
