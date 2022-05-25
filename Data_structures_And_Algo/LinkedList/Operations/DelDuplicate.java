package Data_structures_And_Algo.LinkedList.Operations;

import Data_structures_And_Algo.LinkedList.LinkedListMain.*;

/* Author: Shivanagouda Agasimani 
   Deleting duplicate items in a sorted linked list */

public class DelDuplicate extends SinglyLinkedList {
    
    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        for (int i = 1; i < 7; i++) {
            linkedList.append(i);
        }
        linkedList.appendAt(3, 2);
        linkedList.appendAt(4, 3);
        linkedList.appendAt(8, 5);
        linkedList.appendAt(10, 7);
        System.out.println(linkedList);
        deleteDuplicate(linkedList.head);
        System.out.println(linkedList);

    }

    public static void deleteDuplicate(Node head){
        if(head == null || head.next == null){
            return;
        } 
        Node current = head;
        while(current.next != null){
            if(current.data != current.next.data){
                current = current.next;
            } else {
                current.next = current.next.next;
            }
        }
        return;
    }

    public static void deleteAlternate(Node head) {
        if(head == null || head.next == null){
            return;
        }
        Node current = head;
        head = head.next;
        while(current.next.next != null){
            current.next = current.next.next;
            current = current.next;
        }
    }
}
