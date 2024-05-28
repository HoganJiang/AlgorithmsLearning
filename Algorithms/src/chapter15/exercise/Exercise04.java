package chapter15.exercise;

import sun.reflect.annotation.AnnotationSupport;

/**
 * @Auther: jiangyi
 * @Date: 2022-01-21
 * @Description: chapter15.exercise
 * arr是货币数组，其中的值都是正数。再给定一个正数aim。每个值都认为是一张货币，返回组成aim的最少货币数
 * 注意：因为是求最少货币数，所以每一张货币认为是相同或者不同就不重要了
 */
public class Exercise04 {

    public static int getMinCoins(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) return 0;
//        int N = arr.length;
//        boolean[] record = new boolean[N + 1];
        return process(arr, 0, aim);
    }

    public static int process(int[] arr, int index, int rest) {
//        if(rest == 0){
//            record[index] = true;
//            return 1;
//        }
//
//        if(index == arr.length){
//            if(rest == 0){
//                record[index] = true;
//                return 1;
//            } else {
//                return -1;
//            }
//        }
//
//
//        int ans1 = process(arr, record,index+1,rest);
//        int ans2 = Integer.MAX_VALUE;
//        int next = process(arr, record, index + 1, rest - arr[index]);
//        if(next != -1){
//            int coins = 0;
//            for(int i = 0; i < record.length; i++){
//                if(record[i] = true) coins++;
//            }
//            ans2 = Math.min(ans2,coins);
//        }
//
//        return ans2;
        if (rest < 0) {
            return Integer.MAX_VALUE;
        }
        if (index == arr.length) {
            return rest == 0 ? 0 : Integer.MAX_VALUE;
        } else {
            int p1 = process(arr, index + 1, rest);
            int p2 = process(arr, index + 1, rest - arr[index]);
            if (p2 != Integer.MAX_VALUE) {
                p2++;
            }
            return Math.min(p1, p2);
        }

    }

    public static int dp1(int[] arr, int aim) {
        if (aim == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 0;
        for (int j = 1; j <= aim; j++) {
            dp[N][j] = Integer.MAX_VALUE;
        }
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int p1 = dp[index + 1][rest];
                int p2 = rest - arr[index] >= 0 ? dp[index + 1][rest - arr[index]] : Integer.MAX_VALUE;
                if (p2 != Integer.MAX_VALUE) {
                    p2++;
                }
                dp[index][rest] = Math.min(p1, p2);
            }
        }
        return dp[0][aim];
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 10, 6};
        int aim = 10;
        System.out.println(getMinCoins(arr, aim));
//        System.out.println(Integer.MAX_VALUE);
    }
}
