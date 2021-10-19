package chapter09.exercise;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Exercise05 {

    public static class Program {
        private int cost;
        private int profit;

        public Program(int cost, int profit){
            this.cost = cost;
            this.profit = profit;
        }
    }

    public static class MyCostComparator implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o1.cost - o2.cost;
        }
    }

    public static class MyProfitComparator implements Comparator<Program>{

        @Override
        public int compare(Program o1, Program o2) {
            return o2.profit - o2.profit;
        }
    }

    public static int getMostMoney(int w, int k, int[] cost, int[] profit){
        PriorityQueue<Program> minCostQueue = new PriorityQueue<>(new MyCostComparator());
        PriorityQueue<Program> maxProfitQueue = new PriorityQueue<>(new MyProfitComparator());
        for(int i = 0; i < cost.length; i++){
            minCostQueue.add(new Program(cost[i],profit[i]));
        }
        for(int i = 0; i < k; i++){
            while(!minCostQueue.isEmpty() && minCostQueue.peek().cost <= w){
                maxProfitQueue.add(minCostQueue.poll());
            }
            if(maxProfitQueue.isEmpty()){
                return w;
            }
            w += maxProfitQueue.poll().profit;
        }
        return w;
    }

}
