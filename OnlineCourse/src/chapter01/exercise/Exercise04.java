package chapter01.exercise;

//题目：一个数组中，有两种数出现了奇数次，其他数都出现了偶数次，打印出这两种数
public class Exercise04 {
    public static void main(String[] args) {
        int[] arr = {2,3,3,3,3,2,2,4,4,4};
        PrintOddTimes2.printPrime(arr);
    }
}

class PrintOddTimes2 {

    public static void printPrime(int[] arr){
        int eor = 0;
        for(int i = 0; i < arr.length; i++){
            eor ^= arr[i];
        }
        int rightOne = eor & ((~eor) + 1);
        int a = 0;
        for(int j = 0; j < arr.length;j++){
            if((arr[j] & rightOne) != 0) a ^= arr[j];
        }
        System.out.println("a=" + a + ", b=" + (eor^a));
    }

    //求一个数的二进制位有多少个1
    public static int bit1counts(int N){

        int cnt = 0;

        while(N != 0){
            int rightOne = N & ((~N) + 1);
            cnt++;
            N ^= rightOne;
        }

        return cnt;
    }
}
