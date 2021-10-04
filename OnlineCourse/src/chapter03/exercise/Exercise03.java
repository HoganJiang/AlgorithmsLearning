package chapter03.exercise;

public class Exercise03 {
    public static void main(String[] args) {
        int testTime = 500000;
        int maxLen = 100;
        int maxValue = 100000;
        boolean succeed = true;
        for(int i = 0; i <testTime; i++){
            int[] randomArray = Verifier03.generateRandomArray(maxLen, maxValue);
            int[] copyArray = Verifier03.copyArray(randomArray);
            if(ReservePari.getDescendingCounts(randomArray) != Verifier03.getDescendingCounts(copyArray)){
                succeed = false;
                Verifier03.printArray(randomArray);
                Verifier03.printArray(copyArray);
                break;
            }
        }
        System.out.println(succeed == true? "perfect!" : "test failed!");
    }
}

class ReservePari {

    public static int getDescendingCounts(int[] arr){
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

        int i = help.length - 1;
        int k = mid;
        int j = hi;
        int cnt = 0;
        while(k >= lo && j > mid){
            cnt += arr[k] > arr[j]? (j - mid) : 0;
            help[i--] = arr[k] > arr[j] ? arr[k--] : arr[j--];
        }

        while(k >= lo){
            help[i--] = arr[k--];
        }

        while(j > mid){
            help[i--] = arr[j--];
        }

        for(int index = 0; index < help.length;index++){
            arr[lo+index] = help[index];
        }

        return cnt;
    }
}

class Verifier03 {

    //1.用于测试的排序方法：绝对正确，但复杂度或许不是很好
    public static int getDescendingCounts(int[] arr){
        int cnt = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] > arr[j]) {cnt++;}
            }
        }
        return cnt;
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
