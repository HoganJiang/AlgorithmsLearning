package chapter11.exercise;

public class Exercise09 {

    public static int getMaxValue(int[] weight, int[] value, int bag){
        return process(weight,value,bag,0,0);
    }

    public static int process(int[] weight, int[] value, int bag, int index, int wSum){

        if(wSum > bag){
            return -1;
        }

        if(index == weight.length){
            return 0;
        }

        int p1 = process(weight, value, bag, index + 1, wSum);
        int p2 = process(weight, value, bag, index + 1, wSum + weight[index]);
        int yes = -1;
        if(p2 != -1){
            yes = value[index] + p2;
        }

        return Math.max(p1,yes);
    }

    public static void main(String[] args) {
        int[] weights = { 3, 2, 4, 7 };
        int[] values = { 5, 6, 3, 19 };
        int bag = 11;
        System.out.println(getMaxValue(weights, values, bag));
    }
}
