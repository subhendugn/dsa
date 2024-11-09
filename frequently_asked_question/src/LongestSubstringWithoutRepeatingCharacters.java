package algorithmic_patterns.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Leetcode 3. Longest Substring Without Repeating Characters
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0;
        int n = s.length();

        int max = 0;

        for(int end=0; end<n; end++){
            char character = s.charAt(end);

            if(set.contains(character)){
                // if character already present in set
                // repeating char
                while(start < end && set.contains(character)){
                    // shrink set from right side
                    set.remove(s.charAt(start));
                    start++;
                }

            }

            set.add(character);
            int windowLen = end-start+1;
            max = Math.max(max, windowLen);
        }

        return max;
    }

    public static void main(String[] args){
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(obj.lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(obj.lengthOfLongestSubstring("pwwkew")); // 3
        System.out.println(obj.lengthOfLongestSubstring("tmmzuxt")); // 5

    }
}
