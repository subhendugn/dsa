package binary_search;

public class FindPeakSorted {
    public int findPeakElement(int[] nums) {

        // return the peak element index
        // peak element is the element which is greater than its neighbours
        // [1,2,3,1] => 3
        // [1,2,1,3,5,6,4] => 6
        // [1,2,3,4,5,6,7,8,9,10] => 10
        // [3,4,3,2,1] => 4


        int n = nums.length;


        if(n==1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;

        int low = 1;
        int high = n-2;
        while(low <= high){
            int mid = (low+high)/2;

            if( nums[mid] > nums[mid+1] && nums[mid-1] < nums[mid]){
                // peak found
                return mid;
            }
            if( nums[mid] > nums[mid-1]){
                // increasing
                low = mid+1;
            } else {
                // decreasing
                high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindPeakSorted obj = new FindPeakSorted();
        System.out.println(obj.findPeakElement(new int[]{1,2,3,1})); // 2

        System.out.println(obj.findPeakElement(new int[]{1,2,1,3,5,6,4})); // 5

        System.out.println(obj.findPeakElement(new int[]{1,2,3,4,5,6,7,8,9,10})); // 9

        System.out.println(obj.findPeakElement(new int[]{3,4,3,2,1})); // 1

    }
}
