package chapter15.exercise;

import java.util.LinkedList;

/**
 * @Auther: jiangyi
 * @Date: 2022-01-19
 * @Description:
 * 假设一个固定大小为W的窗口，依次划过arr, 返回每一次滑出状况的最大值 例如，arr = [4,3,5,4,3,3,6,7], W = 3 返回：[5,5,5,4,6,7]
 */
public class Exercise01 {

    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        // qmax 窗口最大值的更新结构
        // 放下标
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int R = 0; R < arr.length; R++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]) {
                qmax.pollLast();
            }
            qmax.addLast(R);
            if (qmax.peekFirst() == R - w) {
                qmax.pollFirst();
            }
            if (R >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
}
