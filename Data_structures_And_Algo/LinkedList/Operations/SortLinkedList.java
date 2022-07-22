package Data_structures_And_Algo.LinkedList.Operations;

import Data_structures_And_Algo.LinkedList.LinkedListMain.*;

public class SortLinkedList {
    
    public static void main(String[] args) { 
        sortByBubble(new SinglyLinkedList(4, 27, 1, 8, 2, 56, 23).head);
        Node mergeSortNode = sortByMerge(new SinglyLinkedList(4, 27, 1, 8, 2, 56, 23).head);
        while (mergeSortNode != null) {
            System.out.print(mergeSortNode.data + " ");
            mergeSortNode = mergeSortNode.next;
        }
        System.out.println();
    }

    public static void sortByBubble(Node headNode){
        Node current = headNode, index;
        int temp;
        while (current != null) {
            index = current.next;
            while (index != null) {
                if (index.data < current.data) {
                    temp = index.data;
                    index.data = current.data;
                    current.data = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
        while (headNode != null ) {
            System.out.print(headNode.data + " ");
            headNode = headNode.next;
        }
        System.out.println();
    }

    private static Node sortByMerge(Node head) {
        if (head == null  || head.next == null) {
            return head;
        }
        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next; 
        middle.next = null;
        Node left = sortByMerge(head);
        Node right = sortByMerge(nextOfMiddle);
        Node sortedList = merge(left, right);
        return sortedList;
    }

    
    private static Node getMiddle(Node head) {
        if (head == null) {
            return head;
        }
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static Node merge(Node left, Node right) {
        if (left == null) {
            return right;
        } else if ( right == null) {
            return left;
        }
        Node result = null;
        if (left.data < right.data) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }
        return result;
    }
}
