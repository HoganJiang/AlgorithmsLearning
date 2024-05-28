package chapter02.exercise;

public class Exercise04 {

    public static void main(String[] args) {

    }

    public static class Node{
      public int value;
      public Node pre;
      public Node next;

      public Node(int value){
          this.value = value;
      }
    }

    public static Node delete(Node head, int val){
        if(head == null) return null;
        while(head != null){
            if(head.value != val) break;
            head = head.next;
        }
        Node cur = head;
        Node pre = head;
        while (cur != null){
            if(cur.value == val){
                pre.next = cur.next;
                cur.next.pre = pre;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }

        return head;
    }


}
