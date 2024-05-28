package chapter09.exercise;

public class Exercise03 {

    public static int lowestLight(String road){
        char[] roads = road.toCharArray();
        int index = 0;
        int light = 0;
        while(index < roads.length){
            if(roads[index] == 'X'){
                index++;
            } else {
                light++;
                if((index + 1) == road.length()){
                    break;
                }else{
                    if((roads[index + 1] == 'X')){
                        index = index + 2;
                    } else {
                        index = index + 1;
                    }
                }
            }
        }
        return light;
    }
}
