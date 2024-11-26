package LinkedList;

import static LinkedList.ArrayToLinkedList.arrayToLinkedList;
import static LinkedList.ArrayToLinkedList.printLinkedList;

public class LinkedListDeletion {

    public static Node deleteFirst(Node head){
        if(head == null) return null;
        return head.next;
        // Time complexity: O(1)
    }

    public static Node deleteLast(Node head){
        if(head == null || head.next == null) return null;
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }

        temp.next = null;

        return head;
    }

    public static Node deleteIndex(Node head, int index){
        if(head == null) return null;

        // If index is 0, then delete the first element
        if(index == 0) return head.next;


        Node temp = head;

        // Traverse to the element before the index
        for(int i = 0; i < index - 1; i++){
            // edge case: if the index is out of bounds
            if(temp.next == null) return head;
            temp = temp.next;
        }


         temp.next = temp.next.next;

        return head;
    }

    public static Node deleteValue(Node head, int val){
        if(head == null) return null;

        // If the value is at the head, then delete the head
        if(head.data == val) return head.next;

        Node temp = head;

        // Traverse to the element before the value
        while(temp.next != null && temp.next.data != val){
            temp = temp.next;
        }

        // edge case: if the value is not present in the linked list
        if(temp.next != null) temp.next = temp.next.next;

        return head;
    }

    public static void deleteNode(Node node){
        // edge case: if the node is the last node
        if(node == null || node.next == null) return;

        // Copy the data of the next node to the current node
        node.data = node.next.data;

        // Delete the next node
        node.next = node.next.next;
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};

        Node head = arrayToLinkedList(arr);

        System.out.println("Before deletion");
        printLinkedList(head);
//
//        head = deleteFirst(head);
//        System.out.println("After deletion of first element");
//        printLinkedList(head);
//
//
//        head = deleteLast(head);
//        System.out.println("After deletion of last element");
//        printLinkedList(head);
//
//        head = deleteIndex(head, 10);
//        System.out.println("After deletion of element at index 1");
//        printLinkedList(head);
//
//        head = deleteValue(head, 10);
//        System.out.println("After deletion of element with value 3");
//        printLinkedList(head);

        Node node = head.next.next.next.next.next;
        deleteNode(node);
        System.out.println("After deletion of node with value 3");
        printLinkedList(head);



    }
}
