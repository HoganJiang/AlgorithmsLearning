package chapter13.exercise;

import java.lang.management.ManagementFactory;

/**
 * @Auther: jiangyi
 * @Date: 2022-01-02
 * @Description: arr是面值数组，其中的值都是正数且没有重复。再给定一个正数aim。每个值都认为是一种面值，且认为张数是无限的。返回组成aim的方法数
 * 例如：arr = {1,2}，aim = 4 方法如下：1+1+1+1、1+1+2、2+2一共就3种方法，所以返回3
 */
public class Exercise03 {

    public static int CoinWays(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) return 0;
        return process(arr, 0, aim);
    }

    private static int process(int[] arr, int index, int rest) {

        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }

        int ans = 0;
        for (int zhangshu = 0; rest >= arr[index] * zhangshu; zhangshu++) {
            ans += process(arr, index + 1, rest - arr[index] * zhangshu);
        }

        return ans;

    }

    public static int dpWay1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) return 0;
        int N = arr.length;
        int column = aim + 1;
        int[][] dp = new int[N + 1][column];
        dp[N][0] = 1;

        for (int row = N - 1; row >= 0; row--) {
            for (int rest = 0; rest <= aim; rest++) {
                int ans = 0;
                for (int zhangshu = 0; rest >= arr[row] * zhangshu; zhangshu++) {
                    ans += dp[row + 1][rest - (zhangshu * arr[row])];
                }
                dp[row][rest] = ans;
            }
        }
        return dp[0][aim];
    }

    public static int dpWay2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) return 0;
        int N = arr.length;
        int column = aim + 1;
        int[][] dp = new int[N + 1][column];
        dp[N][0] = 1;

        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[index][rest] = dp[index + 1][rest];
                if (rest - arr[index] >= 0) {
                    dp[index][rest] += dp[index][rest - arr[index]];
                }
            }
        }
        return dp[0][aim];
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int N = (int) (Math.random() * maxSize);
        int[] arr = new int[N];
        boolean[] has = new boolean[maxValue + 1];
        for (int i = 0; i < N; i++) {
            do {
                arr[i] = (int) (Math.random() * maxValue) + 1;
            } while (has[arr[i]]);
            has[arr[i]] = true;
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int maxLen = 10;
        int maxValue = 30;
        int testTime = 1000000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxLen, maxValue);
            int aim = (int) (Math.random() * maxValue);
            int ans1 = CoinWays(arr, aim);
            int ans2 = dpWay1(arr, aim);
            int ans3 = dpWay2(arr, aim);
            if (ans1 != ans2 || ans1 != ans3) {
                System.out.println("Oops!");
                printArray(arr);
                System.out.println(aim);
                System.out.println(ans1);
                System.out.println(ans2);
                System.out.println(ans3);
                break;
            }
        }
        System.out.println("测试结束");
    }



}
