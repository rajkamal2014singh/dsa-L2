package ArraysAndString;

import java.util.Scanner;

/**
 *
 * Have a faulty keyboard check if actual name can be derived from entered name
 *
 */
public class FaultyKeyboard {
    public static boolean isPossible(String name, String typed){
        if(name.length() > typed.length()){
            return false;
        }

        int i = 0;
        int j = 0;
        while(i < name.length() && j < typed.length()){
            if(name.charAt(i) == typed.charAt(j)){
                // both the character are same
                i++;
                j++;
            }
            else if( i > 0 && name.charAt(i-1) == typed.charAt(j)){
                // else typed character is extra and points to previous character in name
                j++;
            }
            else{
                return false;
            }
        }

        while(j < typed.length()){
            // check if name traversal is finished then last character in name should be same as the remaining characters in typed
            if(name.charAt(i-1) != typed.charAt(j)){
                return false;
            }
            j++;
        }

        // if any character in name is left then there is fault
        if(i < name.length()){
            return false;
        }

        return true;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String name = scn.next();
        String typed = scn.next();

        boolean canType = isPossible(name, typed);
        System.out.println("String can be typed with faulty keyboard ? : " + canType);
    }
}
