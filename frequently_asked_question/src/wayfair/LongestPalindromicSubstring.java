package wayfair;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        // Test cases
        String test1 = "babad";
        String test2 = "cbbd";
        String test3 = "a";
        String test4 = "forgeeksskeegfor";
        String test5 = "abcd";

        // Print the longest palindromic substring for each test case
        System.out.println(longestPalindrome(test1)); // Output: "bab" or "aba"
        System.out.println(longestPalindrome(test2)); // Output: "bb"
        System.out.println(longestPalindrome(test3)); // Output: "a"
        System.out.println(longestPalindrome(test4)); // Output: "geeksskeeg"
        System.out.println(longestPalindrome(test5)); // Output: "a" (or any single character)
    }

    public static String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Expand around the current character as the center (odd-length palindromes)
            int len1 = expandAroundCenter(s, i, i);
            // Expand around the current character and the next (even-length palindromes)
            int len2 = expandAroundCenter(s, i, i + 1);

            // Get the maximum length from both expansions
            int len = Math.max(len1, len2);

            // Update start and end indices if a longer palindrome is found
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        // Return the longest palindromic substring
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        // Expand outwards while the characters match and within bounds
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // Return the length of the palindrome found
        return right - left - 1;
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        // Transform the string to handle even-length palindromes
        StringBuilder t = new StringBuilder();
        t.append('#');
        for (char c : s.toCharArray()) {
            t.append(c).append('#');
        }

        // Transformed string
        String modifiedString = t.toString();
        int n = modifiedString.length();
        int[] p = new int[n]; // Array to store palindrome radii
        int center = 0, right = 0;

        // Variables to track the longest palindrome
        int maxLen = 0;
        int centerIndex = 0;

        for (int i = 0; i < n; i++) {
            // Mirror index of `i` around `center`
            int mirror = 2 * center - i;

            // Use previously computed palindrome radius if within bounds
            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            // Expand around the current center
            int a = i + (p[i] + 1);
            int b = i - (p[i] + 1);
            while (a < n && b >= 0 && modifiedString.charAt(a) == modifiedString.charAt(b)) {
                p[i]++;
                a++;
                b--;
            }

            // Update the center and right boundary if expanded past `right`
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

            // Track the longest palindrome
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }

        // Extract the original longest palindromic substring
        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }
}

