import java.util.ArrayList;

public class MissingAndRepeating {

    public ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        // find the repeating and the missing element
        // the array is of size n
        // the array elements are in the range of 1 to n
        // the array has only one repeating element but can have multiple missing elements
        // the array is non-empty
        // the repeating element is guaranteed to be unique
        // the missing element is guaranteed to be unique

        // find the repeating element
        int n = arr.length;
        int[] hash = new int[n+1];

        for(int i=0; i<n; i++){
            hash[arr[i]]++;
        }

        int repeating = -1;
        int missing = -1;

        for(int i=0; i<n+1; i++){
            if(hash[i] > 1){
                repeating = i;
            } else if(hash[i] == 0){
                missing = i;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(repeating);
        result.add(missing);

        return result;
    }

    public static void main(String[] args) {
        // call findTwoElement
        int[] arr = {2, 2};
        MissingAndRepeating mar = new MissingAndRepeating();
        System.out.println(mar.findTwoElement(arr)); // [2, 1]

        int[] arr1 = {1, 3, 3};
        System.out.println(mar.findTwoElement(arr1)); // [3, 2]

        int[] arr2 = {4, 3, 6, 2, 1, 1};
        System.out.println(mar.findTwoElement(arr2)); // [1, 5]
    }
}
