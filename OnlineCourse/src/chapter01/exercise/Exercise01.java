package chapter01.exercise;

import java.util.Arrays;

public class Exercise01 {
    public static void main(String[] args) {

        int maxSize = 100;
        int maxValue = 1000;
        int times = 50;
        boolean succeed = true;
        for(int i = 0; i < times; i++){
            int[] arr1 = Verifier01.generateRandomArray(100, 1000);
            int[] arr2 = Verifier01.copy(arr1);
            SelectionSort.selectionSort(arr1);
            BubbleSort.bubbleSort(arr1);
            InsertSort.insertSort(arr1);
            Verifier01.comparator(arr2);
            if(!Verifier01.isEqual(arr1,arr2)){
                succeed = false;
                Verifier01.printArr(arr1);
                Verifier01.printArr(arr2);
                break;
            }
        }
        System.out.println(succeed? "good!" : "damn it!");
    }
}

class SelectionSort {

    public static void selectionSort(int[] arr){

        if(arr == null || arr.length < 0) return;

        for(int i = 0; i < arr.length - 1; i++){
            int min = i;
            for(int j = i + 1; j < arr.length; j++){
                min = arr[min] > arr[j]? j : min;
            }
            swap(arr,i,min);
        }

    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

class BubbleSort {

    public static void bubbleSort(int[] arr){

        if(arr == null || arr.length < 0) return;

        for(int i = arr.length; i > 0; i--){
            for(int j = 0; j < i - 1; j++){
                if(arr[j] > arr[j + 1]) swap(arr,j,j + 1);
            }
        }

    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}

class InsertSort {

    public static void insertSort(int[] arr){

        if(arr == null || arr.length < 0) return;

        for(int i = 1; i < arr.length; i++){
            for(int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--){
                swap(arr,j,j+1);
            }
        }

    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}

class Verifier01 {

    public static int[] generateRandomArray(int maxSize, int maxValue){

        int[] arr = new int[(int)((maxSize + 1) * Math.random())];

        for(int i = 0; i < arr.length; i++){
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)((maxValue) * Math.random());
        }

        return arr;
    }

    public static int[] copy(int[] arr){

        if(arr == null) return null;

        int[] copyArr = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            copyArr[i] = arr[i];
        }

        return copyArr;
    }

    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }

    public static boolean isEqual(int[] a, int[] b){

        if(a == null && b == null) return true;

        if((a != null && b == null) || (a == null && b != null)) return false;

        if(a.length != b.length) return false;

        for(int i = 0; i < a.length; i++){
            if (a[i] != b[i]) return false;
        }

        return true;

    }

    public static void printArr(int[] arr){

        if(arr == null) return;

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println();

    }
}