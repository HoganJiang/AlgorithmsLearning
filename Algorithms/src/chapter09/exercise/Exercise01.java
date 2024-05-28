package chapter09.exercise;

import java.util.Arrays;
import java.util.Comparator;

public class Exercise01 {

    public static class MyComparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }
    }

    public static String lowestString(String[] str){
        if(str == null || str.length == 0) return "";
        Arrays.sort(str,((String o1, String o2) -> {
            return (o1 + o2).compareTo(o2 + o1);
        } ));
        String ans = "";
        for(int i = 0; i < str.length; i++){
            ans += str[i];
        }
        return ans;
    }

}
