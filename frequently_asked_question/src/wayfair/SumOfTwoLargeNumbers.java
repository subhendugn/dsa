package wayfair;

public class SumOfTwoLargeNumbers {
    /*
    Given two numbers as strings. The numbers may be very large (may not fit in long long int), the task is to find sum of these two numbers.

    Examples:

    Input  : str1 = "3333311111111111",
             str2 =   "44422222221111"
    Output : 3377733333332222

    Input  : str1 = "7777555511111111",
             str2 =    "3332222221111"
    Output : 7780887733332222
     */


    public static void main(String[] args){
        String str1 = "3333311111111111";
        String str2 = "44422222221111";
        System.out.println(sumOfTwoLargeNumbers(str1, str2));

        str1 = "7777555511111111";
        str2 = "3332222221111";
        System.out.println(sumOfTwoLargeNumbers(str1, str2));

        System.out.println(fibonacci(5)); // 5
        System.out.println(fibonacci(10)); // 55
        System.out.println(fibonacci(20)); // 6765
    }

    private static String sumOfTwoLargeNumbers(String str1, String str2) {
        // check length of both strings
        int len1 = str1.length();
        int len2 = str2.length();

        // which one is bigger
        if(len1 > len2){
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }

        // empty string to store result
        String result = "";

        // traverse from right to left and add digits
        int carry = 0;

        int diff = str2.length() - str1.length(); // difference in length of two strings
        for(int i = str1.length() - 1; i >= 0; i--){
            int sum = ((int)(str1.charAt(i) - '0') + (int)(str2.charAt(i + diff) - '0') + carry);
            result = sum % 10 + result;
            carry = sum / 10;
        }

        // add remaining digits of str2
        for(int i = diff - 1; i >= 0; i--){
            int sum = ((int)(str2.charAt(i) - '0') + carry);
            result = sum % 10 + result;
            carry = sum / 10;
        }

        // add carry
        if(carry > 0){
            result = carry + result;
        }

        return result;
    }



    // Fibonacci series: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
    // nth number in Fibonacci series is the sum of (n-1)th and (n-2)th number.
    // For example, 5th number in Fibonacci series is 3 + 2 = 5.
    // Implement a function to find nth number in Fibonacci series using the above function.
    public static String fibonacci(int n) {
        if(n == 0) return "0";
        if(n == 1) return "1";
        String a = "0";
        String b = "1";
        String c = "";
        for(int i = 2; i <= n; i++){
            c = sumOfTwoLargeNumbers(a, b);
            a = b;
            b = c;
        }
        return c;
    }

}
