package chapter12.exercise;

/**
 * @Auther: jiangyi
 * @Date: 2021-12-01
 * @Description:
 * 练习题：假设有排成一行的N个位置，记为1~N，N 一定大于或等于 2
 * 开始时机器人在其中的M位置上(M 一定是 1~N 中的一个)
 * 如果机器人来到1位置，那么下一步只能往右来到2位置；
 * 如果机器人来到N位置，那么下一步只能往左来到 N-1 位置；
 * 如果机器人来到中间位置，那么下一步可以往左走或者往右走；
 * 规定机器人必须走 K 步，最终能来到P位置(P也是1~N中的一个)的方法有多少种
 * 给定四个参数 N、M、K、P，返回方法数。
 * @version: 1.0
 */
public class Exercise01 {

    /**
     * 方式一：暴力递归求解
     * @param length 位置的长度
     * @param aim 要走到那个位置
     * @param startPosi 从哪个位置开始走
     * @param k 走多少步
     * @return
     */
    public static int robotWalk1(int length, int aim, int startPosi, int k){
        if(length < 2 || aim < 1 || aim > length || startPosi < 1 || startPosi > length || k > length){
            return 0;
        }
        return process1(length,aim, startPosi,k);
    }

    public static int process1(int N, int aim, int cur, int restSteps){

        if(restSteps == 0){
            return cur == aim? 1 : 0;
        }

        if(cur == 1){
            process1(N, aim,2, restSteps - 1);
        }

        if(cur == N){
            process1(N,aim,N - 1,restSteps - 1);
        }

        return  process1(N,aim,cur - 1, restSteps - 1) + process1(N,aim,cur + 1,restSteps - 1);

    }

    /**
     * 方式二：动态规划之缓存版本，主要解决暴力递归过程中重复计算的问题
     * @param length 位置的长度
     * @param aim 要走到那个位置
     * @param startPosi 从哪个位置开始走
     * @param k 走多少步
     * @return
     */
    public static int robotWalk2(int length, int aim, int startPosi, int k){
        if(length < 2 || aim < 1 || aim > length || startPosi < 1 || startPosi > length || k > length){
            return 0;
        }
        //准备一张二维的缓存表，由于变化的参数只有StartPosi且其变化的范围是1 ~ N以及K，其变化范围是0~k，因此表的大小就由这两个变量确定
        int[][] dp = new int[length + 1][k + 1];
        for (int i = 0; i < length + 1; i++) {
            for (int j = 0; j < k + 1; j++) {
                dp[i][j] = -1; //dp[i][j] = -1表示未命中缓存
            }
        }
        return process2(length,aim, startPosi,k,dp);
    }

    public static int process2(int N, int aim, int cur, int restSteps,int[][] dp){

        if(dp[cur][restSteps] != -1){
            return dp[cur][restSteps];
        }

        int ans = 0;
        if(restSteps == 0){
            ans = cur == aim? 1 : 0;
        } else if (cur == 1){
            ans = process2(N, aim,2, restSteps - 1,dp);
        } else if (cur == N){
            ans = process2(N, aim,N - 1, restSteps - 1,dp);
        } else {
            ans = process2(N,aim,cur - 1, restSteps - 1,dp) + process2(N,aim,cur + 1,restSteps - 1,dp);
        }

        dp[cur][restSteps] = ans;

        return  ans;

    }

    /**
     * 方式三：最终的动态规划版本：填二维表的过程
     * @param length 位置的长度
     * @param aim 要走到那个位置
     * @param startPosi 从哪个位置开始走
     * @param k 走多少步
     * @return
     */
    public static int robotWalk3(int length, int aim, int startPosi, int k){
        if(length < 2 || aim < 1 || aim > length || startPosi < 1 || startPosi > length || k > length){
            return 0;
        }
        int[][] dp = new int[length + 1][k + 1];
        dp[aim][0] = 1;
        for (int rest = 1; rest <= k; rest++) {
            dp[1][rest] = dp[2][rest - 1];
            for (int cur = 2; cur < length ; cur++) {
                dp[cur][rest] = dp[cur - 1][rest - 1] + dp[cur + 1][rest - 1];
            }
            dp[length][rest] = dp[length - 1][rest - 1];
        }
        return dp[startPosi][k];
    }

    public static void main(String[] args) {
        System.out.println(robotWalk1(7,5,3,4));
        System.out.println(robotWalk2(7,5,3,4));
        System.out.println(robotWalk3(7,5,3,4));
    }

}
