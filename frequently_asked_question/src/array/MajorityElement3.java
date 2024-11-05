import java.util.*;

public class MajorityElement3 {
    public List<Integer> majorityElement_better(int[] nums) {
        // n/3 majority element
        // majority element is the element that appears more than n/2 times
        // n is the length of the array
        // the array is non-empty and the majority element always exist in the array
        // the majority element is guaranteed to be unique
        // return all the majority elements

        // better approach
        // using hashmap
        // key is the element and value is the count of the element

        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        List<Integer> result = new ArrayList<>();

        // least occurrence of the majority element:
        int mini = (int)(n / 3) + 1;


        for(int i=0; i<n; i++){ // time O(n)
            int value = map.getOrDefault(nums[i], 0);
            map.put(nums[i], value + 1);


            if(map.get(nums[i]) == mini){
                result.add(nums[i]);
//
            }

            if(result.size() > mini) break;



//
        }


        // print the map
//        System.out.println(map);


        // sort the result
        Collections.sort(result);

        return result;
    }


    public List<Integer> majorityElement_optimal(int[] nums) {
        // n/3 majority element
        // optimal approach
        // Boyer-Moore Voting Algorithm

        int n = nums.length;
        int count1 = 0;
        int count2 = 0;
        int candidate1 = Integer.MIN_VALUE;
        int candidate2 = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            if(count1 == 0 && nums[i] != candidate2){
                count1 = 1;
                candidate1 = nums[i];
            }
            else if(count2 == 0 && nums[i] != candidate1){
                count2 = 1;
                candidate2 = nums[i];
            }
            else if(nums[i] == candidate1){
                count1++;
            }
            else if(nums[i] == candidate2){
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }

        // manually cheking if elements are majority or not
        count1 = 0;
        count2 = 0;

        for(int i : nums){
            if(i == candidate1){
                count1++;
            } else if(i == candidate2){
                count2++;
            }
        }

        int mini = (int)(n / 3) + 1;
        List<Integer> result = new ArrayList<>();
        if(count1 >= mini){
            result.add(candidate1);
        }
        if(count2 >= mini){
            result.add(candidate2);
        }

        // sort
        Collections.sort(result);
        return result;
    }






        public static void main(String[] args) {
    MajorityElement3 me = new MajorityElement3();
    int[] nums = {3,2,3};
    System.out.println(me.majorityElement_better(nums)); // 3
    int[] nums2 = {1};
    System.out.println(me.majorityElement_better(nums2)); // 1

    int[] nums3 = {1,2};
    System.out.println(me.majorityElement_better(nums3)); // 1,2

    int[] nums4 = {2,2};
    System.out.println(me.majorityElement_better(nums4)); // 2

    int[] nums5 = {3,2,2,2,3};
    System.out.println(me.majorityElement_better(nums5)); // 2,3


    System.out.println("Optimal");

    System.out.println(me.majorityElement_optimal(nums)); // 3
    System.out.println(me.majorityElement_optimal(nums2)); // 1
    System.out.println(me.majorityElement_optimal(nums3)); // 1,2
    System.out.println(me.majorityElement_optimal(nums4)); // 2
    System.out.println(me.majorityElement_optimal(nums5)); // 2,3
    }
}
