package LinkedList;

public class ArrayToLinkedList {
    public static Node arrayToLinkedList(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i = 1; i < arr.length; i++){
            mover.next = new Node(arr[i]);
            mover = mover.next;
        }

        System.out.println("Linked List created successfully");
        System.out.println("Head of the linked list is: " + head.data);
        System.out.println("Tail of the linked list is: " + mover.data);
        return head;
        // Time complexity: O(n)
    }

    public static int length(Node head){
        int length = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        return length;
        // Time complexity: O(n)
    }

    public static void printLinkedList(Node head){
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        // Time complexity: O(n)
    }

    public static int search(Node head, int key){
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if(temp.data == key) return index;
            temp = temp.next;
            index++;
        }
        return -1;
        // Time complexity: O(n)
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node head = arrayToLinkedList(arr);

        printLinkedList(head);

        System.out.println("Length of the linked list is: " + length(head));
        System.out.println("Index of 3 in the linked list is: " + search(head, 3)); // 2
        System.out.println("Index of 6 in the linked list is: " + search(head, 6)); // -1
    }
}
