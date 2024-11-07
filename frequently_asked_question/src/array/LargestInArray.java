package array;

public class LargestInArray {
    public static int largest(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(largest(new int[]{1, 8, 7, 56, 90})); // 90
        System.out.println(largest(new int[]{5, 5, 5, 5})); // 90
        System.out.println(largest(new int[]{10})); // 90
    }
}
