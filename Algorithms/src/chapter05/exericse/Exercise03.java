package chapter05.exericse;

import java.util.Arrays;

public class Exercise03 {
    public static void main(String[] args) {
        int testTime = 500000;
        int maxLen = 100;
        int maxValue = 100000;
        boolean succeed = true;
        for(int i = 0; i <testTime; i++){
            int[] randomArray = Verifier03.generateRandomArray(maxLen, maxValue);
            int[] copyArray = Verifier03.copyArray(randomArray);
            RadixSort.radixSorting(randomArray);
            Verifier03.sort(copyArray);
            if(!Verifier03.isEqual(randomArray,copyArray)){
                succeed = false;
                Verifier03.printArray(randomArray);
                Verifier03.printArray(copyArray);
                break;
            }
        }
        System.out.println(succeed == true? "perfect!" : "test failed!");
    }
}

class RadixSort{

    public static void radixSorting(int[] arr){
        if(arr == null || arr.length < 2) return;
        //1. 获取数组中最大元素的位数
        int maxDigit = getMaxDigit(arr);
        //2. 对原数组从0..arr.length进行排序
        radixSorting(arr,0,arr.length - 1,maxDigit);
    }

    public static void radixSorting(int[]arr,int l, int r, int digit){
        //1. 申请10位长度的数组，用以统计数组中每个元素从高位到低位出现的频次，以及统计小于等与索引位元素的累加和
        final int radix = 10;
        //2. 申请r - l + 1长度的辅助数组，用以存储出桶后的数据元素
        int[] help = new int[r - l + 1];
        //3. 基数排序
        for(int i = 1; i <= digit; i++){//从低位到高位一共迭代的次数：1表示个位
            int[] count = new int[radix];
            //3.1 从L到R依次获取从低位到高位的元素并统计其词频
            for(int j = l; j <= r; j++){
                int k = getNumberOfDigit(arr[j],i);
                count[k]++;
            }
            //3.2 计算count中每个元素的前缀和
            for(int j = 1; j < count.length; j++){
                count[j] = count[j] + count[j - 1];
            }
            //3.3 从R到L按照从低位到高位依次将原数组中的元素存放到辅助数组
            for(int j = r; j >= l; j--){
                int d = getNumberOfDigit(arr[j], i);
                help[count[d] - 1] = arr[j];
                count[d]--;
            }
            //3.4 将辅助数组中的元素依次拷贝到原数组中
            for(int j = l, k = 0; j <= r; j++,k++){
                arr[j] = help[k];
            }
        }
    }
    public static int getMaxDigit(int[] arr){
        //1.获取数组中元素的最大值
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        //2. 计算最大值的位数
        int digit = 0;
        while(max != 0){
            digit++;
            max /= 10;
        }
        return digit;
    }

    public static int getNumberOfDigit(int number, int digit){
        return (int)((number / Math.pow(10,digit - 1)) % 10);
    }

}

class Verifier03 {

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
