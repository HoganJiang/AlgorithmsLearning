package chapter13.exercise;

/**
 * @Auther: jiangyi
 * @Date: 2022-01-01
 * @Description:
 * 给定一个二维数组matrix，一个人必须从左上角出发，最后到达右下角沿途只可以向下或者向右走，
 * 沿途的数字都累加就是距离累加和返回最小距离累加和
 */
public class Exercise01 {

    /**
     * 一般动态规划求解
     * @param m
     * @return
     */
    public static int minPathSum1(int[][] m){
        if(m == null || m.length == 0 || m[0] == null || m[0].length == 0) return 0;

        int row = m.length;
        int column = m[0].length;
        int[][] dp = new int[row][column];

        dp[0][0] = m[0][0];
        //填写dp表第一行的值
        for(int i = 1; i < column; i++){
            dp[0][i] = dp[0][i-1] + m[0][i];
        }
        //填写dp表第一列的值
        for(int j = 1; j < row; j++){
            dp[j][0] = dp[j-1][0] + m[j][0];
        }
        //填写dp表任意位置的值，任意位置的值
        //先计算左边与自己和，该值上面与自己的和
        //最后取最小值得到该位置的值
        for(int k = 1; k < row; k++){
            for(int i = 1; i < column; i++){
                dp[k][i] = Math.min(dp[k-1][i],dp[k][i-1]) + m[k][i];
            }
        }

        return dp[row-1][column-1];
    }

    /**
     * 数组压缩技巧求解
     * @param m
     * @return
     */
    public static int minPathSum2(int[][] m) {
        if(m == null || m.length == 0 || m[0] == null || m[0].length == 0) return 0;
        //申请一个长度为原二维数组列长度大小的一维数组
        int row = m.length;
        int column = m[0].length;
        int[] arr = new int[column];
        arr[0] = m[0][0];
        for(int i = 1; i < column; i++){
            arr[i] = arr[i-1] + m[0][i];
        }
        for(int j = 1; j < row; j++){
            arr[0] += m[j][0];
            for(int k = 1; k < column; k++){
                arr[k] = Math.min(arr[k-1],arr[k]) + m[j][k];
            }
        }
        return arr[column - 1];
    }

    public static int[][] generateRandomMatrix(int rowSize, int colSize) {
        if (rowSize < 0 || colSize < 0) {
            return null;
        }
        int[][] result = new int[rowSize][colSize];
        for (int i = 0; i != result.length; i++) {
            for (int j = 0; j != result[0].length; j++) {
                result[i][j] = (int) (Math.random() * 100);
            }
        }
        return result;
    }



    public static void main(String[] args) {
        int rowSize = 10;
        int colSize = 10;
        int[][] m = generateRandomMatrix(rowSize, colSize);
        System.out.println(minPathSum1(m));
        System.out.println(minPathSum2(m));
    }


}
