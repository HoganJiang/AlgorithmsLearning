package chapter06.exercise;

public class Exercise03 {

    public static class Node {
        private int value;
        private Node next;

        public Node(int vale){
            this.value = vale;
        }
    }

    public static Node smallMidBig(Node head, int k){
        if(head == null) return null;

        Node cur = head;
        int cnt = 0;
        while(cur != null){
            cnt++;
            cur = cur.next;
        }
        Node[] list = new Node[cnt];
        cur = head;
        for(int i = 0; i < list.length; i++){
            list[i] = cur;
            cur = cur.next;
        }
        partition(list, k);
        for(int i = 1; i < list.length;i++){
            list[i - 1].next = list[i];
        }
        list[list.length - 1].next = null;
        return list[0];
    }

    public static void partition(Node[] node, int k){
        int smallArea = -1;
        int bigArea = node.length;
        int index = 0;
        while(index != bigArea){
            if(node[index].value < node[k].value){
                swap(node,++smallArea,index++);
            } else if (node[index].value == node[k].value){
                index++;
            } else {
                swap(node, --bigArea, index);
            }
        }
    }

    public static void swap(Node[] arr, int i, int j){
        Node tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = arr[i];
    }

}
