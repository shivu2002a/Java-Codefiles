package Data_structures_And_Algo.LinkedList.LinkedListMain;

public class LinkedListBasic {
    
    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        for (int i = 1; i <= 10; i++) {
            linkedList.append(i);
        }
        System.out.println(linkedList);
    }
}

