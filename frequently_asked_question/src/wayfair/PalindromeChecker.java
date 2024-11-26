package wayfair;

public class PalindromeChecker {
    public static void main(String[] args) {
        // Test strings
        String test1 = "racecar";
        String test2 = "hello";
        String test3 = "Madam";
        String test4 = "A man, a plan, a canal: Panama";

        // Check if the strings are palindromes
        System.out.println(isPalindrome(test1)); // true
        System.out.println(isPalindrome(test2)); // false
        System.out.println(isPalindrome(test3)); // true
        System.out.println(isPalindrome(test4)); // true
    }

    public static boolean isPalindrome(String s) {
        // Normalize the string by removing non-alphanumeric characters and converting to lowercase
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Use two pointers to compare characters from the start and end
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false; // If mismatch found, not a palindrome
            }
            left++;
            right--;
        }
        return true; // All characters match
    }
}

