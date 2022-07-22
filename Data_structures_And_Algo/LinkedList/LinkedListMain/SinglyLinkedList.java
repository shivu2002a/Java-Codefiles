package Data_structures_And_Algo.LinkedList.LinkedListMain;

/* Author: Shivanagouda Agasimani */

public class SinglyLinkedList {
    public Node head;

    public SinglyLinkedList(){
        head = null;
    }

    public SinglyLinkedList(int... data){
        head = new Node(data[0]);
        Node current = head;
        for(int i = 1; i < data.length; i++){
            Node newNode = new Node(data[i]);
            current.next = newNode;
            current = current.next;
        }
    }

    public void append(int data){
        if(head == null){
            head = new Node(data);
        } else {
            Node current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = new Node(data);
        }
    }

    public void prepend(int data){
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }

    public void delete(int data){
        if(head == null){
            return;
        } else if(head.data == data){
            head = head.next;
            return;
        } else {
            Node current = head;
            while(current.next != null){
                if(current.next.data == data){
                    current.next = current.next.next;
                    return;
                }
                current = current.next;
            }
            
        }
    }

    public boolean appendAt(int position, int data) {
        if((head == null && position > 1) || position < 1){
            return false;
        } else if (position == 1) {
            prepend(data);
            return true;
        } else {
            Node currentNode = head;
            int count = 1;
            while ((count != position-1)  && currentNode.next != null)  {
                currentNode = currentNode.next;
                count++;
            }
            if (count == position-1) {
                Node newNode = new Node(data);
                newNode.next = currentNode.next;
                currentNode.next = newNode;    
                return true;
            } else if (position == (count+1)){
                append(data);
                return true;
            } 
            return false;
        }
    }

    public String toString(){
        Node current = head;
        String s = "";
        while(current != null){
            s = s + current.data + " ";
            current = current.next;
        }
        return s;
    }
    
    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList(10,9,8,7,6,5,4,3,2,1);
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);
        linkedList.appendAt(8, 4);
        System.out.println(linkedList);
        linkedList.delete(10);
        // linkedList.clear();
        System.out.println(linkedList);
    }
}
