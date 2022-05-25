package Data_structures_And_Algo.LinkedList.Operations;
/* 
    Given a number in the form of LinkedList where each node has a digit, add two such linkedlists
    Author : Shivanagouda S A
*/

import Data_structures_And_Algo.LinkedList.LinkedListMain.*;

public class AddNumbersTwo {

    public static void main(String[] args) {
        SinglyLinkedList l1 = new SinglyLinkedList(9);
        SinglyLinkedList l2 = new SinglyLinkedList(9,9,9);
        Node res = addTwoNumbers(l1.head, l2.head);
        while (res != null) {
            System.out.print(res.data + " ");
            res = res.next;
        }
    }

    public static Node addTwoNumbers(Node node1, Node node2) {
        Node res = new Node(0);
        Node current = res;
        int l1 = 0, l2 = 0;
        Node p1 = node1, p2 = node2;
        
//         Find lengths
        while(p1 != null){
            p1 = p1.next;
            l1++;
        }
        while(p2 != null){
            l2++;
            p2 = p2.next;
        }
        p1 = node1;
        p2 = node2;
        
//         Suitable arrangements for performing addition
        while(l1 != l2){
            if(l1 > l2){
                current.next = new Node(p1.data);
                p1 = p1.next;
                l1--;
            }else{
                current.next = new Node(p2.data);
                p2 = p2.next;
                l2--;
            }
            current = current.next;
        }
        
//         Perform Addition
        while(p1 != null){
            current.next = new Node(p1.data + p2.data);
            p1 = p1.next;
            p2 = p2.next; 
            current = current.next;
        }
        
//         Normalize
        boolean flag = false;
        do{
            flag = false;
            p1 = res;
            p2 = res.next;
            while( p2 != null) {
                if(p2.data >= 10) {
                    p1.data += 1;
                    if(p1.data >= 10) flag = true;
                    p2.data -= 10; 
                }
                p1 = p1.next;
                p2 = p2.next;
            } 
        }while(flag);

        if(res.data > 0){
            return res;
        }
        return res.next;
            
    }
}