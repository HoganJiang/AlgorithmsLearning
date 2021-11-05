package chapter11.exercise;

public class Exercise01 {

    public static void hannuota(int N){
        process(N,"left","right","mid");
    }

    public static void process(int N, String from,String to,String other){
        if(N == 1) System.out.println("Move 1 from " + from + " to " + to);
        else {
            process(N - 1, from, other, to);
            System.out.println("Move " + N + " from " + from + " to " + to);
            process(N - 1, other, to, from);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        hannuota(n);
    }

}
