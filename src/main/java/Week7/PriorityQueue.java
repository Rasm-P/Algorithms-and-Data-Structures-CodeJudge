/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Week7;

import java.util.Scanner;

public class PriorityQueue {
    static int n = 0;
    static int[] queueArray;
    
    static void bubbleUp(int x) {
        while (x > 1) {
            if (queueArray[x/2] < queueArray[x]) {
                int temp = queueArray[x];
                queueArray[x] = queueArray[x/2];
                queueArray[x/2] = temp;
            }
            x = x/2;
        }
    }
    
    static void bubbleDown(int x) {
        if (n > 2) {
            while (2*x <= n) {
                if (queueArray[2*x] > queueArray[x] || queueArray[(2*x)+1] > queueArray[x]) {
                   if (queueArray[2*x] > queueArray[(2*x)+1]) {
                       int temp = queueArray[x];
                       queueArray[x] = queueArray[2*x];
                       queueArray[2*x] = temp;
                       x = 2*x;
                   } else {
                       int temp = queueArray[x];
                       queueArray[x] = queueArray[(2*x)+1];
                       queueArray[(2*x)+1] = temp;
                       x = (2*x)+1;
                   }
                } else {
                    x = 2*x;
                }
            }
        } else {
            if (queueArray[2*x] > queueArray[x]) {
                int temp = queueArray[x];
                queueArray[x] = queueArray[2*x];
                queueArray[2*x] = temp;
            }
        }
    }
    
    static void insert(int x) {
        n = n+1;
        queueArray[n] = x;
        bubbleUp(n);
    }
    
    static void print() {
        for (int i = 1; i <= n; i++) {
            System.out.print(queueArray[i] + " ");
        }
        System.out.print('\n');
    }
    
    static void extractMax() {
        int r = queueArray[1];
        queueArray[1] = queueArray[n];
        n = n-1;
        bubbleDown(1);
        System.out.println(r);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        queueArray = new int[N];
        for (int i = 0; i < N; i++) {
            String input = scanner.next();
            if ("I".equals(input)) {
                int value = scanner.nextInt();
                insert(value);
            } else if ("P".equals(input)) {
                print();
            } else if ("E".equals(input)) {
                extractMax();
            }
        }
    }
}
