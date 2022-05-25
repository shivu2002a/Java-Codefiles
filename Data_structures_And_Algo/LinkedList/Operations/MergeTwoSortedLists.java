package Data_structures_And_Algo.LinkedList.Operations;

import Data_structures_And_Algo.LinkedList.LinkedListMain.*;

public class MergeTwoSortedLists {
    
    public static void main(String[] args) {
        SinglyLinkedList linkedlist1 = new SinglyLinkedList(1,6,9,17,24,39);
        SinglyLinkedList linkedlist2 = new SinglyLinkedList(4,12,11,16,38);
        Node one = linkedlist1.head, two = linkedlist2.head;
        Node merged = mergeRecursive(one, two);
        while (merged != null) {
            System.out.print(merged.data + " " );
            merged = merged.next;
        }
        Node merged2 = mergeIterative(linkedlist1.head, linkedlist2.head);
        while (merged2 != null) {
            System.out.print(merged2.data + " ");
            merged2 = merged2.next;
        }
    }

    private static Node mergeRecursive(Node head1, Node head2) {
        if(head1 == null){
            return head2;
        } else if (head2 == null){
            return head1;
        } 
        if(head1.data >= head2.data){
            head2.next = mergeRecursive(head1, head2.next);
            return head2;
        } else {
            head1.next = mergeRecursive(head1.next, head2);
            return head1;
        }
    }

    public static Node mergeIterative(Node head1, Node head2){
        Node current = new Node(0);
        Node tail = current;
        while (true) {
            if (head1 == null && head2 == null) {
                return current.next;
            }
            if (head1 == null) {
                tail.next = head2;
                break;
            } else if (head2 == null) {
                tail.next = head1;
                break;
            }
            if (head1.data >= head2.data ) {
                tail.next = head2;
                head2 = head2.next;
            } else {
                tail.next = head1;
                head1 = head1.next;
            }
            tail = tail.next;
        }
        return current.next;
    }
}
