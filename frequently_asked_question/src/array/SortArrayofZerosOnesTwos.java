package array;

public class SortArrayofZerosOnesTwos {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for(int i=0; i<n; i++){ // time O(n) // space O(1)
            if(nums[i] == 0){
                count0++;
            } else if(nums[i] == 1){
                count1++;
            } else {
                count2++;
            }
        }

        for(int i=0; i<n; i++){
            if(count0 > 0){
                nums[i] = 0;
                count0--;
            } else if(count1 > 0){
                nums[i] = 1;
                count1--;
            } else {
                nums[i] = 2;
            }
        }
    }

    public static void main(String[] args) {
        SortArrayofZerosOnesTwos obj = new SortArrayofZerosOnesTwos();
        int[] nums = {2,0,2,1,1,0};
        obj.sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }

        System.out.println("");
        int[] nums1 = {2,0,1};
        obj.sortColors(nums1);

        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}
