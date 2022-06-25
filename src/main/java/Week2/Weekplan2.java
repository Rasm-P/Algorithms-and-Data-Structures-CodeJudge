/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Week2;

import java.util.Arrays;
import java.util.Scanner;

public class Weekplan2 {
    
    /*
    Stones
    8 15
    2 5 3 1 8 4 5 7
    */
    public static int Stones(int[] A, int N, int W) {
        int[] arr = MergeSort(A, N);
        int currentWeight = 0;
        int i = 0;
        boolean run = true;
        while (run) {
            if (arr.length != i && currentWeight + arr[i] <= W) {
                currentWeight += arr[i];
                i++;
            } else {
                run = false;
            }
        }
        return i;
    };
    
    public static int[] MergeSort(int[] A, int n) {
        n = A.length;
        if (n > 1) {
            int m = n/2;
            int[] A1 = Arrays.copyOfRange(A,0,m);
            int[] A2 = Arrays.copyOfRange(A,m,n);
            int[] msort1 = MergeSort(A1,n);
            int[] msort2 = MergeSort(A2,n);
            return Merge(msort1.length, msort1, msort2.length, msort2);  
        }
        return A;
    };
    
    public static int[] Merge(int N, int[] A, int M, int[] Q) {
        if (N == 0) {
            return Q;
        } else if (M == 0) {
            return A;
        }
        int length = N+M;
        int[] C = new int[length];
        int i = 0;
        int left = 0;
        int right = 0;
        while (true) {
            if (i >= length) {
                return C;
            } else if (right >= M || left != N && A[left] <= Q[right]) {
                C[i] = A[left];
                left++;
            } else if (left >= N || right != M && A[left] > Q[right]) {
                C[i] = Q[right];
                right++;
            }
            i++;
        }
    };
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int W = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(Stones(A, N, W));
    }
}    

    /*
    MergeSort
    3
    17 3 10
    public static int[] MergeSort(int[] A, int n) {
        n = A.length;
        if (n > 1) {
            int m = n/2;
            int[] A1 = Arrays.copyOfRange(A,0,m);
            int[] A2 = Arrays.copyOfRange(A,m,n);
            int[] msort1 = MergeSort(A1,n);
            int[] msort2 = MergeSort(A2,n);
            return Merge(msort1.length, msort1, msort2.length, msort2);  
        }
        return A;
    };
    
    public static int[] Merge(int N, int[] A, int M, int[] Q) {
        if (N == 0) {
            return Q;
        } else if (M == 0) {
            return A;
        }
        int length = N+M;
        int[] C = new int[length];
        int i = 0;
        int left = 0;
        int right = 0;
        while (true) {
            if (i >= length) {
                return C;
            } else if (right >= M || left != N && A[left] <= Q[right]) {
                C[i] = A[left];
                left++;
            } else if (left >= N || right != M && A[left] > Q[right]) {
                C[i] = Q[right];
                right++;
            }
            i++;
        }
    };
    */

    /*
    Merge
    3
    2 4 6
    3
    1 3 5
    public static int[] Merge(int N, int[] A, int M, int[] Q) {
        if (N == 0) {
            return Q;
        } else if (M == 0) {
            return A;
        }
        int length = N+M;
        int[] C = new int[length];
        int i = 0;
        int left = 0;
        int right = 0;
        while (true) {
            if (i >= length) {
                return C;
            } else if (right >= M || left != N && A[left] <= Q[right]) {
                C[i] = A[left];
                left++;
            } else if (left >= N || right != M && A[left] > Q[right]) {
                C[i] = Q[right];
                right++;
            }
            i++;
        }
    };
    */

    /*
    Binary Search
    3
    1 5 7
    2
    5 6
    public static int BinarySearch(int[] A, int i, int j, int x) {
        if (j < i || A.length == 0) {
            return -1;
        }
        int m = (i+j)/2;
        if (A[m] == x) {
            return m;
        } else if (A[m] < x) {
            return BinarySearch(A, m+1, j, x);
        } else {
            return BinarySearch(A, i, m-1, x);
        }
    };
    
    public static int[] SearchQueries(int N, int[] A, int M, int[] Q) {
        int[] I = new int[M];
        for (int i = 0; i < M; i++) {
            I[i] = BinarySearch(A, 0, N-1, Q[i]);
        }
        return I;
    };
    */
    
    /*
    public static int BinarySearch(int N, int[] A, int Q) {
        for (int i = 0; i < N; i++) {
            if (A[i] == Q) {
                return i;
            }
        }
        return -1;
    };
    
    public static int[] SearchQueries(int N, int[] A, int M, int[] Q) {
        int[] I = new int[M];
        for (int i = 0; i < M; i++) {
            I[i] = BinarySearch(N, A, Q[i]);
        }
        return I;
    };
    */

