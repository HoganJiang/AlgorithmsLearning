package chapter09.exercise;

import java.util.Arrays;
import java.util.Comparator;

public class Exercise02 {

    public static class Program {
        private int startTime;
        private int endTime;

        public Program(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static class myComparator implements Comparator<Program>{

        @Override
        public int compare(Program o1, Program o2) {
            return o1.endTime - o2.endTime;
        }
    }

    public static int getMaxMeetingCounts1(Program[] programs){
        Arrays.sort(programs,new myComparator());
        int ans = 0;
        int timeLine = 0;
        for(int i = 0; i < programs.length;i++){
            if(timeLine <= programs[i].startTime){
                ans++;
                timeLine = programs[i].endTime;
            }
        }
        return ans;
    }

    public static int getMaxArrangeCounts2(Program[] programs){
        if (programs == null || programs.length == 0) return 0;
        return process(programs, 0,0);
    }

    /**
     * 暴力枚举每个Program的情况
     * @param programs 剩下没有安排的Program
     * @param done 已经安排了Program的数量
     * @param timeLine 安排会议之后的时间点
     * @return 能够安排的最多的会议的场次
     */
    public static int process(Program[] programs, int done, int timeLine){
        if(programs.length == 0) return done;
        int max = done;
        for(int i = 0; i < programs.length;i++){
            if(timeLine <= programs[i].startTime){
                Program[] restPrograms = copyButExcept(programs,i);
                max = Math.max(max, process(restPrograms,done + 1,programs[i].endTime));
            }
        }
        return max;
    }

    public static Program[] copyButExcept(Program[] programs, int i){
        Program[] res = new Program[programs.length - 1];
        int index = 0;
        for(int k = 0; k < programs.length;k++){
            if(k != i){
                res[index++] = programs[k];
            }
        }
        return res;
    }

    /**
     * 自己实现的方法的缺点：
     * 1. 没有考虑startTime与endTime相等的情况
     * 2. maxValue - 1 更是有可能导致数组的长度为负数
     * @param maxSize
     * @param maxValue
     * @return
     */
//    public static Program[] generateRandomProgram(int maxSize, int maxValue){
//        int length = (int) (Math.random() * maxSize);
//        Program[] programs = new Program[length];
//        for(int i = 0; i < programs.length;i++){
//            programs[i].startTime = (int)(Math.random() * (maxValue - 1));//maxValue - 1 有可能为负数
//            programs[i].endTime = (int)(Math.random() * (maxValue));
//        }
//        return programs;
//    }

    public static Program[] generateRandomProgram(int maxSize, int maxValue){
        Program[] programs = new Program[(int) (Math.random() * (maxSize + 1))];
        for(int i = 0; i < programs.length;i++){
            int startTime = (int)(Math.random() * (maxValue + 1));
            int endTime = (int)(Math.random() * (maxValue + 1));
            if(startTime == endTime) {
                programs[i] = new Program(startTime,endTime + 1);
            } else {
                programs[i] = new Program(Math.min(startTime,endTime),Math.max(startTime,endTime));
            }
        }
        return programs;
    }

    public static void main(String[] args) {
        int maxSize = 20;
        int maxValue = 15;
        int testTime = 1000000;
        for(int i = 0; i < testTime; i++){
            Program[] randomPrograms = generateRandomProgram(maxSize, maxValue);
            if(getMaxMeetingCounts1(randomPrograms) != getMaxArrangeCounts2(randomPrograms)){
                System.out.println("Test failed!");
            }
        }
        System.out.println("Congratulation!");
    }

}
