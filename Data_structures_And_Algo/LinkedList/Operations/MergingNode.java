package Data_structures_And_Algo.LinkedList.Operations;

import Data_structures_And_Algo.LinkedList.LinkedListMain.*;

public class MergingNode {

    public static void main(String[] args) {
        Node intersectionList = new Node(4);
        intersectionList.next = new Node(5);
        intersectionList.next.next = new Node(6);
        intersectionList.next.next.next = new Node(7);
        
        Node one = new Node(1);
        one.next = new Node(2);
        one.next.next = new Node(3);
        one.next.next.next = intersectionList; 

        Node two = new Node(7);
        two.next = new Node(8);
        two.next.next = new Node(9);
        two.next.next.next = new Node(10);
        two.next.next.next.next = intersectionList;

        Node merged = findMerged(one, two);
        if(merged == null){
            System.out.println("null");
        }else {
            System.out.println(merged.data);
        }
    }

    private static Node findMerged(Node one, Node two) {
        int l1 = 0, l2 = 0;
        Node currentl1 = one;
        Node currentl2 = two;
        while(currentl1 != null){
            currentl1 = currentl1.next;
            l1++; 
        }
        while (currentl2 != null) {
            currentl2 = currentl2.next;
            l2++;
        }
        int toRemove = Math.abs(l1-l2);
        
        if (l1 > l2) {
            while(toRemove > 0){
                one = one.next;
                toRemove--;
            }
        } else {
            while(toRemove-- > 0){
                two = two.next;
            }
        }
        while(one != null && two != null){
            if(one == two){
                return one;
            } 
            one = one.next;
            two = two.next;
        }
        return null;
    }
    
}
