package chapter12.exercise;

/**
 * @Auther: jiangyi
 * @Date: 2021-12-14
 * @Description:
 * 给定一个字符串str，返回这个字符串的最长回文子序列长度
 * 比如 ： str = “a12b3c43def2ghi1kpm”
 * 最长回文子序列是“1234321”或者“123c321”，返回长度7
 */
public class Exercise07 {

    public static int longestPalindromeSubseq(String str){
        if(str == null || str.length() == 0){
            return 0;
        }
        char[] s = str.toCharArray();
        return process1(s,0,s.length - 1);
    }

    public static int process1(char[] s, int L, int R) {
        if(L==R) return 1;
        if(L == R -1) return s[L] == s[R]? 2 : 1;
        int p1 = process1(s,L+1,R);
        int p2 = process1(s,L,R-1);
        int p3 = process1(s,L+1,R -1);
        int p4 = s[L] != s[R]? 0 : (2 + process1(s,L+1,R -1));
        return Math.max(Math.max(p1,p2),Math.max(p3,p4));
    }

    public static int dp1(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        int[][] dp = new int[N][N];
        dp[N-1][N-1] = 1;
        for(int i = 0; i < N - 1;i++){
            dp[i][i] = 1;
            dp[i][i+1] = str[i] == str[i+1]? 2 : 1;
        }
        for(int L = N - 2; L >= 0;L--){
            for(int R = L + 2; R < N; R++){
                int p1 = dp[L+1][R];
                int p2 = dp[L][R-1];
                int p3 = dp[L+1][R -1];
                int p4 = str[L] != str[R]? 0 : (2 + dp[L+1][R -1]);
                dp[L][R]=Math.max(Math.max(p1,p2),Math.max(p3,p4));
            }
        }
        return dp[0][N -1];
    }

    public static int dp2(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        int[][] dp = new int[N][N];
        dp[N-1][N-1] = 1;
        for(int i = 0; i < N - 1;i++){
            dp[i][i] = 1;
            dp[i][i+1] = str[i] == str[i+1]? 2 : 1;
        }
        for(int L = N - 2; L >= 0;L--){
            for(int R = L + 2; R < N; R++){
                dp[L][R] = Math.max(dp[L][R-1],dp[L+1][R]);
                if(str[L] == str[R]) dp[L][R] = Math.max(dp[L][R],(2 + dp[L+1][R -1]));
            }
        }
        return dp[0][N -1];
    }



    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindromeSubseq(s));
        System.out.println(dp1(s));
        System.out.println(dp2(s));
    }

}
