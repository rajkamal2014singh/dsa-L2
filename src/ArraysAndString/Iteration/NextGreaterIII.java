package ArraysAndString.Iteration;


import java.util.Scanner;

/**
 *
 * Next greater element III
 * for a given string need to find a string which is just greater than current string
 * examples
 * 123 -> 132
 * 562945321 -> 562951234
 * 32495341654321 -> 32495342654311 -> 32495342113456
 *
 */
public class NextGreaterIII {
    public static String getNextGreaterIII(String str){
        char[] chs = str.toCharArray();
        int i = chs.length - 2;
        while(i>=0 && chs[i] >= chs[i+1]){
            i--;
        }
        if(i==-1){
            return "-1";
        }
        int j = chs.length - 1;
        while(chs[i] >= chs[j]){
            j--;
        }
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;

        StringBuilder ans = new StringBuilder();
        for(int k=0; k<=i; k++){
            ans.append(chs[k]);
        }

        for(int l=chs.length - 1; l>i; l--){
            ans.append(chs[l]);
        }
        return ans.toString();
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        String res = getNextGreaterIII(str);
        if(res.equals("-1")){
            System.out.println("There is no greater element for " + res);
        }
        else {
            System.out.println("Next greater element for " + str + " is " + res);
        }
    }
}
