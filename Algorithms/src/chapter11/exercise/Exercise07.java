package chapter11.exercise;

import java.util.ArrayList;
import java.util.HashSet;

public class Exercise07 {

    public static HashSet<String> permutationNoRepeat(String str){
//        ArrayList<String> ans = new ArrayList<>();
        HashSet<String> ans = new HashSet<>();
        if(str == null || str.length() == 0) return null;
        char[] string = str.toCharArray();
        process(string,0,ans);
        return ans;
    }

    public static void process(char[] str, int index, HashSet<String> ans){
        if(index == str.length) {
            ans.add(String.valueOf(str));
        }
//        boolean[] visit = new boolean[26];
        for(int j = index; j < str.length;j++){
//            if(!visit[str[j] - 'a']){
//                visit[str[j] - 'a'] = true;
                swap(str,index,j);
                process(str,index + 1,ans);
                swap(str,index,j);
//            }
        }
    }

    public static void swap(char[] str, int i, int j){
        char t = str[i];
        str[i] = str[j];
        str[j] = t;
    }

    public static void main(String[] args) {
        String s = "aac";
        System.out.println(permutationNoRepeat(s));
    }

}
