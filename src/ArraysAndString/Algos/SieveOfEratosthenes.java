package ArraysAndString.Algos;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * So we know a optimized approach to find if a number is prime or not
 * and the best time complexity is O(root(n))
 * but what if we want to check for a range of number starting from zero to n
 * so overall it becomes O(n*(root(n))
 * and retrieval is done many times so every time will we do that O(root(n)) operation
 *
 * is there any better approach yes there is with little extra space of size O(n) we can
 *
 * Approach
 * Create a array of size n+1
 * every index store if current index is a prime or not
 * initially store true everywhere and traverse on each index till less than root(n)
 * and for every element which is prime go and make all its factors less than n to false
 *
 * so time complexity is
 * n/2 + n/3 + n/4 + ...
 * this is for root(n) elements
 *
 * so overall time complexity becomes O(n(log(log(n))) which is efficient than previous approach
 *
 *
 */
public class SieveOfEratosthenes {
    public static void sieve(int n){
        boolean[] sieve = new boolean[n+1];

        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;

        for(int i=2; i*i<= n; i++){
            if(sieve[i] == true){
                for(int j=2*i; j<=n; j+=i){
                    sieve[j] = false;
                }
            }
        }

        System.out.println("Prime numbers till " + n + " are ");
        // true in sieve means is a prime
        for(int i=0; i<=n; i++){
            if(sieve[i]){
                System.out.print(i + " ");
            }
        }
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        sieve(n);
    }
}
