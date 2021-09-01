package chapter01.exercise;

//题目：一个数组中，有一种数出现了奇数次，其他数都出现了偶数次，打印这种数
public class Exercise02 {
    public static void main(String[] args) {
        int[] arr = {2,3,3,3,3,2,2};
//        System.out.println(FindPrime.findPrime01(arr));
        FindPrime.findPrime02(arr);
    }
}

class FindPrime {

    //arr: 有一种数出现了奇数次，其他数都出现了偶数次
    public static void findPrime02(int[] arr){
        int eor = 0;
        for(int i = 0; i < arr.length; i++)
            eor ^= arr[i];
        System.out.println(eor);
    }

    //arr: 有一种数出现了奇数次，其他数都出现了偶数次
    public static int findPrime01(int[] arr){

        if (arr == null || arr.length == 0) return -1;

        for(int i = 0; i < arr.length;i++){
            int result = arr[i];
            for(int j = 0; j < arr.length; j++){
                if (arr[i] == arr[j]) result = result ^ arr[j];
            }
            if ((result ^ arr[i]) == arr[i]) return arr[i];
        }

        return -1;
    }
}