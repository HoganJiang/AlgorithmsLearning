package chapter12.exercise;

/**
 * @Auther: jiangyi
 * @Date: 2021-12-05
 * @Description: 规定1和A对应、2和B对应、3和C对应...那么一个数字字符串比如"111”就可以转化为:"AAA"、"KA"和"AK"
 * 给定一个只有数字字符组成的字符串str，返回有多少种转化结果
 * @version: 1.0
 */
public class Exercise04 {

    public static int getResult(String s) {
        if (s == null) return 0;
        char[] cs = s.toCharArray();
        return process(cs, 0);
    }

    public static int process(char[] cs, int index) {
        if (index == cs.length) return 1;

        if (cs[index] == '0') return 0;

        if (cs[index] == '1') {
            int ans = process(cs, index + 1);
            if (index + 1 < cs.length) {
                ans += process(cs, index + 2);
            }
            return ans;
        }

        if (cs[index] == '2') {
            int ans = process(cs, index + 1);
            if (index + 1 < cs.length && (cs[index + 1] >= '0' && cs[index + 1] <= '6')) {
                ans += process(cs, index + 2);
            }
            return ans;
        }

        return process(cs, index + 1);
    }

    public static int db(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] cs = s.toCharArray();
        int N = cs.length;
        int[] dp = new int[N + 1];
        dp[N] = 1;
        for (int i = N - 1; i >= 0; i--) {
            if (cs[i] != 0) {
                if (cs[i] == '1') {
                    int ans = dp[i + 1];
                    if (i + 1 < N) {
                        ans += dp[i + 2];
                    }
                    dp[i] = ans;
                } else if (cs[i] == '2') {
                    int ans = dp[i + 1];
                    if (i + 1 < N && (cs[i + 1] >= '0' && cs[i + 1] <= '6')) {
                        ans += dp[i + 2];
                    }
                    dp[i] = ans;
                } else {
                    return dp[i + 1];
                }
            }
        }
        return dp[0];

    }

    public static void main(String[] args) {
        String s = "111";
        System.out.println(getResult(s));
        System.out.println(db(s));
    }

}
