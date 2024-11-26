package wayfair;

public class LongestPalindromicSubstringTest {

    public static void main(String[] args) {
        testLongestPalindrome();
    }

    public static void testLongestPalindrome() {
        System.out.println(LongestPalindromicSubstring.longestPalindrome("babad").equals("bab")); // Output: "bab" or "aba"
        System.out.println(LongestPalindromicSubstring.longestPalindrome("cbbd")); // Output: "bb"
        System.out.println(LongestPalindromicSubstring.longestPalindrome("a")); // Output: "a"
        System.out.println(LongestPalindromicSubstring.longestPalindrome("forgeeksskeegfor")); // Output: "geeksskeeg"
        System.out.println(LongestPalindromicSubstring.longestPalindrome("abcd")); // Output: "a" (or any single character)
    }
}