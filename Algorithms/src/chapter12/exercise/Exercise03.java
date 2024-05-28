package chapter12.exercise;

/**
 * @Auther: jiangyi
 * @Date: 2021-12-02
 * @Description: 背包问题
 * 给定两个长度都为N的数组weights和values，
 * weights[i]和values[i]分别代表 i号物品的重量和价值。
 * 给定一个正数bag，表示一个载重bag的袋子，
 * 你装的物品不能超过这个重量。
 * 返回你能装下最多的价值是多少?
 * @version: 1.0
 */
public class Exercise03 {

    /**
     * 方式一：暴力递归
     * @param weight
     * @param value
     * @param bag
     * @return
     */
    public static int knackSack1(int[] weight, int[] value, int bag){
        if(weight == null || weight.length == 0 || value == null || value.length == 0){
            return -1;
        }

        return process1(weight,value,0,bag);
    }

    public static int process1(int[] weight, int[] value, int index, int bag){

//        if(index == weight.length - 1){
//            if(bag > 0){
//                return 0;
//            } else if (bag == 0){
//                return value[index];
//            }
//        }
//
//        if(index != weight.length - 1 && bag == 0){
//            return 0;
//        }
//
//        int ans = 0;
//        int v1 = process1(weight,value,index + 1,bag - weight[index]);
//        ans += v1;

        if(bag < 0){
            return -1;
        }

        if(index == weight.length){
            return 0;
        }

        int v1 = process1(weight,value,index+1,bag);
        int v2 = 0;
        int next = process1(weight,value,index+1,bag - weight[index]);
        if(next != -1){
            v2 = value[index] + next;
        }
        return Math.max(v1,v2);

    }

    /**
     * 方式二：暴力递归改动态规划
     * @param weight
     * @param value
     * @param bag
     * @return
     */
    public static int dp(int[] weight, int[] value, int bag){
        if(weight == null || weight.length == 0 || value == null || value.length == 0){
            return -1;
        }
        //1. 可变参数index的范围是0~weight.length,bag的范围是负~bag。因此可确定二维动态规划表，由于index
        //的最大取值可以到weight.length，所以二维表的行的长度为weight.length + 1，同理，列的取值可以到bag，所以列的长度为bag+1
        int[][] dp = new int[weight.length + 1][bag + 1];
        //2. 分析递归的BaseCase可以知道：当index在位于最后一个位置时，值为0，但是java对与Integer的初始值就为0，因此不用做初始化
        //3. 普遍位置的值应该怎么填
        for(int index = weight.length - 1; index >= 0; index--){
            for(int rest = 0; rest <= bag; rest++){
                int v1 = dp[index+1][rest];
                int v2 = 0;
                int next = rest - weight[index] < 0? -1:dp[index + 1][rest - weight[index]];
                if(next != -1){
                    v2 = value[index] + next;
                }
                dp[index][rest] = Math.max(v1,v2);
            }
        }
        return dp[0][bag];//由主函数的调用可知：返回的结果是dp[0][bag]位置的值
    }

    public static void main(String[] args) {
        //3, 2, 4, 7, 3, 1, 7
        int[] weights = { 3, 2, 4, 7 };
//        5, 6, 3, 19, 12, 4, 2
        int[] values = { 5, 6, 3, 19};
        int bag = 15;
        System.out.println(knackSack1(weights, values, bag));
        System.out.println(dp(weights, values, bag));
    }


}
