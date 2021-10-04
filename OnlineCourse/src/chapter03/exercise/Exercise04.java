package chapter03.exercise;

import java.util.Arrays;
import java.util.Stack;

public class Exercise04 {
    public static void main(String[] args) {
        int maxLen = 100;
        int maxValue = 100000;
        int testTimes = 100;
        boolean succeed = true;
        for(int i = 0; i < testTimes; i++){
            int[] randomArray = Verifier04.generateRandomArray(maxLen, maxValue);
            int[] arr1 = Verifier04.copyArray(randomArray);
            int[] arr2 = Verifier04.copyArray(randomArray);
            int[] arr3 = Verifier04.copyArray(randomArray);
            int[] arr4 = Verifier04.copyArray(randomArray);
            RandomQuickSort.quickSort01(arr1);
            RandomQuickSort.quickSort02(arr2);
            RandomQuickSort.quickSort03(arr3);
            RandomQuickSort.quickSort04(arr4);
            if(!Verifier04.isEqual(arr1,arr2) || !Verifier04.isEqual(arr2,arr3) || !Verifier04.isEqual(arr3,arr4)){
                succeed = false;
                break;
            }
        }
        System.out.println(succeed == true? "test perfect!" : "test failed!");
    }
}

class RandomQuickSort {

    public static int partition(int[] arr, int lo, int hi){

        if(lo > hi) return -1;

        if(lo == hi) return lo;

        int left = lo - 1;
        int i = lo;

        while(i < hi){
            if(arr[i] <= arr[hi]){
                swap(arr,i,++left);
            }
            i++;
        }

        swap(arr,++left,hi);

        return left;
    }

    public static int[] netherlandsFlag(int[] arr, int lo, int hi){
        if(lo > hi) return new int[]{-1,-1};
        if(lo == hi) return new int[]{lo,hi};

        int left = lo - 1;
        int right = hi;
        int i = lo;

        while (i < right){
            if(arr[i] == arr[hi]){
                i++;
            } else if (arr[i] < arr[hi]){
                swap(arr,i++, ++left);
            } else {
                swap(arr,i,--right);
            }
        }
        swap(arr,right,hi);
        return new int[]{left + 1, right};
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort01(int[] arr){
        if(arr == null || arr.length < 2) return;
        process1(arr,0, arr.length - 1);
    }

    public static void process1(int[] arr, int lo, int hi){
        if(lo >= hi) return;
        int ans = partition(arr,lo, hi);
        process1(arr,lo,ans - 1);
        process1(arr,ans + 1,hi);
    }

    public static void quickSort02(int[] arr){
        if(arr == null || arr.length < 2) return;
        process2(arr, 0,arr.length-1);
    }

    public static void process2(int[] arr, int lo, int hi){
        if(lo >= hi) return;
        int[] ans = netherlandsFlag(arr,lo,hi);
        process2(arr,lo, ans[0] - 1);
        process2(arr,ans[1] + 1, hi);
    }

    public static void quickSort03(int[] arr){
        if(arr == null || arr.length < 2) return;
        process3(arr, 0,arr.length-1);
    }

    public static void process3(int[] arr, int lo, int hi){
        if(lo >= hi) return;
        swap(arr, lo + (int)(Math.random() * (hi - lo + 1)), hi);
        int[] ans = netherlandsFlag(arr,lo,hi);
        process3(arr, lo, ans[0] - 1);
        process3(arr, ans[1] + 1, hi);
    }

    public static class Op {
        public int l;
        public int r;

        public Op(int left, int right){
            this.l = left;
            this.r = right;
        }
    }
    public static void quickSort04(int[] arr){
        if(arr == null || arr.length < 2) return;

        int N = arr.length;
        swap(arr,(int)(Math.random() * N),N - 1);
        int[] equal = netherlandsFlag(arr, 0, N - 1);
        int equalLeft = equal[0];
        int equalRight = equal[1];
        Stack<Op> stack = new Stack<>();
        stack.push(new Op(0, (equalLeft - 1)));
        stack.push(new Op(equalRight + 1,(N - 1)));
        while(!stack.isEmpty()){
            Op op = stack.pop();
            if(op.l < op.r){
                swap(arr,op.l + (int)(Math.random() * (op.r - op.l + 1)), op.r);
                equal = netherlandsFlag(arr, op.l, op.r);
                equalLeft = equal[0];
                equalRight = equal[1];
                stack.push(new Op(op.l, equalLeft - 1));
                stack.push(new Op(equalRight + 1, op.r));
            }
        }

    }

}

class Verifier04 {
    public static int[] generateRandomArray(int maxLen, int maxValue){
        int[] randomArr = new int[(int)(Math.random() * (maxLen + 1))];
        for(int i = 0; i < randomArr.length; i++){
            randomArr[i] = (int)(Math.random() * (maxValue + 1)) - (int) (maxValue * Math.random());
        }
        return randomArr;
    }

    public static int[] copyArray(int[] arr){
        int[] copyArr = new int[arr.length];
        for(int i = 0; i < arr.length;i++){
            copyArr[i] = arr[i];
        }
        return copyArr;
    }

    public static boolean isEqual(int[] a, int[] b){
        if(a == null && b == null) return true;
        if(a == null || b == null) return false;
        if(a.length != b.length) return false;
        for(int i = 0; i < a.length;i++){
            if(a[i] != b[i]) return false;
        }
        return true;
    }

    public static void printArray(int[] arr){
        if(arr == null) return;
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}


