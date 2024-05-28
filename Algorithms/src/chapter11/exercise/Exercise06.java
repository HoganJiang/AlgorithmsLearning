package chapter11.exercise;

import java.util.ArrayList;

public class Exercise06 {

    public static ArrayList<String> permutation(String str){
        ArrayList<String> ans = new ArrayList<>();
        if(str == null || str.length() == 0) return null;
        char[] string = str.toCharArray();
        process(string,0,ans);
        return ans;
    }

    public static void process(char[] str, int index, ArrayList<String> ans){
        if(index == str.length) {
            ans.add(String.valueOf(str));
        }
        for(int j = index; j < str.length;j++){
            swap(str,index,j);
            process(str,index + 1,ans);
            swap(str,index,j);
        }
    }

    public static void swap(char[] str, int i, int j){
        char t = str[i];
        str[i] = str[j];
        str[j] = t;
    }

    public static void main(String[] args) {
        String s = "aac";
        System.out.println(permutation(s));
    }

}
