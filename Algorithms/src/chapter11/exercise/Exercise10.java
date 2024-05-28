package chapter11.exercise;

public class Exercise10 {

    public static int winnerCore(int[] arr){
        return Math.max(f(arr,0,arr.length -1),s(arr,0,arr.length -1));
    }

    public static int f(int[] arr, int L, int R){
        if(L==R){
            return arr[L];
        }
        return Math.max(arr[L] + s(arr,L+1,R),arr[R] + s(arr,L,R-1));
    }

    public static int s(int[] arr, int L,int R){
        if(L==R) return 0;
        return Math.min(f(arr,L+1,R),f(arr,L,R-1));
    }

    public static void main(String[] args) {
        int[] arr = { 4,7,9,6 };
        System.out.println(winnerCore(arr));
    }

}
