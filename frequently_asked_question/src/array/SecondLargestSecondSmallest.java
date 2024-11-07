package array;

public class SecondLargestSecondSmallest {
    public int getSecondLargest(int[] arr) {
        int n = arr.length;

        if(n<=2) return -1;
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            if(arr[i] > largest){
                secondLargest = largest;
                largest = arr[i];
            } else if( arr[i] > secondLargest && arr[i] != largest){
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }

    public int getSecondSmallest(int[] arr) {
        int n = arr.length;

        if(n<=2) return -1;

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            if(arr[i]<smallest){
                secondSmallest = smallest;
                smallest = arr[i];
            } else if(arr[i] > secondSmallest && arr[i] != smallest){
                secondSmallest = arr[i];
            }
        }
        return secondSmallest;
    }

    public static void main(String[] args) {
        SecondLargestSecondSmallest obj = new SecondLargestSecondSmallest();
        System.out.println(obj.getSecondLargest(new int[]{12, 35, 1, 10, 34, 1})); // 34
        System.out.println(obj.getSecondLargest(new int[]{10, 10})); // -1
        System.out.println(obj.getSecondSmallest(new int[]{10, 10})); // -1
    }
}
