package array;

public class MaximumProductSubarray {

    public static int maxProduct(int[] nums) {

        int max = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;
        int n = nums.length;

        for(int i=0; i<n; i++){

            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;
            prefix = prefix*nums[i];
            suffix = suffix*nums[n-i-1];

            max = Math.max(max, Math.max(prefix, suffix));
        }


        return max;

    }


    public static void main(String[] args){
        int[] nums1 = new int[]{2,3,-2,4};
        int[] nums2 = new int[]{2,4,5,0,3,6};
        System.out.println(MaximumProductSubarray.maxProduct(nums1));
        System.out.println(MaximumProductSubarray.maxProduct(nums2));
    }
}
