package chapter01.exercise;

import java.util.Arrays;

public class Exercise02 {
    public static void main(String[] args) {
        int maxSize = 100;
        int maxValue = 1000;
        int times = 500000;
        boolean succeed = true;
        for(int i = 0; i < times; i++) {
            int[] arr1 = Verifier02.generateRandomArray(maxSize, maxValue);
//            Arrays.sort(arr1);
//            int val = (int)((maxValue + 1) * Math.random()) - (int)((maxValue) * Math.random());
            //题1的验证
//            if(Verifier02.test1(arr1,val) != BinarySearch.isExist(arr1,val)){
//                succeed = false;
//                break;
//            }
            //题2的验证
//            if(Verifier02.test2(arr1,val) != BinarySearch.findLeftIndex(arr1,val)){
//                Verifier02.printArr(arr1);
//                System.out.println(val);
//                System.out.println(Verifier02.test2(arr1,val));
//                System.out.println(BinarySearch.findLeftIndex(arr1,val));
//                succeed = false;
//                break;
//            }

            //题3的验证
//            if(Verifier02.test3(arr1,val) != BinarySearch.findRightIndex(arr1,val)){
//                Verifier02.printArr(arr1);
//                System.out.println(val);
//                System.out.println(Verifier02.test2(arr1,val));
//                System.out.println(BinarySearch.findRightIndex(arr1,val));
//                succeed = false;
//                break;
//            }
            //题4的验证:
            int partialMinIndex = BinarySearch.findPartialMin(arr1);
            if(!Verifier02.test4(arr1,partialMinIndex)){
                Verifier02.printArr(arr1);
                System.out.println(partialMinIndex);
                succeed = false;
            }
        }
        System.out.println(succeed? "good!" : "damn it!");
    }
}

class BinarySearch {

    //题1：在一个有序的数组中，查找某个数是否存在
    public static boolean isExist(int[] arr, int key){

        if(arr == null || arr.length == 0) return false;

        int lo = 0;
        int hi = arr.length - 1;
        int mid = 0;

        while(lo <= hi){
            mid = lo + ((hi - lo) >> 1);
            if(key > arr[mid]) lo = mid + 1;
            else if(key < arr[mid]) hi = mid - 1;
            else return true;
        }

        return false;
    }

    //题2：在一个有序数组中，找到>=某个数最左侧的位置
    public static int findLeftIndex(int[] arr, int key){

        if(arr == null || arr.length == 0) return -1;

        int lo = 0;
        int hi = arr.length - 1;
        int index = -1;
        int mid = 0;

        while(lo <= hi){
            mid = lo + ((hi - lo) >> 1);
            if(key > arr[mid]){
                lo = mid + 1;
            } else{
                index = mid;
                hi = mid - 1;
            }
        }

        return index;

    }

    //题3：在一个有序数组中，找到<=某个数最右侧的位置
    public static int findRightIndex(int[] arr, int key){

        if(arr == null || arr.length == 0) return -1;

        int lo = 0;
        int hi = arr.length - 1;
        int index = -1;
        int mid = 0;

        //第一种错误方案：
//        while(lo <= hi){
//            mid = (lo + hi) / 2;
//            if (key > arr[mid]) lo = mid + 1;
//            else if (key < arr[mid]) hi = mid - 1;
//            else index = mid;
//        }
//
//        return index - 1 < 0? -1 : index - 1;
        //第二种方案：
        while (lo <= hi){
            mid = lo + ((hi - lo) >> 1);
            if(key >= arr[mid]) {
                index = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return index;

    }

    //题4：局部最小值问题：存在一个无序的数组，相邻两个数不相等，若0位置比1位置的数小，则局部最小为0；
    //若某个中间位置的数比邻近左边的数和右边的数都大，则局部最小为mid；若n - 1位置比n - 2位置的数
    //小，则局部最小为n - 1;
    public static int findPartialMin(int[] arr){

        if(arr == null || arr.length == 0) return -1;

        if(arr.length == 1 || arr[0] < arr[1]) return 0;

        if(arr[arr.length - 1] < arr[arr.length - 2]) return arr.length - 1;

        int lo = 1;
        int hi = arr.length - 2;
        int mid = 0;

        while (lo < hi){
            mid = lo + ((hi - lo) >> 1);
            if (arr[mid] > arr[mid + 1]) lo = mid + 1;
            else if (arr[mid] > arr[mid - 1]) hi = mid - 1;
            else return mid;
        }

        return lo;

    }

}

class Verifier02 {

    public static int[] generateRandomArray(int maxSize, int maxValue){

        int[] arr = new int[(int)((maxSize + 1) * Math.random())];

        for(int i = 0; i < arr.length; i++){
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)((maxValue) * Math.random());
        }

        return arr;
    }

    public static boolean test1(int[] arr, int key){
        for(int k : arr){
            if(k == key){
                return true;
            }
        }
        return false;
    }

    public static int test2(int[] arr, int key){
        for(int i = 0; i < arr.length; i++){
            if (arr[i] >= key){
                return i;
            }
        }
        return -1;
    }

    public static int test3(int[] arr, int key){
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= key) {
                return i;
            }
        }
        return -1;
    }

    public static boolean test4(int[] arr, int index){
        if(index == -1 && (arr == null || arr.length == 0)) return true;
        else if(index == 0 && (arr.length == 1 || arr[index] < arr[index + 1])) return true;
        else if(index == 1 && arr.length == 2) return true;
        else if(index == arr.length - 1 && (arr[arr.length - 1] < arr[arr.length - 2])) return true;
        else if(arr[index] <= arr[index + 1] && arr[index] <= arr[index - 1]) return true;
        else return false;
    }

    public static void printArr(int[] arr){

        if(arr == null) return;

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println();

    }

}