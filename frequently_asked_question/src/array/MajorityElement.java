import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement_bruteforce(int[] nums) {
        // n/2 majority element
        // majority element is the element that appears more than n/2 times
        // n is the length of the array
        // the array is non-empty and the majority element always exist in the array
        // the majority element is guaranteed to be unique


        // brute force approach
        int n = nums.length;

        for(int i=0; i<n; i++){ // O(n^2)
            int count = 0;

            for(int j=0; j<n; j++){
                if(nums[i] == nums[j]){
                    count++;
                }
            }
            if(count > n/2) return nums[i];
        }
        return -1;
    }

    public int majorityElement_better(int[] nums) {
        // better approach
        // using hashmap
        // key is the element and value is the count of the element

        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>(); // space O(nlogn)

        for(int i=0; i<n; i++){ // time O(n)
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }

        }

        // print the map
        System.out.println(map);

        // iterate map and check if the value is greater than n/2
        // return the key
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){ // time O(n)
            if(entry.getValue() > n/2){
                return entry.getKey();
            }
        }
        return -1;

    }

    public int majorityElement_optimal(int[] nums) {
        // optimal approach
        // Boyer-Moore Voting Algorithm

        int n = nums.length;
        int count = 0;
        int candidate = 0;

        for(int i=0; i<n; i++){ // time O(n) // space O(1)
            if(count == 0){
                candidate = nums[i];
            }
            if(nums[i] == candidate){
                count++;
            } else {
                count--;
            }
        }

        // iterate the array and check if the candidate is the majority element
        count = 0;
        for (int num : nums) { // time O(n) // space O(1)
            if (num == candidate) {
                count++;
            }
        }

        if (count > n / 2) {
            return candidate;
        }
        return -1;

    }





    public static void main(String[] args) {
    MajorityElement me = new MajorityElement();
    int[] nums = {6,5,5};
    System.out.println(me.majorityElement_bruteforce(nums)); // 3
    int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
    System.out.println(me.majorityElement_bruteforce(nums2)); // 2


    System.out.println(me.majorityElement_better(nums)); // 3
    System.out.println(me.majorityElement_better(nums2)); // 2


    System.out.println(me.majorityElement_optimal(nums)); // 3
    System.out.println(me.majorityElement_optimal(nums2)); // 2
    }
}
