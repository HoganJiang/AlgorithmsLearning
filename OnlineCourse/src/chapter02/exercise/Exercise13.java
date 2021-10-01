package chapter02.exercise;

import java.util.HashMap;
import java.util.TreeMap;

public class Exercise13 {

    public static class Node {
        public int value;

        public Node(int v) {
            value = v;
        }
    }

    public static class Zuo {
        public int value;

        public Zuo(int v) {
            value = v;
        }
    }

    public static void main(String[] args) {


        //HashMap：对于基础类型的包装类，是按照值传递
        HashMap<String,Integer> student = new HashMap<>();
        //put可以插入，亦可以更新
        student.put("xiaoming",10);
        student.put("xiaohua",15);
        student.put("xiaoqin",19);
        student.put("xiaoming",20);
        System.out.println(student.get("xiaoming"));
        System.out.println(student.containsKey("xiaoming"));

        student.remove("xiaoming");
        System.out.println(student.get("xiaoming"));

        //HashMap:对于非基础类型，是按照引用传递
        HashMap<Node, String> map2 = new HashMap<>();
        Node node1 = new Node(1);
        Node node2 = new Node(1);
        map2.put(node1, "我是node1");
        map2.put(node2, "我是node1");
        System.out.println(map2.size());

        System.out.println("======================");

        // TreeMap 有序表：接口名
        // 红黑树、avl、sb树、跳表
        // O(logN)
        System.out.println("有序表测试开始");
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(3, "我是3");
        treeMap.put(4, "我是4");
        treeMap.put(8, "我是8");
        treeMap.put(5, "我是5");
        treeMap.put(7, "我是7");
        treeMap.put(1, "我是1");
        treeMap.put(2, "我是2");

        System.out.println(treeMap.containsKey(1));
        System.out.println(treeMap.containsKey(10));

        System.out.println(treeMap.get(4));
        System.out.println(treeMap.get(10));

        treeMap.put(4, "他是4");
        System.out.println(treeMap.get(4));

        treeMap.remove(4);
        System.out.println(treeMap.get(4));

        System.out.println("新鲜：");

        System.out.println(treeMap.firstKey());
        System.out.println(treeMap.lastKey());
        // <= 4
        System.out.println(treeMap.floorKey(4));
        // >= 4
        System.out.println(treeMap.ceilingKey(4));

        //TreeMap
        TreeMap<Integer,Integer> account = new TreeMap<>();
        account.put(8,909);
        account.put(10,1001);
        account.put(8,1001);
        System.out.println(account.get(8));

        //TreeMap调用put接口，传入的对象要指定比较器
        TreeMap<Node, String> map3 = new TreeMap<>();
        Node node3 = new Node(1);
//        Node node4 = new Node(1);
        map3.put(node3, "我是node3");
//        map3.put(node4, "我是node4");
        System.out.println(map3.size());

    }
}
