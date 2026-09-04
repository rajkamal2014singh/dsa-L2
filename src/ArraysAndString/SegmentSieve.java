package ArraysAndString;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * need to take a look once again
 * We are given range a and b we need to find the all the primes in that range
 * since b can be very big number computing every number from 0 to n will have space complexity limitation
 * so build a logic with the help of sieve in a way that it is efficient
 *
 */
public class SegmentSieve {
    public static ArrayList<Integer> sieve(int n){
        boolean[] sieve = new boolean[n+1]; // false -> prime, true -> not prime

        for(int i=2; i*i<= n; i++){
            if(sieve[i] == false){
                for(int j=2*i; j<=n; j+=i){
                    sieve[j] = true;
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for(int i=2; i<sieve.length; i++){
            if(sieve[i] == false){
                res.add(i);
            }
        }
        return res;
    }
    public static void segmentSieve(int a, int b){
        int rootb = (int)Math.sqrt(b);
        boolean[] ssieve = new boolean[b - a + 1]; // false -> prime, true -> not prime
        ArrayList<Integer> primes = sieve(rootb);

        for(int prime: primes){
            int multiple = (int)Math.ceil((a*1.0)/ prime);
            if(multiple == 1){
                multiple++;
            }
            int idx = multiple*prime - a;
            for(int j=idx; j<ssieve.length; j++){
                ssieve[j] = true;
            }
        }

        System.out.println("Primes in range " + a + " " + b + " are ");
        for(int i=0; i<ssieve.length; i++){
            if(ssieve[i] == false && i + a != 1){
                int val = i + a;
                System.out.print(val);
            }
        }
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        segmentSieve(a, b);
    }
}
