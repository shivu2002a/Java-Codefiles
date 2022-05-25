package Data_structures_And_Algo.LinkedList;

import Data_structures_And_Algo.LinkedList.LinkedListMain.Node;

public class LinkedMaxStack {
    
    private Node root, max;

    public LinkedMaxStack(){

    } 

    public void push(int a){
        if(root == null){
            root = new Node(a);
            max = root;
            return;
        }
        Node newNode = new Node(a);
        newNode.next = root;
        root = newNode;
        if(newNode.data >= newNode.next.data){
            newNode = new Node(a);
            newNode.next = max;
            max = newNode;
        }
        return;
    }

    public int pop() {
        if (root == null) {
            throw new NullPointerException("Stack is empty.No max element");
        }
        int a;
        if (max.data == root.data) {
            max = max.next;
            a = root.data;
            root = root.next;
        }else{
            a = root.data;
            root = root.next;
        }
        return a;
    }

    public int  max(){
        if(max != null){
            return max.data;
        }
        throw new NullPointerException("Stack is empty.No max element");
    }

    public String toString(){
        if(root == null)
            return null;
        String s = "";
        Node curr = root;
        while (curr != null) {
            s += curr.data + "\n";
            curr = curr.next;
        }
        return s;
    }

    public static void main(String[] args) {
        LinkedMaxStack lStack = new LinkedMaxStack();  
        // lStack.push(2);
        lStack.push(1);
        lStack.push(7);
        lStack.push(3);
        lStack.push(7);
        System.out.println(lStack);             
        System.out.println("Max: " +lStack.max());
        lStack.pop();
        System.out.println(lStack);             
        lStack.pop();
        System.out.println("Max: " +lStack.max());     
        System.out.println(lStack);   
        lStack.pop();
        System.out.println(lStack);             
        System.out.println("Max: " +lStack.max());            




    }
}