/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Week6;

import java.util.Scanner;


class ListNode {
    public ListNode(Node key) {
        this.key = key;
    }
    Node key;
    ListNode next;
}

class LinkedList {
    ListNode tail;
    ListNode head;
    public LinkedList() {}
    public void addItem(Node key) {
        ListNode x = new ListNode(key);
        if (tail == null) {
            tail = x;
            head = x;
        } else {
            tail.next = x;
            tail = x;
        }
    }
    public boolean isEmpty() {
        return head == null && tail == null;
    }
}

class Stack {
    static Node head;
    public static void PU(Node x) {
        if (head == null) {
            head = x;
        } else {
            x.next = head;
            head = x;
        }
    }
    public static Node PO() {
        Node n;
        if (head.next != null) {
            n = head;
            head = head.next;
            return n;
        } else {
            n = head;
            head = null;
            return n;
        }
    }
}

class Node {
    public Node(int key) {
        this.key = key;
        dependancies = new LinkedList();
    }
    int key;
    LinkedList dependancies;
    String color = "WHITE";
    Node phi;
    Node next;
}


public class CoursePlanning {
    static Node[] grapth;
    
    public static void addEdge(int x,int y)
    {
        grapth[x-1].dependancies.addItem(grapth[y-1]);
    }
    
    public static void DFS(int edges) {
        for (int i = 0; i < edges; i++)
        {
            Node u = grapth[i];
            if (u.color == "WHITE") {
                DFS_VISIT(u);
            }
        }
    }
    
    public static void DFS_VISIT(Node u) {
        u.color = "GRAY";
        if (!u.dependancies.isEmpty()) {
            ListNode v = u.dependancies.head;
            while(v!=null) {
                if (v.key.color == "WHITE") {
                    v.key.phi = u;
                    DFS_VISIT(v.key);
                }
                v = v.next;
            }
        }
        u.color = "BLACK";
        Stack.PU(u);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        grapth = new Node[N];
        for (int i = 0; i < N; i++) {
            Node course = new Node(i+1);
            grapth[i] = course;
        }
        for (int j = 0; j < M; j++) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            addEdge(X, Y);
        }
        DFS(N);
        while (Stack.head != null) {
            System.out.println(Stack.PO().key);
        }
    }
}


/*
class ListNode {
    public ListNode(CourseNode key) {
        this.key = key;
    }
    CourseNode key;
    ListNode next;
}

class LinkedList {
    ListNode tail;
    ListNode head;
    public LinkedList() {}
    public void addItem(CourseNode key) {
        ListNode x = new ListNode(key);
        if (tail == null) {
            tail = x;
            head = x;
        } else {
            tail.next = x;
            tail = x;
        }
    }
    public boolean isEmpty() {
        return head == null && tail == null;
    }
}

class QueueNode {
    public QueueNode(CourseNode key) {
        this.key = key;
    }
    CourseNode key;
    QueueNode next;
}

class Queue {
    static QueueNode tail;
    static QueueNode head;
    public Queue() {}
    public static void enqueue(CourseNode key) {
        QueueNode x = new QueueNode(key);
        if (tail == null) {
            tail = x;
            head = x;
        } else {
            tail.next = x;
            tail = x;
        }
    }
    public static CourseNode dequeue() {
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

class CourseNode {
    public CourseNode(int key) {
        this.key = key;
        dependancies = new LinkedList();
    }
    int key;
    LinkedList dependancies;
    boolean visited = false;
}


public class CoursePlanning {
    static CourseNode[] grapth;
    
    public static void addEdge(int x,int y)
    {
        grapth[x-1].dependancies.addItem(grapth[y-1]);
    }
    
    public static void BFS(int edges) {
        int layerCount = 1;
        for(int i=0;i<edges;i++)
        {
            if(!grapth[i].visited)
            {
                int count = 1;
                CourseNode v;
                Queue Q = new Queue();
                Q.enqueue(grapth[i]);
                grapth[i].visited = true;
                while(!Q.isEmpty()) {
                    count++;
                    v = Q.dequeue();
                    if (!v.dependancies.isEmpty()) {
                        ListNode d = v.dependancies.head;
                        while(d!=null) {
                            if (!d.key.visited) {
                                Q.enqueue(d.key);
                                d.key.visited = true;
                            }
                            d = d.next;
                        }
                    }
                }
                if (count > layerCount) {
                    layerCount = count;
                }
            }
        }
        System.out.println(layerCount);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        grapth = new CourseNode[N];
        for (int i = 0; i < N; i++) {
            CourseNode course = new CourseNode(i+1);
            grapth[i] = course;
        }
        for (int j = 0; j < M; j++) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            addEdge(X, Y);
        }
        BFS(N);
    }
}
*/