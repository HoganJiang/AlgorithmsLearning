package chapter05.exericse;

import java.util.Arrays;

public class Exercise02 {
    public static void main(String[] args) {
        int testTime = 1;
        int maxLen = 200;
        int maxValue = 150;
        boolean succeed = true;
        for(int i = 0; i <testTime; i++){
            int[] randomArray = Verifier02.generateRandomArray(maxLen, maxValue);
            int[] copyArray = Verifier02.copyArray(randomArray);
            CountingSort.countingSort(randomArray);
            Verifier02.sort(copyArray);
            if(!Verifier02.isEqual(randomArray,copyArray)){
                succeed = false;
                Verifier02.printArray(randomArray);
                Verifier02.printArray(copyArray);
                break;
            }
        }
        System.out.println(succeed == true? "perfect!" : "test failed!");
    }
}

class CountingSort {

    public static void countingSort(int[] arr){
        if(arr == null || arr.length < 2) return;
        //（1）申请长度为原数组最大值加1的辅助数组
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max,arr[i]);
        }
        int[] help = new int[max + 1];//此处一定记得 + 1
        //（2）迭代原数组中的每个元素，累加每个元素出现的频次，并将该元素的频次记录在辅助数组中对应的位置，如：原数组中10的频次为3，则在辅助数组中索引为10的位置存储3
        for(int i = 0; i < arr.length;i++){
            help[arr[i]] += 1;
        }
        //（3）将辅助数组的索引以从小到大的顺序，按照出现的频次依次拷贝回原数组中，使得原数组最终有序
//        for(int i = 0; i < help.length; i++){
//            int value = help[i];
//            for(int j = 0; j < value; j++){
//                arr[j] = i;
//            }
//        }
        int i = 0;
        for (int j = 0; j < help.length; j++) {
            //只有辅助数组中的元素值总是大于0时，才需要把辅助数组的元素对应的索引值拷回到原数组
            while (help[j]-- > 0) {
                arr[i++] = j;//i记录上次拷贝的位置
            }
        }
    }
}

class Verifier02 {
    //1.用于测试的排序方法：绝对正确，但复杂度或许不是很好
    public static void sort(int[] arr){
        Arrays.sort(arr);
    }

    //2.生成随机样本：长度随机，存储的值随机的数组
    public static int[] generateRandomArray(int maxLen, int maxValue){
        int[] randomArr = new int[(int)(Math.random() * (maxLen + 1))];
        for(int i = 0; i < randomArr.length; i++){
            randomArr[i] = (int)(Math.random() * (maxValue + 1));
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