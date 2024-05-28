package chapter03.exercise;

import java.util.Arrays;

public class Exercise02 {
    public static void main(String[] args) {
        int testTime = 500000;
        int maxLen = 100;
        int maxValue = 100000;
        boolean succeed = true;
        for(int i = 0; i <testTime; i++){
            int[] randomArray = Verifier02.generateRandomArray(maxLen, maxValue);
            int[] copyArray = Verifier02.copyArray(randomArray);
            if(MinSum.getMinSum(randomArray) != Verifier02.getMinSum(copyArray)){
                succeed = false;
                Verifier02.printArray(randomArray);
                Verifier02.printArray(copyArray);
                break;
            }
        }
        System.out.println(succeed == true? "perfect!" : "test failed!");
    }
}

class MinSum {

    public static int getMinSum(int[] arr){
        return sort(arr, 0, arr.length - 1);
    }

    public static int sort(int[] arr, int lo, int hi){
        if(arr == null || arr.length < 2) return 0;
        if(lo < 0 || hi > arr.length - 1) return 0;
        if(lo == hi) return 0;
        int mid = lo + ((hi - lo) >> 1);
        return sort(arr,lo,mid) + sort(arr,mid + 1, hi) + merge(arr,lo,mid,hi);
    }

    public static int merge(int[] arr, int lo, int mid, int hi){

        int[] help = new int[hi - lo + 1];

        int i = 0;
        int k = lo;
        int j = mid + 1;
        int sum = 0;
        while(k <= mid && j <= hi){
            sum += arr[k] < arr[j]? (hi - j + 1) * arr[k] : 0;
            help[i++] = arr[k] < arr[j] ? arr[k++] : arr[j++];
        }

        while(k <= mid){
            help[i++] = arr[k++];
        }

        while(j <= hi){
            help[i++] = arr[j++];
        }

        for(int index = 0; index < help.length;index++){
            arr[lo+index] = help[index];
        }

        return sum;
    }
}

class Verifier02 {

    //1.用于测试的排序方法：绝对正确，但复杂度或许不是很好
    public static int getMinSum(int[] arr){
        int sum = 0;
        for(int i = arr.length - 1; i > 0; i--){
            for(int j = i - 1; j >= 0; j--){
                if(arr[j] < arr[i]) {sum += arr[j];}
            }
        }
        return sum;
    }

    //2.生成随机样本：长度随机，存储的值随机的数组
    public static int[] generateRandomArray(int maxLen, int maxValue){
        int[] randomArr = new int[(int)(Math.random() * (maxLen + 1))];
        for(int i = 0; i < randomArr.length; i++){
            randomArr[i] = (int)(Math.random() * (maxValue + 1)) - (int) (maxValue * Math.random());
        }
        return randomArr;
    }

    //3.拷贝数组
    public static int[] copyArray(int[] arr){
        int[] copyArr = new int[arr.length];
        for(int i = 0; i < arr.length;i++){
            copyArr[i] = arr[i];
        }
        return copyArr;
    }

    //4.判断是否相等
    public static boolean isEqual(int[] a, int[] b){
        if(a == null && b == null) return true;
        if(a == null || b == null) return false;
        if(a.length != b.length) return false;
        for(int i = 0; i < a.length;i++){
            if(a[i] != b[i]) return false;
        }
        return true;
    }

    //5.打印数组
    public static void printArray(int[] arr){
        if(arr == null) return;
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
