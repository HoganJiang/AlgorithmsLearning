package chapter03.exercise;

import java.util.Arrays;

public class Exercise01 {
    public static void main(String[] args) {
        int testTime = 500000;
        int maxLen = 100;
        int maxValue = 100000;
        boolean succeed = true;
        for(int i = 0; i <testTime; i++){
            int[] randomArray = Verifier01.generateRandomArray(maxLen, maxValue);
            int[] copyArray = Verifier01.copyArray(randomArray);
            MergeSort.mergeSort02(randomArray);
            Verifier01.sort(copyArray);
            if(!Verifier01.isEqual(randomArray,copyArray)){
                succeed = false;
                Verifier01.printArray(randomArray);
                Verifier01.printArray(copyArray);
                break;
            }
        }
        System.out.println(succeed == true? "perfect!" : "test failed!");
    }
}

class MergeSort {

    public static void mergeSort01(int[] arr){
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int lo, int hi){
        if(arr == null || arr.length < 2) return;
        if(lo < 0 || hi > arr.length - 1) return;
        if(lo == hi) return;
        int mid = lo + ((hi - lo) >> 1);
        sort(arr,lo,mid);
        sort(arr,mid + 1, hi);
        merge(arr,lo,mid,hi);
    }

    public static void merge(int[] arr, int lo, int mid, int hi){

        if(arr == null || arr.length < 2) return;
        if(lo < 0 || hi > arr.length - 1) return;

        int[] help = new int[hi - lo + 1];

        int i = 0;
        int k = lo;
        int j = mid + 1;
        while(k <= mid && j <= hi){
            help[i++] = arr[k] <= arr[j] ? arr[k++] : arr[j++];
        }

        while(k <= mid){
            help[i++] = arr[k++];
        }

        while(j <= hi){
            help[i++] = arr[j++];
        }

        for(int index = 0; index < help.length;index++){
            arr[lo++] = help[index];
        }
    }

    public static void mergeSort02(int[] arr){
        if(arr == null || arr.length < 2) return;
        int N = arr.length;
        int size = 1;
        while(size < N){
            int lo = 0;
            while(lo < N){
                if(size >= N - lo) break;
                int M = lo + size - 1;
                int hi = M + Math.min(size,N - M -1);
                merge(arr,lo,M,hi);
                lo = hi + 1;
            }
            if(size > N / 2){break;}
            size <<= 1;
        }
    }
}

class Verifier01 {

    //1.用于测试的排序方法：绝对正确，但复杂度或许不是很好
    public static void sort(int[] arr){
        Arrays.sort(arr);
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
