package chapter14.exercise;

/**
 * @Auther: jiangyi
 * @Date: 2022-01-02
 * @Description:
 * 给定3个参数，N，M，K怪兽有N滴血，等着英雄来砍自己英雄每一次打击，都会让怪兽流失[0~M]的血量，到底流失多少？
 * 每一次在[0~M]上等概率的获得一个值，求K次打击之后，英雄把怪兽砍死的概率
 */
public class Exercise01 {

    /**
     *
     * @param N 怪兽有N滴血
     * @param M 怪兽的流失的血量
     * @param K 打击的次数
     * @return 把怪兽砍死的概率
     */
    public static double killMonsterRate(int N, int M, int K){
//        if(N < 1 || M < 1 || K < 1) return 0;
//        int[] arr = new int[M+1];
//        for(int i = 0; i <= M; i++){
//            arr[i] = i;
//        }
//        long all = (long) Math.pow(M + 1, K);
////        return (double) ((double)process(arr,K,0,N) / (double) all);
//        return (double)process(arr,K,0,N);
        if (N < 1 || M < 1 || K < 1) {
            return 0;
        }
        long all = (long) Math.pow(M + 1, K);
        long kill = process(K, M, N);
        return (double) ((double) kill / (double) all);
    }

    public static long process(int times, int M, int hp) {
        if (times == 0) {
            return hp <= 0 ? 1 : 0;
        }
        if (hp <= 0) {
            return (long) Math.pow(M + 1, times);
        }
        long ways = 0;
        for (int i = 0; i <= M; i++) {
            ways += process(times - 1, M, hp - i);
        }
        return ways;
    }
//
//    private static long process(int[] arr, int k, int index, int rest) {
//
////        if(rest < 0) return 1;
////        if (rest <= 0) {
////            return (long) Math.pow(M + 1, times);
////        }
//
//        if(index == arr.length){
//            return rest <= 0? 1 : 0;
//        }
//
//        long ways = 0;
//        for(int j = 1; j <= k; j++){
//            ways += process(arr,k,index+1,rest - arr[index]);
//        }
//
//        return ways;
//    }



    public static double dp1(int N, int M, int K) {
        if (N < 1 || M < 1 || K < 1) {
            return 0;
        }
        long all = (long) Math.pow(M + 1, K);
        long[][] dp = new long[K + 1][N + 1];
        dp[0][0] = 1;
        for (int times = 1; times <= K; times++) {
            dp[times][0] = (long) Math.pow(M + 1, times);
            for (int hp = 1; hp <= N; hp++) {
                long ways = 0;
                for (int i = 0; i <= M; i++) {
                    if (hp - i >= 0) {
                        ways += dp[times - 1][hp - i];
                    } else {
                        ways += (long) Math.pow(M + 1, times - 1);
                    }
                }
                dp[times][hp] = ways;
            }
        }
        long kill = dp[K][N];
        return (double) ((double) kill / (double) all);
    }

    public static double dp2(int N, int M, int K) {
        if (N < 1 || M < 1 || K < 1) {
            return 0;
        }
        long all = (long) Math.pow(M + 1, K);
        long[][] dp = new long[K + 1][N + 1];
        dp[0][0] = 1;
        for (int times = 1; times <= K; times++) {
            dp[times][0] = (long) Math.pow(M + 1, times);
            for (int hp = 1; hp <= N; hp++) {
                dp[times][hp] = dp[times][hp - 1] + dp[times - 1][hp];
                if (hp - 1 - M >= 0) {
                    dp[times][hp] -= dp[times - 1][hp - 1 - M];
                } else {
                    dp[times][hp] -= Math.pow(M + 1, times - 1);
                }
            }
        }
        long kill = dp[K][N];
        return (double) ((double) kill / (double) all);
    }



    public static void main(String[] args) {
        int NMax = 10;
        int MMax = 10;
        int KMax = 10;
        int testTime = 200;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int N = (int) (Math.random() * NMax);
            int M = (int) (Math.random() * MMax);
            int K = (int) (Math.random() * KMax);
            double ans1 = killMonsterRate(N, M, K);
            double ans2 = dp1(N, M, K);
//            double ans3 = dp2(N, M, K);
            if (ans1 != ans2) {
                System.out.println("Oops!");
                break;
            }
        }
        System.out.println("测试结束");

//        System.out.println(killMonsterRate(10,4,3));
//        System.out.println(dp1(10,4,3));
////        System.out.println(process1(3,4,20));
    }


}