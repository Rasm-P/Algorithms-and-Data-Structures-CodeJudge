/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeJudgeAflevering3;

import java.util.Scanner;


class StoneNode {
    public StoneNode(int key) {
        this.key = key;
    }
    int key;
    boolean removed = false;
}

public class PrisonEscape {
    static int N;
    static int M;
    static int time = 0;
    static StoneNode[] stones;
    static boolean timeStopped = false;
    
    /*  
    @param n The number of StoneNodes to be initiated in the graph
    @void Initiates the StoneNodes graph
    */
    static void init(int n) {
        for (int i = 0; i < n+2; i++) {
            stones[i] = new StoneNode(i);
        }
    }
    
    /*  
    @param i The index of a specific StoneNode
    @return The index of the root StoneNode in the dynamic connected component 
    */
    static int find(int i) {
        while(i != stones[i].key) {
            i = stones[i].key;
        }
        return i;
    }
    
    /*  
    @param i The index of a specific StoneNode to take part in the unification
    @param j The index of aother specific StoneNode to take part in the unification
    @void Finds the root indexes of both i and j, and unifies their dynamic components under a common root.
    */
    static void union(int i, int j) {
        int ri = find(i);
        int rj = find(j);
        if (stones[ri].key != stones[rj].key) {
            stones[ri].key = stones[rj].key ;
        }
    }
    
    /*  
    @param i The index of a specific StoneNode
    @param j The index of aother specific StoneNode
    @return A boolean indicating whether the roots of i and j are in the same dynamic connected component
    */
    static boolean connected(int i, int j) {
        int ri = find(i);
        int rj = find(j);
        return stones[ri].key == stones[rj].key;
    }
    
    /*  
    @param i The index of a specific StoneNode to be removed at a specific time
    @void Sets the StoneNode as removed and check for other removed StoneNodes to unify its dynamic component with. 
    Also checks if a connected path between a start Node index M*N and an end Node index M*N+1 exists.
    */
    static void removeStone(int i) {
        stones[i].removed = true;
            if (!timeStopped) {
            if (i < N) {
                union(i,N*M);
            } 
            if (i >= N && stones[i-N].removed) {
                union(i,i-N);
            }

            if (i >= N*M-N) {
                union(i,N*M+1);
            } 
            if (i < N*M-N && stones[i+N].removed) {
                union(i,i+N);
            }

            if (i%N == 0 && stones[i+1].removed) {
                union(i,i+1);
            } 
            if (i > 0 && (i+1)%N == 0 && stones[i-1].removed) {
                union(i,i-1);
            } 
            if (i > 0 && i%N != 0 && stones[i-1].removed){
                union(i,i-1);
            } 
            if ((i+1)%N != 0 && stones[i+1].removed) {
                union(i,i+1);
            }

            if (connected(N*M,N*M+1)) {
                System.out.println(time);
                timeStopped = true;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        int R = scanner.nextInt();
        stones = new StoneNode[M*N+2];
        init(M*N);
        scanner.nextLine();
        for (int i = 0; i < R; i++) {
            time++;
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            removeStone((n+N*m));
        }
    }
}
