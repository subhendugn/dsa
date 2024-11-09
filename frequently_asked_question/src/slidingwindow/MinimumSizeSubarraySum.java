package algorithmic_patterns.slidingwindow;


public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int start = 0;
        int min = Integer.MAX_VALUE;

        int sum = 0;

        for(int end=0; end<n; end++){
            sum += nums[end];

            if( sum >= target ){
                while(sum >= target) {
                    int windowLen = end-start+1;
                    min = Math.min(min, windowLen);

                    sum -= nums[start];
                    start++;
                }
            } else if(end == n-1) {
                min = 0;
            }
        }

        return min;
    }

    public static void main(String[] args){
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();

        System.out.println(minimumSizeSubarraySum.minSubArrayLen(7, new int[]{2,3,1,2,4,3})); // 2
        System.out.println(minimumSizeSubarraySum.minSubArrayLen(4, new int[]{1,4,4})); // 1
        System.out.println(minimumSizeSubarraySum.minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1})); // 0
        System.out.println(minimumSizeSubarraySum.minSubArrayLen(11, new int[]{1,2,3,4,5})); // 3
    }
}
