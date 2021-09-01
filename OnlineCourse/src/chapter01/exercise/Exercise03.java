package chapter01.exercise;

//题目：一个数组中，有两种数出现了奇数次，其他数都出现了偶数次，打印出这两种数
public class Exercise03 {
    public static void main(String[] args) {
        int[] arr = {2,3,3,3,3,2,2,4,4,4};
        PrintOddTimes2.printPrime(arr);
    }
}

class PrintOddTimes2 {

    public static void printPrime(int[] arr){
        //1. 定义一个变量eor， 使eor异或原数组，令数组中两个不同的奇数分别为a,b，则eor = a ^ b
        //此时，由于a不等于b，那么可推论出eor不等于0，也可推论出a与b中，必有一个数的二进制位有1
        //因此，需要找到这个位置
        int eor = 0;
        for (int i = 0; i < arr.length;i++){
            eor ^= arr[i];
        }
        //2. 求最右侧为1的数
        int rightOne = eor & ((~eor) + 1);
        //3. 求二进制为存在1的质数
        int a = 0;
        for(int i = 0; i < arr.length; i++){
            //如果(arr[i] & rightOne) != 0 为true，那么此时这个数必有1
            if ((arr[i] & rightOne) != 0)
                a ^= arr[i];
        }
        //4. 求b，且打印a 和b
        System.out.println("a=" + a + ",b=" + (eor ^ a));
    }
}
