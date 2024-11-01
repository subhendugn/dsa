package array;

public class MaximumSumSubarray {
    public static int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int n = nums.length;
        int sum = 0;
        int startIndex = -1;
        int endIndex = -1;
        int start = 0;


        for(int i=0; i<n; i++){
            sum = sum+nums[i];

            if(sum == 0) {
                start = i;
            }

            if(sum>max) {
                max = sum;
                startIndex = start;
                endIndex = i;
            }

            if(sum<0) {
                sum = 0;
            }
        }



        return max;
    }

    public static void main(String[] args){
        int[] nums1 = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] nums2 = new int[]{5,4,-1,7,8};
        int[] nums3 = new int[]{1};
        int[] nums4 = new int[]{-1};
        System.out.println(MaximumSumSubarray.maxSubArray(nums1));
        System.out.println(MaximumSumSubarray.maxSubArray(nums2));
        System.out.println(MaximumSumSubarray.maxSubArray(nums3));
        System.out.println(MaximumSumSubarray.maxSubArray(nums4));
    }
}
