package Data_structures_And_Algo.LinkedList.Operations;

import Data_structures_And_Algo.LinkedList.LinkedListMain.*;

public class CommonList {
    
    public static void main(String[] args) {
        SinglyLinkedList sll1 = new SinglyLinkedList(1, 2, 4, 5, 7, 8, 9);
        SinglyLinkedList sll2 = new SinglyLinkedList(1, 3, 4, 6, 7, 9, 10, 11);
        Node commonList =  findCommonElements(sll1.head, sll2.head);
        while (commonList != null) {
            System.out.print(commonList.data + " ");
            commonList = commonList.next;
        }
    }

    public static Node findCommonElements(Node head1, Node head2){
        if( (head1 == null && head2 == null) || head1 == null || head2 == null){
            return null;
        }
        Node dummy = new Node(0);
        Node current = dummy;
        while (head1 != null && head2 != null) {
            if(head1.data == head2.data){
                current.next = head1;
                current = current.next;
                head1 = head1.next;
                head2 = head2.next;
            }else if(head1.data > head2.data){
                head2 = head2.next;
            }else{
                head1 = head1.next;
            }
        }
        return dummy.next;
    }
}