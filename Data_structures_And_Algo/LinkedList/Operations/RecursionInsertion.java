package Data_structures_And_Algo.LinkedList.Operations;

import Data_structures_And_Algo.LinkedList.LinkedListMain.*;

public class RecursionInsertion {

    public static SinglyLinkedList singlyll = new SinglyLinkedList();

    public static void main(String[] args) {
        singlyll.head = recInsert(4, singlyll.head);
        singlyll.head = recInsert(1, singlyll.head);
        singlyll.head = recInsert(65, singlyll.head);
        singlyll.head = recInsert(23, singlyll.head);
        singlyll.head = recInsert(78, singlyll.head);
        singlyll.head = recInsert(8, singlyll.head);
        singlyll.head = recInsert(9, singlyll.head);

        singlyll.head = recInsertAt(3, 6, singlyll.head);
        singlyll.head = recInsertAt(1, 23, singlyll.head);
        singlyll.head = recInsertAt(4, 45, singlyll.head);

        System.out.println(singlyll);

    }


    public static Node recInsert(int item, Node head) {
        if(head == null){
            head = new Node(item);
        } else if(head.next == null){
            head.next = new Node(item);
        } else {
            recInsert(item, head.next);
        }
        return head;
    }

    public static Node  recInsertAt(int index, int item, Node head){
        if(head == null){
            if(index > 1){
                System.out.println("Position greater than the length of ll for item: " + item);
            } else {
                head = new Node(item);
            }
        } else if(index <= 2){
            Node newnode = new Node(item);
            if(index == 1){
                newnode.next = head;
                head = newnode;
                return head;
            }else {
                newnode.next = head.next;
                head.next = newnode;
            }
        } else {
            recInsertAt(index-1, item, head.next);
        }
        return head;
    }
    
}
