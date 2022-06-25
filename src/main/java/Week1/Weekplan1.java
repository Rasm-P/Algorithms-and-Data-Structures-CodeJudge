/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Week1;

import java.util.Scanner;

public class Weekplan1 {
    
    //Itterativ version af algoritme 3
    public static int Peak(int[] A, int i, int j) {
        while (true) {
            int m = (i+j)/2;
            if ((m == 0 || A[m] >= A[m-1]) && (m == A.length-1 || A[m] >= A[m+1])) {
		return m; 
            } else if (A[m-1] > A[m]){
                j = m-1;
                m = (i+j)/2;
            } else if (A[m] < A[m+1]) {
                i = m+1;
                m = (i+j);
            }
        }
    };
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(Peak(A,0,N));
    }
    
    /*
    //Algorithm 3
    public static int Peak(int[] A, int i, int j) {
        int m = (i+j)/2;
        if (m == A.length-1 && A[m] > A[A.length-2]) {
            return m;
        } else if (m == 0 && A[m] > A[m+1]) {
            return m;
        }
        else if (A[m] >= A[m-1] && A[m] >= A[m+1]) {
            return m;
        } else if (A[m-1] > A[m]) {
            return Peak(A,i,m-1);
        } else {
            return Peak(A,m+1,j);
        }
    }
    */
    
    /*
    //Algorithm 2
    public static int Peak(int[] A, int n) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] > A[max]) {
                max = i;
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(Peak(A,N));
    }
    */
    
    /*
    //Algorithm 1
    public static int Peak(int[] A, int n) {
        if (A[0] >= A [1]) {
            return 0;
        }
        for (int i = 1; i < n-2; i++) {
            if (A[i-1] <= A[i] && A[i+1] <= A[i]) {
                return i;
            }
        }
        if (A[n-2] <= A[n-1]) {
            return n-1;
        } else {
            return 0;
        }
    }
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(Peak(A,N));
    }
    */
}
