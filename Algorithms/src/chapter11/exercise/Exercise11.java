package chapter11.exercise;

public class Exercise11 {

    public static int nQueen(int N){
        if(N < 1) return 0;
        int[] record = new int[N];
        return process1(0,record,N);
    }

    public static int process1(int i, int[] record, int n){
        if(i == n){
            return 1;
        }
        int ans = 0;
        for(int j = 0; j < n; j++){
            if(isValid(record,i,j)){
                record[i] = j;
                ans += process1(i + 1,record,n);
            }
        }
        return ans;
    }

    public static boolean isValid(int[] record, int i, int j){
        for(int k = 0; k < i; k++){
            if(j == record[k] || (Math.abs(i -k) == Math.abs(record[k] - j))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        int n = 4;
        System.out.println(nQueen(n));
    }

}
