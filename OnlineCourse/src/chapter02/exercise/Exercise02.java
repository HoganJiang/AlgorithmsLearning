package chapter02.exercise;

import java.util.ArrayList;
import java.util.List;

public class Exercise02 {
    public static void main(String[] args) {
        int len = 50;
        int value = 100;
        int testTime = 100000;
        System.out.println("test begin!");
        for (int i = 0; i < testTime; i++) {
            Node node1 = generateRandomDoubleLinkedList(len, value);
            List<Integer> list1 = getOriginListOrder(node1);
            node1 = reverse(node1);
            if (!checkReverse(list1, node1)) {
                System.out.println("Oops1!");
            }

            Node node2 = generateRandomDoubleLinkedList(len,value);
            List<Integer> list2 = getOriginListOrder(node2);
            node2 = testReverse(node2);
            if (!checkReverse(list2, node2)) {
                System.out.println("Oops2!");
            }
        }
        System.out.println("test finish!");
    }

    public static class Node{
        public int value;
        public Node pre;
        public Node next;
        public Node(int value){
            this.value = value;
        }
    }

    public static Node reverse(Node head){
        Node pre = null;
        Node next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }

        return pre;

    }

    public static Node generateRandomDoubleLinkedList(int len, int val){
        int size = (int)(Math.random() * (len + 1));
        if (size == 0) return null;
        size--;
        Node head = new Node((int)(Math.random() * (val + 1)));
        Node pre = head;
        while(size != 0){
            Node next = new Node((int)(Math.random() * (val + 1)));
            pre.next = next;
            next.pre = pre;
            pre = next;
            size--;
        }
        return head;
    }

    public static Node testReverse(Node head){
        if(head == null) return null;
        ArrayList<Node> arrayList = new ArrayList<>();
        while(head != null){
            arrayList.add(head);
            head = head.next;
        }
        int size = arrayList.size();
        Node pre = arrayList.get(0);
        arrayList.get(0).next = null;
        for(int i = 1; i < size; i++){
            Node cur = arrayList.get(i);
            cur.pre = null;
            cur.next = pre;
            pre.pre = cur;
            pre = cur;
        }
        return arrayList.get(size - 1);
    }

    public static List<Integer> getOriginListOrder(Node head){
        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.value);
            head = head.next;
        }
        return list;
    }

    public static boolean checkReverse(List<Integer> originalList, Node head){
        Node end = null;
        for (int i = originalList.size() - 1; i >= 0; i--) {
            if (!originalList.get(i).equals(head.value)) {
                return false;
            }
            end = head;
            head = head.next;
        }
        for (int i = 0; i < originalList.size(); i++) {
            if (!originalList.get(i).equals(end.value)) {
                return false;
            }
            end = end.pre;
        }
        return true;
    }
}
