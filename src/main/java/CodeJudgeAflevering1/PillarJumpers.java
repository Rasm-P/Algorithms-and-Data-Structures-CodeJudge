/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeJudgeAflevering1;

import java.util.Arrays;
import java.util.Scanner;

public class PillarJumpers {
    
    /*  
    @param a Array of pillar heights in non-decreasing order
    @param n Size of the pillar array
    @param j Maximum number of jumps
    @return The minimum required strength
    */
    private static int pillarJumpers(int[] a, int n, int j) {
        int minS = (a[n-1]/j)-a[0];
        if (minS == 0) {
            minS = 1;
        }
        int maxS = a[n-1];
        return binaryStrengthSearch(a,minS,maxS,n,j);
    }
    
    /*  
    @param a Array of pillar heights in non-decreasing order
    @param minS The minimum possible strength
    @param maxS The maximum possible strength
    @param n Size of the pillar array
    @param j Maximum number of jumps
    @return The minimum required strength
    */
    private static int binaryStrengthSearch(int[] a, int minS, int maxS, int n, int j) {
        if (minS == maxS){
            return minS;
        }
        int midS = (minS+maxS)/2;
        int check = checkStrength(a,n,j,midS);
        if (check == -1) {
            return binaryStrengthSearch(a,midS+1,maxS,n,j);
        } else {
            return binaryStrengthSearch(a,minS,check,n,j);
        }
    }
    
    /*  
    @param a Array of pillar heights in non-decreasing order
    @param n Size of the pillar array
    @param j Maximum number of jumps
    @param s The strength to check
    @return The checked strength or -1 if strength was too low
    */
    private static int checkStrength(int[] a, int n, int j, int s) {
        int i = 0;
        int jump;
        for (int k = 0; k < j; k++) {
            jump = a[i]+s;
            i = binaryPillarSearch(a,i,n-1,jump);
        }
        if (i == n-1) {
            return s;
        } else {
            return -1;
        }
    }
    
    /*  
    @param a Array of pillar heights in non-decreasing order
    @param start index of the array
    @param end index of the array
    @param x The value to search for
    @return The index with a value equal to or downward closest to the value of x
    */
    private static int binaryPillarSearch(int[] a, int start, int end, int x) {
        if (start == end) {
            if (a[start] <= x) {
                return start;
            } else {
                return -1;
            }
        }
        int mid = (start + end)/2;
        if (x < a[mid]) {
            return binaryPillarSearch(a, start, mid, x);
        } else {
            int r = binaryPillarSearch(a, mid+1, end, x);
            if (r == -1) {
                return mid;
            } else {
                return r;
            }
        }
    };
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int j = scanner.nextInt();
        scanner.nextLine();
        String pillarInput = scanner.nextLine();
        int[] a = Arrays.stream(pillarInput.split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(pillarJumpers(a, n, j));
    }
}



/*  
    @param a Array of pillar heights
    @param n Size of the pillar array
    @param j Maximum number of jumps
    @return S The minimum required strength
    private static int pillarJumpers(int[] a, int n, int j) {
        int S = (a[n-1]/J);
        if (n == 2) {
            S-=a[0];
        }
        while(true) {
            int i = 0;
            int jump;
            for (int j = 0; j < j; j++) { 
                jump = a[i]+S;
                i = binaryPillarSearch(a,i,n-1,jump);
            }
            if (i == n-1) {
                return S;
            }
            S++;
        }
    }
    
    /*  
    @param a Array of ordered non-decreasing values
    @param start index of the array
    @param end index of the array
    @return The index equal to or closest to the value of x
    public static int binaryPillarSearch(int[] a, int start, int end, int x) {
        if (start == end) {
            if (a[start] <= x) {
                return start;
            } else {
                return -1;
            }
        }
        int mid = (start + end)/2;
        if (x < a[mid]) {
            return binaryPillarSearch(a, start, mid, x);
        } else {
            int r = binaryPillarSearch(a, mid+1, end, x);
            if (r == -1) {
                return mid;
            } else {
                return r;
            }
        }
    };
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int j = scanner.nextInt();
        scanner.nextLine();
        String pillarInput = scanner.nextLine();
        int[] a = Arrays.stream(pillarInput.split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(pillarJumpers(a, n, j));
    }
*/




/*
@param a Array of pillar heights
    @param n Size of the pillar array
    @param j Maximum number of jumps
    @return S The minimum required strength
    
    private static int pillarJumpers(int[] a, int n, int j) {
        int S = 1;
        while(true) {
            int i = 0;
            for (int j = 0; j < j; j++) { 
                int jump = a[i]+S;
                for (int z = i; z < n; z++) { 
                    if (z == n-1 && jump >= a[z] || z != n-1 && jump < a[z+1] && jump >= a[z]) {
                        i = z;
                    }   
                }
            }
            if (i == n-1) {
                return S;
            }
            S++;
        }
    }
*/