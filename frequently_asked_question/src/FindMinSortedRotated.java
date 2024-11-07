package binary_search;

public class FindMinSortedRotated {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;


        int min = Integer.MAX_VALUE;

        while(low<=high) {
            int mid = (low+high)/2;
            // find out which part is sorted
            if(nums[low] <= nums[mid]){
                //left part sorted
                // find min
                min = Math.min(min, nums[low]);
                low = mid+1;
            } else {
                // right part sorted
                min = Math.min(min, nums[mid]);
                high = mid-1;
            }


        }

        return min;
    }

    public static void main(String[] args) {
        FindMinSortedRotated obj = new FindMinSortedRotated();
        System.out.println(obj.findMin(new int[]{3,4,5,1,2})); // 1

        System.out.println(obj.findMin(new int[]{4,5,6,7,0,1,2})); // 0

        System.out.println(obj.findMin(new int[]{11,13,15,17})); // 11

        System.out.println(obj.findMin(new int[]{2,1})); // 1

        System.out.println(obj.findMin(new int[]{1})); // 1

        System.out.println(obj.findMin(new int[]{1,2})); // 1
    }
}
