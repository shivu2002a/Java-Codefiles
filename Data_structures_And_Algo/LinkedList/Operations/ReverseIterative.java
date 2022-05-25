package Data_structures_And_Algo.LinkedList.Operations;

import Data_structures_And_Algo.LinkedList.LinkedListMain.*; 

public class ReverseIterative {
    
    public static void reverse(Node head){
        Node curr = head;
        Node prev = null;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        while (prev != null) {
            System.out.println(prev.data);
            prev = prev.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList ll = new SinglyLinkedList(1,2,3,4,5,6,7);
        reverse(ll.head); 
    }

}
