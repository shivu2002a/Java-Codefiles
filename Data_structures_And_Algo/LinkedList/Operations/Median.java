package Data_structures_And_Algo.LinkedList.Operations;

import Data_structures_And_Algo.LinkedList.LinkedListMain.*;

/* Author: Shivanagouda Agasimani 
   Finding median in a sorted linked list */


public class Median {
    
    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        for (int i = 1; i < 8; i++) {
            linkedList.append(i);
        }
        linkedList.appendAt(3, 2);
        linkedList.appendAt(4, 3);
        linkedList.appendAt(8, 5);
        // linkedList.appendAt(10, 7);
        System.out.println(linkedList);
        double median = med(linkedList.head);
        System.out.println(median);
    }

    public static double med(Node head){
        if(head == null) {
            return -1;
        } else if(head.next == null) {
            return head.data;
        }
        Node current1 = head;
        Node current2 = head;
        while(current2.next != null && current2.next.next != null){
            current2 = current2.next.next;
            current1 = current1.next;
        }
        if(current2.next == null) {
            return current1.data;
        }
        return (current1.next.data + current1.next.next.data )/2;
        
    }
}
