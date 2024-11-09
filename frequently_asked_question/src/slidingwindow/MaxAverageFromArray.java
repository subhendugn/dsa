package algorithmic_patterns.slidingwindow;

// leetcode - 643. Maximum Average Subarray I

public class MaxAverageFromArray {

    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int start = 0;
        double windowSum = 0;
        double max_avg = Integer.MIN_VALUE;

        for(int end = 0; end < n; end++){
            windowSum += nums[end];

            if(end - start +1 == k){
                // calculate the avg for the window
                double avg = windowSum/k;
                max_avg = Math.max(max_avg, avg);

                //move to next window
                // subtract the start element form the sum
                // increase start
                // sliding
                windowSum -= nums[start];
                start++;
            }
        }

        return max_avg;
    }

    public static void main(String[] args) {
        MaxAverageFromArray obj = new MaxAverageFromArray();
        System.out.println(obj.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4)); // 12.75
        System.out.println(obj.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 2)); // 26.5
    }
}
