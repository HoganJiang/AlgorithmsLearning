package chapter13.exercise;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;

/**
 * @Auther: jiangyi
 * @Date: 2022-01-01
 * @Description:
 * arr是货币数组，其中的值都是正数。再给定一个正数aim。每个值都认为是一张货币，即便是值相同的货币也认为每一张都是不同的，
 * 返回组成aim的方法数例如：arr = {1,1,1}，aim = 2 第0个和第1个能组成2，第1个和第2个能组成2，第0个和第2个能组成2一共就3种方法，所以返回3
 */
public class Exercise02 {

    public static int coinWays(int[] coins, int aim){
//        if(coins == null || coins.length == 0 || aim < 0) return 0;
        return process(coins,0,aim);
    }

    private static int process(int[] coins, int index, int rest) {

        //index < length index >length
        //rest < 0 rest >0 rest ==0
        //当前元素的值 与 rest的关系

        //index < length && rest < 0
        if(rest < 0) return 0;

        //index > length
        if(index == coins.length) {
            return rest == 0 ? 1 : 0;
        } else {
            //index < length && rest >=0 && 当前位置的值 <= rest  => process(coins,index + 1, rest - coins[index])
            //index < length && rest >=0 && 当前位置的值 > rest => process(coins,index + 1, rest)
            return process(coins,index+1,rest) + process(coins,index + 1, rest - coins[index]);
        }

//        if(coins[index] == rest) return 1;

//        if(index < coins.length){
//            if(coins[index] > rest){
//                int ans1 = process(coins,index+1,rest);
//            } else {
//                int ans2 = process(coins,index + 1, rest - coins[index]) + coins[index];
//            }
//            return process(coins,index+1,rest) + process(coins,index + 1, rest - coins[index]);
//        }

//        return ans1 + ans2;
    }

    public static int dp(int[] arr, int aim) {
        if (aim == 0) {
            return 1;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1;
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[index][rest] = dp[index + 1][rest] + (rest - arr[index] >= 0 ? dp[index + 1][rest - arr[index]] : 0);
            }
        }
        return dp[0][aim];
    }

    // 为了测试
    public static int[] randomArray(int maxLen, int maxValue) {
        int N = (int) (Math.random() * maxLen);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = (int) (Math.random() * maxValue) + 1;
        }
        return arr;
    }

    // 为了测试
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int maxLen = 20;
        int maxValue = 30;
        int testTime = 1000000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr = randomArray(maxLen, maxValue);
            int aim = (int) (Math.random() * maxValue);
            int ans1 = coinWays(arr, aim);
            int ans2 = dp(arr, aim);
            if (ans1 != ans2) {
                System.out.println("Oops!");
                printArray(arr);
                System.out.println(aim);
                System.out.println(ans1);
                System.out.println(ans2);
                break;
            }
        }
        System.out.println("测试结束");
    }
}
