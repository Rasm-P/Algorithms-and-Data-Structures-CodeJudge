/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Week4;

import java.util.Scanner;

class Node {
    public Node(int key) {
        this.key = key;
    }
    int key;
    Node next;
}

public class Stack {
    static Node head;
    
    private static void PU(Node x) {
        if (head == null) {
            head = x;
        } else {
            x.next = head;
            head = x;
        }
    }
    
    private static void PO() {
        if (head.next != null) {
            System.out.println(head.key);
            head = head.next;
        } else if (head.next == null) {
            System.out.println(head.key);
            head = null;
        } else {
            System.out.println(-1);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            String input = scanner.next();
            if ("PU".equals(input)) {
                int value = scanner.nextInt();
                PU(new Node(value));
            } else if ("PO".equals(input)) {
                PO();
            }
        }
    }
}