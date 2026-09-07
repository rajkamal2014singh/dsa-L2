package ArraysAndString.PatternMatching;

import java.util.*;

/***
 *
 * Given a array of words and a string pattern we need to find all the string that match the pattern
 * we can map any character to any character but same character can't map to multiple character values
 *
 * for every string check if it matches the pattern or not
 * write a function that checks this condition
 *
 * We will creake a hashmap to map the charcter of pattern to character of string
 * and iterate over pattern and get same index character for string if
 * current pattern character is in map then mapped character should be equal to the string's character
 * also we will create a hashmap to strore the characters of strings that are mapped otherwise
 * same character will get mapped to mutiple characters of pattern we can max map one character to the other character
 [mno rst rss bll lml aaa], pattern = epp -> [rss bll]
 [abx pqr tcu], pattern = aaa -> []
 *
 */
public class FindAndReplacePattern {
    public static boolean isMatching(String word, String pattern){
        HashMap<Character,Character> mp = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        for(int i=0; i<pattern.length(); i++){
            char wch = word.charAt(i);
            char pch = pattern.charAt(i);

            if(mp.containsKey(pch)){
                if(mp.get(pch) != wch){
                    // character is already mapped to some other character
                    return false;
                }
            }
            else{
                // pattern character is new for mapping
                if(set.contains(wch)){
                    // but current word character is already mapped to some other character from pattern
                    return false;
                }

                mp.put(pch, wch);
                set.add(wch);
            }
        }
        return true;
    }
    public static List<String> wordsMatchingPattern(String[] words, String pattern){
        List<String> ans = new ArrayList<>();
        for(int i=0; i< words.length; i++){
            if(isMatching(words[i], pattern)){
                ans.add(words[i]);
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] words = new String[n];

        for(int i=0; i<words.length; i++){
            words[i] = scn.next();
        }
        String pattern = scn.next();

        List<String> res = wordsMatchingPattern(words, pattern);
        System.out.println("String that match pattern " + pattern + " are : ");
        for(String match : res){
            System.out.print(match + " ");
        }
    }
}
