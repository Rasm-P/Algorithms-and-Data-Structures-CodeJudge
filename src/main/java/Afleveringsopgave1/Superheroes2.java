
package Afleveringsopgave1;

import java.util.Arrays;
import java.util.Scanner;

public class Superheroes2 {
    
    /*  
    @param Array of random superhero prices
    @param Size of the random superhero array
    @return The sum of the prices for the first rounted up sqrt(m) sorted superheros
    */
    private static int BudgetSuperheroes(int[] A, int m){
        int[] sorted = SuperheroesMergeSort(A,m);
        int T = (int)Math.sqrt(m);
        int sum = 0;
        for (int i = 0; i < T;i++) {
            sum += sorted[i];
        }
        return sum;
    }

    private static int[] SuperheroesMergeSort(int[] A, int m) {
        m = A.length;
        if (m > 1) {
            int c = m/2;
            int[] A1 = Arrays.copyOfRange(A,0,c);
            int[] A2 = Arrays.copyOfRange(A,c,m);
            int[] msort1 = SuperheroesMergeSort(A1,m);
            int[] msort2 = SuperheroesMergeSort(A2,m);
            return Merge(msort1, msort1.length, msort2, msort2.length);  
        }
        return A;
    }
    
    private static int[] Merge(int[] A, int a, int[] Q, int q) {
        if (a == 0) {
            return Q;
        } else if (q == 0) {
            return A;
        }
        int length = a+q;
        int[] C = new int[length];
        int i = 0;
        int left = 0;
        int right = 0;
        while (true) {
            if (i >= length) {
                return C;
            } else if (right >= q || left != a && A[left] <= Q[right]) {
                C[i] = A[left];
                left++;
            } else if (left >= a || right != q && A[left] > Q[right]) {
                C[i] = Q[right];
                right++;
            }
            i++;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] A = new int[m];
        for (int i = 0; i < m; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(BudgetSuperheroes(A, m));
    }
}