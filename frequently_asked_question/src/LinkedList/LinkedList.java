package LinkedList;

public class LinkedList {
    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);

        System.out.println(head.data); // 1
        System.out.println(head.next); // Node
        System.out.println(head.next.data); // 2
        System.out.println(head.next.next); // null
    }
}
