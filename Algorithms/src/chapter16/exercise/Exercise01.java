package chapter16.exercise;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

import java.util.ArrayList;
import java.util.List;

public class Exercise01 {

    public static int[][] getNearLessNoRepeat(int[] arr) {

        if (arr == null || arr.length == 0) return null;

        int[][] ans = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ans.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int j = stack.pop();
                int leftLess = stack.isEmpty() ? -1 : stack.peek();
                ans[j][0] = leftLess;
                ans[j][1] = i;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int j = stack.pop();
            int leftLess = stack.isEmpty() ? -1 : stack.peek();
            ans[j][0] = leftLess;
            ans[j][1] = -1;
        }

        return ans;
    }

    public static int[][] getNearLessRepeat(int[] arr) {

        if (arr == null || arr.length == 0) return null;

        int[][] ans = new int[arr.length][2];
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                List<Integer> j = stack.pop();
                int leftLess = stack.isEmpty() ? -1 : stack.peek().get(stack.size() - 1);
                for (Integer e : j) {
                    ans[e][0] = leftLess;
                    ans[e][1] = i;
                }
            }
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(Integer.valueOf(i));
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }

        while (!stack.isEmpty()) {
            List<Integer> j = stack.pop();
            int leftLess = stack.isEmpty() ? -1 : stack.peek().get(stack.size() - 1);
            for (Integer e : j) {
                ans[e][0] = leftLess;
                ans[e][1] = -1;
            }
        }
        return ans;
    }

}
