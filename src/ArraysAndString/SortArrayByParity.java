package ArraysAndString;

import java.util.Scanner;

/**
 *
 * Sort array where Even first odd afterwords also maintaining the current order
 * Similar as sort of 0 and 1, or sort (0, 1, 2)
 *
 * so for these types of questions here we keep two pointers and with these pointers we created three section.
 * section 1 -> 0 to j-1 -> contains our fist section(here even)
 * section 2 -> j to i -> contains second section(here odd)
 * section 3 -> i+1 to n -> unknow section here we iterate and include elements in the desired section
 *
 * 8
 * [2 4 3 1 5 6 9 7] -> [2 4 6 1 5 3 9 7]
 */
public class SortArrayByParity {
    public static void sortByParity(int[] arr){
        int i = 0;
        int j = 0;
        int n = arr.length;
        while (i < n){
            if(arr[i]%2 ==0){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
                i++;
            }else{
                i++;
            }
        }
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }

        System.out.println("Array before sort by parity : ");
        for (int j : arr) {
            System.out.print(j + " ");
        }

        sortByParity(arr);
        System.out.println("Array after sort by parity : ");
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
