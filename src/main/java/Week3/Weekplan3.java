/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Week3;

import java.util.Scanner;

public class Weekplan3 {
    
    /*
    MaxSubArray
    3
    1 2 -3
    */
    private static int MaxSubArray(int[] A, int d, int n) {
        if (d >= n) {
            if (d >= A.length) {
                return A[d-1];
            } else {
                return A[d];
            }
        }
        int m = (d+n)/2;
        int l = MaxSubArray(A,d,m);
        int r = MaxSubArray(A,m+1,n);
        int c = MaxMidCrossing(A,d,m,n);
        return Max(l,r,c);
    };
    
    private static int MaxMidCrossing(int[] A, int d, int m, int n){
        int sum = 0;
        int left = Integer.MIN_VALUE;
        for (int i = m-1; i >= d; i--) {
            sum += A[i];
            if (sum > left) {
                left = sum;
            }
        }
        sum = 0;
        int right = Integer.MIN_VALUE;
        for (int i = m; i < n; i++) {
            sum += A[i];
            if (sum > right) {
                right = sum;
            }
        }
        int plus = left + right;
        if (left == Integer.MIN_VALUE || left != Integer.MIN_VALUE && plus < right) {
            return right;
        } else if (right == Integer.MIN_VALUE || right != Integer.MIN_VALUE && plus < left) {
            return left;
        } else {
            return plus;
        }
    };
    
    private static int Max(int l, int r, int c) {
        if (l >= r && l >= c) {
            return l;
        } else if (r >= l && r >= c) {
            return r;
        } else {
            return c;
        }
    };
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(MaxSubArray(A, 0, n));
    }
}

    /*
    MaximalSubarray
    3
    1 2 -3
    public static int MaximalSubarray(int[] A, int n) {
        int maximalSum = A[0];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                if (sum > maximalSum) {
                    maximalSum = sum;
                }
            }
        }
        return maximalSum;
    };
    */