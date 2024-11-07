package binary_search;

public class BinarySearch {
    public int binarySearch(int[] arr, int target) {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int mid = low+high/2;

        while (low <= high) {
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }

        return -1;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] arr = {1, 2, 4, 5, 6, 7, 8, 9};
        System.out.println(bs.binarySearch(arr, 9)); // 3
    }

}
