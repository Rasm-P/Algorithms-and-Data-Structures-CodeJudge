/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Week5;

import java.util.Scanner;

class G {
    public G() {}
    public G(char key) {
        this.key = key;
    }
    char key;
    String color = "WHITE";
    int d;
    G phi;
    G up;
    G down;
    G right;
    G left;
}

class QueueNode {
    public QueueNode(G key) {
        this.key = key;
    }
    G key;
    QueueNode next;
}

class Queue {
    static QueueNode tail;
    static QueueNode head;
    public Queue() {}
    public static void enqueue(G key) {
        QueueNode x = new QueueNode(key);
        if (tail == null) {
            tail = x;
            head = x;
        } else {
            tail.next = x;
            tail = x;
        }
    }
    public static G dequeue() {
        QueueNode h = head;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return h.key;
    }
    public static boolean isEmpty() {
        return head == null && tail == null;
    }
}

public class LetterLabyrinth {
    
    private static void BFS(G s) {
        G v;
        G u;
        s.color = "GRAY";
        s.d = 1;
        Queue Q = new Queue();
        Q.enqueue(s);
        while(!Q.isEmpty()) {
            v = Q.dequeue();
            if (v.up != null && v.up.color == "WHITE" && v.up.key != v.key) {
                v.up.color = "GRAY";
                v.up.d = v.d + 1;
                v.up.phi = v;
                Q.enqueue(v.up);
            }
            if (v.down != null && v.down.color == "WHITE" && v.down.key != v.key) {
                v.down.color = "GRAY";
                v.down.d = v.d + 1;
                v.down.phi = v;
                Q.enqueue(v.down);
            }
            if (v.right != null && v.right.color == "WHITE" && v.right.key != v.key) {
                v.right.color = "GRAY";
                v.right.d = v.d + 1;
                v.right.phi = v;
                Q.enqueue(v.right);
            }
            if (v.left != null && v.left.color == "WHITE" && v.left.key != v.key) {
                v.left.color = "GRAY";
                v.left.d = v.d + 1;
                v.left.phi = v;
                Q.enqueue(v.left);
            }
            v.color = "BLACK";  
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        G[][] A = new G[N][N];
        scanner.nextLine();
        for (int i = 0; i < N; i++) {
            char[] k = scanner.nextLine().toCharArray();
            for (int j = 0; j < N; j++) {
                A[i][j] = new G(k[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != 0) {
                    A[i][j].up = A[i-1][j];
                }
                if (j != 0) {
                    A[i][j].left = A[i][j-1];
                }
                if (j != N-1) {
                    A[i][j].right = A[i][j+1];
                }
                if (i != N-1) {
                    A[i][j].down = A[i+1][j];
                }
            }
        }
        G s = A[0][0];
        G v = A[N-1][N-1];
        BFS(s);
        System.out.println(v.d);
    }
}