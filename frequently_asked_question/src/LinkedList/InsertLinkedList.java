package LinkedList;

import static LinkedList.ArrayToLinkedList.arrayToLinkedList;
import static LinkedList.ArrayToLinkedList.printLinkedList;

public class InsertLinkedList {
    public static Node insertFirst(Node head, int data){
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
        // Time complexity: O(1)
    }

    public static Node insertEnd(Node head, int data){
        if(head == null) return new Node(data);

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = new Node(data);

        return head;
    }

    public static Node insertIndex(Node head, int data, int index){
        if(head == null) return new Node(data);

        // If index is 0, then insert at the beginning
        if(index == 0){
            Node newNode = new Node(data);
            newNode.next = head;
            return newNode;
        }

        Node temp = head;

        // Traverse to the element before the index
        for(int i = 0; i < index - 1; i++){
            // edge case: if the index is out of bounds
            if(temp.next == null) return head;
            temp = temp.next;
        }

        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }

    public static Node insertAfterValue(Node head, int data, int val) {
        if (head == null) return new Node(data);

        Node temp = head;

        // Traverse to the element with the value
        while (temp != null && temp.data != val) {
            temp = temp.next;
        }

        // If the value is not found, return the original linked list
        if (temp == null) return head;

        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        Node head = arrayToLinkedList(arr);

        System.out.println("Before insertion");
        printLinkedList(head);

        head = insertFirst(head, 0);
        System.out.println("After insertion");
        printLinkedList(head);

        head = insertEnd(head, 6);
        System.out.println("After insertion");
        printLinkedList(head);

        head = insertIndex(head, 10, 3);
        System.out.println("After insertion");
        printLinkedList(head);

        head = insertAfterValue(head, 11, 4);
        System.out.println("After insertion");
        printLinkedList(head);
    }
}
