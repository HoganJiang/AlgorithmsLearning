package chapter02.exercise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Exercise03 {

    public static void main(String[] args) {

        int len = 50;
        int value = 100;
        int testTimes = 100000;
        for(int i = 0; i < testTimes; i++){
            int randomValue = (int)(Math.random() * (value + 1));
            Node head = generateRandomSingleNodeLinkedList(len, value);
            List<Node> testLinkedLists = testDelete(head, randomValue);
            Node deletedLinkedList = delete(head, randomValue);
            if(!checkDelete(testLinkedLists,deletedLinkedList)){
                System.out.println("damn it!");
            }
        }
        System.out.println("nice!");
    }

    public static class Node {
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public static Node delete(Node head, int item){
        while(head != null){
            if(head.value != item) break;
            head = head.next;
        }

        Node cur = head;
        Node pre = head;
        while(cur != null){
            if(cur.value == item) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
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

    public static List<Node> testDelete(Node head, int item){
        if(head == null) return null;
        List<Node> list = new ArrayList<>();
        while(head != null){
            list.add(head);
            head = head.next;
        }

        for(Node node : list){
            if(node.value == item){
                list.remove(node);
            }
        }

//        for(Iterator<Node> iterator = list.iterator(); iterator.hasNext();) {
//            Node node = iterator.next();
//            if(node.value == item){
//                iterator.remove();
//            }
//        }
        return list;
    }

    public static boolean checkDelete(List<Node> testLinkedList, Node head){

        if(testLinkedList != null && head != null){
            for(Node node : testLinkedList){
                if(node.value != head.value) return false;
                head = head.next;
            }
        }
        return true;
    }


}
