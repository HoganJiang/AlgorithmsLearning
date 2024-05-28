package chapter02.exercise;

import java.util.ArrayList;
import java.util.List;

public class Exercise01 {
    public static void main(String[] args) {
        int len = 50;
        int value = 100;
        int testTime = 100000;
        System.out.println("test begin!");
        for (int i = 0; i < testTime; i++) {
            Node node1 = generateRandomSingleNodeLinkedList(len, value);
            List<Integer> list1 = getOriginalOrder(node1);
            node1 = reverse(node1);
            if (!checkReverse(list1, node1)) {
                System.out.println("Oops1!");
            }

            Node node2 = generateRandomSingleNodeLinkedList(len,value);
            List<Integer> list2 = getOriginalOrder(node2);
            node2 = testReverse(node2);
            if (!checkReverse(list2, node2)) {
                System.out.println("Oops2!");
            }
        }
        System.out.println("test finish!");
    }

    public static class Node {
        public int value;
        public Node next;
        public Node(int value){
            this.value = value;
        }
    }

    public static Node reverse(Node head){

        Node pre = null;

        while (head != null){
            Node next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    public static Node generateRandomSingleNodeLinkedList(int len, int value){
        int size = (int)(Math.random() * (len + 1));
        if(size == 0) return null;
        size--;
        Node head = new Node((int)(Math.random() * (value + 1)));
        Node pre = head;
        while(size != 0){
            Node cur = new Node((int)(Math.random() * (value + 1)));
            pre.next = cur;
            size--;
        }
        return head;
    }

    public static Node testReverse(Node head){
        if (head == null) return null;
        ArrayList<Node> arrayList = new ArrayList<>();
        while (head != null){
            arrayList.add(head);
            head = head.next;
        }
        arrayList.get(0).next = null;
        int size = arrayList.size();
        for(int i = 1; i < size; i++){
            arrayList.get(i).next = arrayList.get(i - 1);
        }
        return arrayList.get(size - 1);
    }

    public static List<Integer> getOriginalOrder(Node head){
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.value);
            head = head.next;
        }
        return list;
    }

    public static boolean checkReverse(List<Integer> originalList, Node head){
        for(int i = originalList.size() - 1; i >= 0; i--){
            if(!originalList.get(i).equals(head.value)){
                return false;
            }
            head = head.next;
        }
        return true;
    }

}

