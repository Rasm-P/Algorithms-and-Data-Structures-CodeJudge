/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Week4;

import java.util.Scanner;

class QueueNode {
    public QueueNode(int key) {
        this.key = key;
    }
    int key;
    QueueNode next;
}

public class Queue {
    static QueueNode tail;
    static QueueNode head;
    
    private static void E(QueueNode x) {
        if (tail == null) {
            tail = x;
            head = x;
        } else {
            tail.next = x;
            tail = x;
        }
    }
    
    private static void D() {
        if (head == null) {
            System.out.println(-1);
        } else {
            System.out.println(head.key);
            head = head.next;
            if (head == null) {
                tail = null;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            String input = scanner.next();
            if ("E".equals(input)) {
                int value = scanner.nextInt();
                E(new QueueNode(value));
            } else if ("D".equals(input)) {
                D();
            }
        }
    }
}