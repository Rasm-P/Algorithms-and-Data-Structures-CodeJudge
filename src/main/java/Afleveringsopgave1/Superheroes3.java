
package Afleveringsopgave1;

import java.util.Scanner;

public class Superheroes3 {
    
    /*  
    @param Array of random superhero prices
    @param Size of the random superhero array
    @return The number of different prices of superheroes
    */
    private static int SuperheroPrices(int[] A, int m) {
        int prices = 0;        
        for (int i = 0; i < m;i++) {
            boolean same = false;
            for (int j = i; j > 0;j--) {
                if (A[i] == A[j-1]) {
                    same = true;
                }
            }
            if (i == 0 || !same) {
                prices++;
            }
        }
        return prices;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] A = new int[m];
        for (int i = 0; i < m; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(SuperheroPrices(A, m));
    }
}