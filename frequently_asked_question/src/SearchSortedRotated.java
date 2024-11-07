package binary_search;

public class SearchSortedRotated {
    int search_unique(int[] nums, int target) {

        int n = nums.length;
        int low = 0;
        int high = n-1;
        int mid = (high+low)/2;

        while(low <= high){

            if(nums[mid] == target){
                return mid;
            }
            // find which part is sorted
            if(nums[low] <= nums[mid]){
                // left part is sorted
                if(nums[low] <= target && target <= nums[mid]){
                    // means it can be in left part
                    high = mid-1;
                } else {
                    // means it can be in right part
                    low = mid+1;
                }

            } else {
                // right part is sorted
                if(nums[mid] <= target && target <= nums[high]){
                    // means it can be in right part
                    low = mid+1;
                } else {
                    // means it can be in left part
                    high = mid - 1;
                }
            }
            mid = (low+high)/2;
        }

        // time O(log n)
        // space O(1)


        return -1;
    }

    public boolean search_duplicate(int[] nums, int target) {
        // contains duplicates
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int mid = (high+low)/2;



        while(low <= high){
           if(nums[mid] == target){
               return true;
           }

           // check if duplicates
            if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                // shrink the array
                low++;
                high--;
                continue;
            }

            // check which part is sorted
            if(nums[low] <= nums[mid]){
                // left part is sorted

                // check if target present in left part
                if(nums[low] <= target && target <= nums[mid]){
                    // can be present
                    high = mid-1;
                } else {
                    // discard the sorted part
                    low = mid+1;
                }
            } else {
                // right part is sorted

                // check if target present in right part

                if(nums[mid] <= target && target <= nums[high]){
                    // can be present
                    low = mid+1;
                } else {
                    // discard the sorted part
                    high = mid -1;
                }


            }
            mid = (low+high)/2;
        }


        return false;
    }

    public static void main(String[] args) {
        SearchSortedRotated ssr = new SearchSortedRotated();
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(ssr.search_unique(nums, 0)); // 4
        System.out.println(ssr.search_unique(nums, 3)); // -1
        int[] nums2 = {4,5,6,7,0,1,2};
        System.out.println(ssr.search_unique(nums2, 3)); // -1


        int[] nums3 = {2,5,6,0,0,1,2};
        System.out.println("With Duplicates");
        System.out.println(ssr.search_duplicate(nums3, 0)); // true

        int[] nums4 = {2,5,6,0,0,1,2};
        System.out.println(ssr.search_duplicate(nums4, 3)); // false
    }
}
