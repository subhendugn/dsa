package wayfair;


public class PalindromeCheckerTest {

    public static void main(String[] args) {
        testIsPalindrome();
    }

    public static void testIsPalindrome() {
        System.out.println(PalindromeChecker.isPalindrome("racecar")); // true
        System.out.println(PalindromeChecker.isPalindrome("hello")); // false
        System.out.println(PalindromeChecker.isPalindrome("Madam")); // true
        System.out.println(PalindromeChecker.isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(PalindromeChecker.isPalindrome("Palindrome")); // false
        System.out.println(PalindromeChecker.isPalindrome("")); // true (empty string)
        System.out.println(PalindromeChecker.isPalindrome(" ")); // true (single space)
        System.out.println(PalindromeChecker.isPalindrome("Able was I ere I saw Elba")); // true
    }
}