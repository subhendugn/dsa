package binary_search;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = findMax(piles);

        while(low<= high){
            int mid = low + (high-low)/2;
            if(calculateTotalHours(piles,mid) <= h){
                // possible to eat in h hours
                // try to minimize the speed
                high = mid-1;
            } else {
                // not possible to eat in h hours
                // try to maximize the speed
                low = mid+1;
            }

        }

        // time complexity: O(n log m)
        return low;
    }

    public int calculateTotalHours(int[] piles, int h){
        int hours = 0;

        for(int i=0; i<piles.length; i++){
            hours += Math.ceil((double)piles[i]/(double)h);
        }
        return hours;
    }

    public int findMax(int[] piles){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<piles.length; i++){
            max = Math.max(max, piles[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        KokoEatingBananas obj = new KokoEatingBananas();
        System.out.println(obj.minEatingSpeed(new int[]{3,6,7,11}, 8)); // 4
        System.out.println(obj.minEatingSpeed(new int[]{30,11,23,4,20}, 5)); // 30
        System.out.println(obj.minEatingSpeed(new int[]{30,11,23,4,20}, 6)); // 23
        System.out.println(obj.minEatingSpeed(new int[]{805306368,805306368,805306368}, 1000000000)); // 3


    }
}
