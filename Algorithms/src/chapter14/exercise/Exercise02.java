package chapter14.exercise;

/**
 * @Auther: jiangyi
 * @Date: 2022-01-08
 * @Description: chapter14.exercise
 * arr是面值数组，其中的值都是正数且没有重复。再给定一个正数aim。每个值都认为是一种面值，且认为张数是无限的。返回组成aim的最少货币数
 */
public class Exercise02 {

    public static int getMinCoins(int[] arr, int aim){
        return process(arr, 0, aim);
    }

    private static int process(int[] arr, int index, int rest) {
        if(index == arr.length){
            return rest == 0? 0 : Integer.MAX_VALUE;
        } else {
            int ans = Integer.MAX_VALUE;
            for(int z = 0; rest >= z * arr[index]; z++){
                int next = process(arr, index + 1, rest - arr[index] * z);
                if(next != Integer.MAX_VALUE){
                    ans = Math.min(ans, next + z);
                }
            }
            return ans;
        }
    }
}
