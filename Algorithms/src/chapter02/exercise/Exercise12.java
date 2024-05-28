package chapter02.exercise;

public class Exercise12 {

    public static int getMax(int[] arr){
        return getMax(arr, 0,arr.length - 1);
    }

    public static int getMax(int[] arr, int lo, int hi){
        if(lo == hi) return arr[lo];
        int mid = lo + ((hi - lo) >> 1);
        int leftMax = getMax(arr,lo,mid - 1);
        int rightMax = getMax(arr,mid + 1, hi);
        return Math.min(leftMax, rightMax);
    }
}
