package algorithmic_patterns.slidingwindow;

// Leetcode - 1004. Max Consecutive Ones III
public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int start = 0;
        int max = Integer.MIN_VALUE;
        int zeros = 0;

        for(int end=0; end<n; end++){
            if(nums[end] == 0) zeros++;

            if(zeros > k){
                while(zeros > k){
                    // trim it from right
                    if(nums[start] == 0) {
                        zeros--;

                    }
                    start++;
                }
            }
            int windowLen = end-start+1;
            max = Math.max(max, windowLen);
        }

        return max;
    }

    public static void main(String[] args){
        MaxConsecutiveOnesIII maxConsecutiveOnesIII = new MaxConsecutiveOnesIII();
        System.out.println(maxConsecutiveOnesIII.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2)); // 6
        System.out.println(maxConsecutiveOnesIII.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3)); // 10
    }
}
