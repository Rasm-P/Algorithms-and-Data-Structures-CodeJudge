/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeJudgeAflevering2;

import java.util.Scanner;

class Node {
    public Node(int key) {
        this.key = key;
    }
    int key;
    Node right;
    Node left;
}

public class MiddleQueue {
    static int size = 0;
    static Node tail;
    static Node head;
    static Node middleNode;
    
    /*  
    @param node Node to be added to the right side of the queue
    @void Adds a node to the right side of the queue and sets it as tail
    */
    private static void right(Node node) {
        size++;
        if (tail == null) {
            tail = node;
            head = node;
            middleNode = node;
        } else {
            tail.right = node;
            node.left = tail;
            tail = node;
            if (size % 2 != 0) {
                middleNode = middleNode.right;
            }
        }
    }
    
    /*  
    @param node Node to be added to the left side of the queue
    @void Adds a node to the left side of the queue and sets it as head
    */
    private static void left(Node node) {
        size++;
        if (head == null) {
            tail = node;
            head = node;
            middleNode = node;
        } else {
            head.left = node;
            node.right = head;
            head = node;
            if (size % 2 == 0) {
                middleNode = middleNode.left;
            }
        }
    }
    
    /*  
    @void Extracts an item from the middle of the queue and sets a new middle node
    */
    private static void extract() {
        Node midNode = middleNode;
        System.out.println(midNode.key);
        if (midNode.left != null && midNode.right != null) {
            midNode.left.right = midNode.right;
            midNode.right.left = midNode.left;
            if (size % 2 == 0) {
                middleNode = middleNode.right;
            } else {
                middleNode = middleNode.left;
            }
        } else if (midNode.left == null && midNode.right != null) {
            midNode.right.left = null;
            head = midNode.right;
            middleNode = middleNode.right;
        } else {
            head = null;
            tail = null;
            middleNode = null;
        }
        size--;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            String input = scanner.next();
            switch (input) {
                case "R":{
                    int value = scanner.nextInt();
                    right(new Node(value));
                        break;
                    }
                case "L":{
                    int value = scanner.nextInt();
                    left(new Node(value));
                        break;
                    }
                case "E":
                    extract();
                    break;
                default:
                    break;
            }
        }
    }
}


/*
import java.util.Scanner;

class Node {
    public Node(int key) {
        this.key = key;
    }
    int key;
    Node right;
    Node left;
}

public class MiddleQueue {
    static int size = 0;
    static Node tail;
    static Node head;
    
    private static void right(Node node) {
        if (tail == null) {
            tail = node;
            head = node;
        } else {
            tail.right = node;
            node.left = tail;
            tail = node;
        }
        size++;
    }
    
    private static void left(Node node) {
        if (head == null) {
            tail = node;
            head = node;
        } else {
            head.left = node;
            node.right = head;
            head = node;
        }
        size++;
    }
    
    private static void extract() {
        int middle;
        if (size % 2 == 0) {
             middle = (size/2);
        } else {
             middle = (size/2)+1;
        }
        int count = 1;
        Node midNode = head;
        while (count < middle){
            midNode = midNode.right;
            count++;
        }
        System.out.println(midNode.key);
        if (midNode.left != null && midNode.right != null) {
            midNode.left.right = midNode.right;
            midNode.right.left = midNode.left;
        } else if (midNode.left == null && midNode.right != null) {
            midNode.right.left = null;
            head = midNode.right;
        } else {
            head = null;
            tail = null;
        }
        size--;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            String input = scanner.next();
            switch (input) {
                case "R":{
                    int value = scanner.nextInt();
                    right(new Node(value));
                        break;
                    }
                case "L":{
                    int value = scanner.nextInt();
                    left(new Node(value));
                        break;
                    }
                case "E":
                    extract();
                    break;
                default:
                    break;
            }
        }
    }
}
*/