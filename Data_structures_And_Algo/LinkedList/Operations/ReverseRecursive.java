package Data_structures_And_Algo.LinkedList.Operations;

import Data_structures_And_Algo.LinkedList.LinkedListMain.*;

public class ReverseRecursive extends SinglyLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        for (int i = 1; i <= 10; i++) {
            linkedList.append(i);
        }
        System.out.println(linkedList);
        
        Node reversed = reverse(linkedList.head);

        while (reversed != null) {
            System.out.print(reversed.data + " ");
            reversed = reversed.next;
        }
        System.out.println();
    }

    public static Node reverse(Node head) {
        if(head == null || head.next == null){
            return head;
        }
        Node reversed = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return reversed;
    }
}
