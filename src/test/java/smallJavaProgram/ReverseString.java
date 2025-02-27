package smallJavaProgram;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class ReverseString {


    public char[] reverseStr(String str) {
        char[] charArray = str.toCharArray();
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            char tmp;
            tmp = charArray[i];
            int opposite = length - 1 - i;
            charArray[i] = charArray[opposite];
            charArray[opposite] = tmp;
        }
        return charArray;
    }

    @Test
    void runReverseStr() {
        System.out.println(reverseStr("Mai"));
    }

    String reverseWord(String word) {
        String[] words = word.split(" ");
        int length = words.length;
        for (int i = 0; i < length / 2; i++) {
            String tmp;
            tmp = words[i];
            int opposite = length - 1 - i;
            words[i] = words[opposite];
            words[opposite] = tmp;
        }
        return String.join(" ", words);
    }

    @Test
    void runReverseWord() {
        System.out.println(reverseWord("Pham Dinh Quy"));
    }

    boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    @Test
    void testPalindrome() {
        String str = "annaca";
        System.out.println(isPalindrome(str));
    }

    String removeDuplicatedChar(String str) {
        LinkedHashSet<Character> noDup = new LinkedHashSet<>();
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (noDup.add(c))
                result.append(c);
        }
        return result.toString();

    }

    String removeDuplicatedChar2(String str) {
        Set<String> noDup = new LinkedHashSet(Arrays.asList(str.split(" ")));

        return String.join(" ", noDup);

    }

    @Test
    void testRemoveDupChar() {
//        String str = "annaca";

        String str = "big bear big";
//        System.out.println(removeDuplicatedChar(str));
        System.out.println(removeDuplicatedChar2(str));
    }

    boolean isAmstrongNumber(int num) {
        int origin = num;

        int total = 0;


        while (num > 0) {
            int last = num % 10;
            total += last * last * last;
            System.out.println(last);
            num = num / 10;
        }
        System.out.println("Total : " + total);
        return total == origin;
    }

    @Test
    void testAmstrongNum() {
        int num = 153;
        System.out.println("Is Amstrong Num: " + isAmstrongNumber(num));
    }

    HashMap<String, Integer> wordOccurance(String word) {
        String[] words = word.split(" ");
        HashMap<String, Integer> occur = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (occur.containsKey(words[i]))
                occur.put(words[i], occur.get(words[i]) + 1);
            else
                occur.put(words[i], 1);
        }

        return occur;
    }

    HashMap<String, Integer> wordOccurance2(String word) {
        String[] words = word.split(" ");
        HashMap<String, Integer> occur = new HashMap<>();
        for (String w : words)
            occur.put(w, occur.getOrDefault(w, 0) + 1);

        return occur;
    }

    @Test
    void testWordOccur() {
        HashMap<String, Integer> stringIntegerHashMap = wordOccurance2("Alice is girl and Bob is boy");
        System.out.println("HashMap : " + stringIntegerHashMap);
    }

}
