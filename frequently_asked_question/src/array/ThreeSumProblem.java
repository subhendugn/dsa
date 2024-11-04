import java.util.*;

public class ThreeSumProblem {
    public List<List<Integer>> threeSum_bruteforce(int[] nums) {

        // brute force approach
        int n = nums.length;

        List<List<Integer>> result = new ArrayList<>();

        Set<List<Integer>> set = new HashSet<>();

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        //create a list adding the elements inline
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.sort(null);

                        set.add(list);
                    }


                }
            }
        }

        result.addAll(set.stream().toList());

        return result;
    }

    public List<List<Integer>> threeSum_better(int[] nums) {
        // better approach

        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        Set<List<Integer>> set = new HashSet<>();

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int k = -(nums[i] + nums[j]);
                if(hashSet.contains(k)){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(k);
                    list.sort(null);
                    set.add(list);
                } else {
                    hashSet.add(nums[j]);
                }
            }
            // clear the hashset
            hashSet.clear();
        }

        result.addAll(set.stream().toList());

        return result;
    }

    public List<List<Integer>> threeSum_optimal(int[] nums) {
        // optimal approach
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        // sort the array
        Arrays.sort(nums); // time complexity - O(nlogn) - quick sort // space complexity - O(1)

        // two pointer approach


        for(int i=0; i<n; i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int j = i+1;
            int k = n-1;

            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if( sum < 0){
                    j++;
                } else if(sum > 0){
                    k--;
                } else {
                    // triplet found
                    result.add(Arrays.asList(nums[i], nums[j], nums[k])); // space complexity - O(n) - list to store the result of the sum
                    j++;
                    k--;

                    // skip the duplicates
                    while(j<k && nums[j] == nums[j-1]){ // time complexity - O(n)
                        j++;
                    }
                    while(j<k && nums[k] == nums[k+1]){ // time complexity - O(n)
                        k--;
                    }
                }
            }
        }


        return result;
    }




        public static void main(String[] args) {
    ThreeSumProblem threeSumProblem = new ThreeSumProblem();
    int[] nums = {-2,0,1,1,2};
    List<List<Integer>> result = threeSumProblem.threeSum_bruteforce(nums);
    System.out.println(result);
    // calculate the time complexity
    // O(n^3) - brute force
    // space complexity - O(n) - set to store the result of the sum
    // space complexity - O(n) - list to store the result of the sum

    List<List<Integer>> result1 = threeSumProblem.threeSum_better(nums);
    System.out.println(result1);
    // calculate the time complexity
    // O(n^2) - better approach
    // space complexity - O(n) - set to store the result of the sum
    // space complexity - O(n) - list to store the result of the sum
    // space complexity - O(n) - hashset to store the elements


    List<List<Integer>> result2 = threeSumProblem.threeSum_optimal(nums);
    System.out.println(result2);



    }
}
