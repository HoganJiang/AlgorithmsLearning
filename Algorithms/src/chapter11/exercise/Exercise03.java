package chapter11.exercise;

public class Exercise03 {

    public static void printAllSubString(String str){
        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length; i++){
            StringBuilder subString = new StringBuilder(chars[i]);
            for(int j = i; j < chars.length; j++){
                subString.append(chars[j]);
                System.out.print(subString.toString() + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String str = "ABCD";
        printAllSubString(str);
    }

}
