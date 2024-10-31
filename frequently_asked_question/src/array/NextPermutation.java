package array;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int index = -1;
        int n = nums.length;


        // finding the breakpoint
        for(int i=n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }

        // last permutation
        // sort this will get the first permutation
        if(index == -1){
            // reverse
            NextPermutation.reverse(nums, 0);
        } else {
            // swap the index with next bigger no
            for(int i=n-1; i>=0; i--){
                if(nums[i]>nums[index]){
                    // swap
                    NextPermutation.swap(nums, i, index);
                    NextPermutation.reverse(nums, index+1);
                    break;
                }
            }
        }



        System.out.print("Next Permutation -> ");
        for(int i = 0; i<n; i++){
            System.out.print(nums[i]);
        }

    }

    public static int[] swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
        return nums;
    }

    public static int[] reverse(int[] nums, int startIndex){

        int i = startIndex;
        int j = nums.length-1;

        while (i<j){
            NextPermutation.swap(nums, i, j);
            i++;
            j--;
        }

        return nums;
    }

    public static void main(String[] args){
        int[] arr = new int[]{1,3,2};
        NextPermutation.nextPermutation(arr);
    }
}
