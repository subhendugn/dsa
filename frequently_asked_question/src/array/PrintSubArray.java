package array;

public class PrintSubArray {

    public static void print_subarray(int[] num){

        // time complexity o(n^3)
        int n = num.length;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int sum = 0;
                for(int k=i; k<=j; k++){
                    System.out.print(num[k]);
                    sum = sum+num[k];
                }
                System.out.print("\n");
                max = Math.max(max, sum);
            }

        }
        System.out.println("Max subarray sum = "+ max);
    }

    public static void print_subarray_better(int[] num){
        // time complexity o(n^2)
        int n = num.length;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum = sum+num[j];

            }
            max = Math.max(max, sum);

        }
        System.out.println("Max subarray sum = "+ max);
    }

    public static void main(String[] args){
        int[] nums1 = new int[]{1,1,-5,1,2};
        PrintSubArray.print_subarray(nums1);
        PrintSubArray.print_subarray_better(nums1);
    }
}
