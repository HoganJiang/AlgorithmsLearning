package chapter12.exercise;

/**
 * @Auther: jiangyi
 * @Date: 2021-12-01
 * @Description:
 * 练习题： 给定一个整型数组arr，代表数值不同的纸牌排成一条线
 * 玩家A和玩家B依次拿走每张纸牌
 * 规定玩家A先拿，玩家B后拿
 * 但是每个玩家每次只能拿走最左或最右的纸牌
 * 玩家A和玩家B都绝顶聪明
 * 请返回最后获胜者的分数。
 * @version: 1.0
 */
public class Exercise02 {

    /**
     * 方式一：暴力递归
     * @param arr
     * @return
     */
    public static int winScore1(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        return Math.max(f1(arr,0,arr.length - 1),s1(arr,0,arr.length - 1));
    }

    public static int f1(int[] arr, int L, int R){
        if(L == R){
            return arr[L];
        }
        int s1 = arr[L] + s1(arr,L+1,R);
        int s2 = arr[R] + s1(arr, L, R - 1);
        return Math.max(s1,s2);
    }

    public static int s1(int[] arr, int L, int R){
        if(L == R) {
            return 0;
        }
        int s1 = f1(arr,L+1, R);
        int s2 = f1(arr,L, R - 1);
        return Math.min(s1,s2);
    }


    /**
     * 方式二：从暴力递归优化到记忆化搜索
     * (1) 分析递归函数的依赖，检查是否存在重复解，若存在重复解，则进行第二步
     * (2) 找出变化的参数，以及其个数，以此创建二维或多维的缓存表
     * (3) 改写暴力递归：具体步骤参下
     * @param arr
     * @return
     */
    public static int winScore2(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }

        //申请两张缓存表，分表存f2与s2的变化的参数
        int N = arr.length;
        int[][] fMap = new int[N][N];
        int[][] sMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                fMap[i][j] = -1;
                sMap[i][j] = -1;
            }
        }
        return Math.max(f2(arr,0,arr.length - 1,fMap,sMap),s2(arr,0,arr.length - 1,fMap,sMap));
    }

    public static int f2(int[] arr, int L, int R,int[][] fMap,int[][] sMap){
        if(fMap[L][R] != -1){
            return fMap[L][R];
        }
        int ans = 0;

        if(L == R){
            ans =  arr[L];
        } else {
            int s1 = arr[L] + s2(arr,L+1,R,fMap,sMap);
            int s2 = arr[R] + s2(arr, L, R - 1,fMap,sMap);
            ans = Math.max(s1,s2);
        }
        fMap[L][R] = ans;
        return ans;
    }

    public static int s2(int[] arr, int L, int R,int[][] fMap,int[][] sMap){
        if(sMap[L][R] != -1){
            return sMap[L][R];
        }
        int ans = 0;
        if(L != R) {
            int s1 = f1(arr,L+1, R);
            int s2 = f1(arr,L, R - 1);
            ans = Math.min(s1,s2);
        }
        sMap[L][R] = ans;
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {7,100,30,21};
        System.out.println(winScore1(arr));
        System.out.println(winScore2(arr));
    }
}
