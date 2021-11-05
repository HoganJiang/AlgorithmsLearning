package chapter11.exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Exercise05 {

    public static List<String> printAllSubSequence(String str){
        char[] chars = str.toCharArray();
        String path = "";
        HashSet<String> set = new HashSet<>();
        process(chars,0,set,path);
        List<String> ans = new ArrayList<>();
        for(String cur : set){
            ans.add(cur);
        }
        return ans;
    }

    public static void process(char[] chars, int index, HashSet<String> ans, String path){
        if(index == chars.length){
            ans.add(path);
            return;
        }
        String no = path;
        process(chars,index + 1,ans,no);
        String yes = path + String.valueOf(chars[index]);
        process(chars,index + 1,ans,yes);
    }

    public static void main(String[] args) {
        String test = "aaa";
        List<String> ans1 = printAllSubSequence(test);
        for (String str : ans1) {
            System.out.println(str);
        }
    }

}
