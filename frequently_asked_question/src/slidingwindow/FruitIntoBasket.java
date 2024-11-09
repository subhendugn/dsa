package algorithmic_patterns.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 904. Fruit Into Baskets
// Dynamic window
public class FruitIntoBasket {
//    public int fruitIntoBasket(int[] trees) {
//        Map<Integer, Boolean> basket = new HashMap<>();
////        Set<Integer> basket = new HashSet<>();
//        int max = 0;
//        int start = 0;
//
//        int n = trees.length;
//
//        for(int end=0; end<n; end++){
//            int treeType = trees[end];
//            if(basket.size() < 2 && !basket.containsKey(treeType)){
//                // if basket size if less than 2
//                // and basket does not contain fruit from that tree
//                basket.put(treeType, true);
//                int windowSize = end-start+1; // which is nothing but no of fruits
//
//                max = Math.max(max, windowSize);
//
//            } else if(basket.containsKey(treeType)){
//                // basket size is 2
//                // and basket already having fruit from that tree
//                int windowSize = end-start+1; // which is nothing but no of fruits
//                max = Math.max(max, windowSize);
//            } else {
//                // if basket size is 2 - full
//                // fruit type which we got is different from basket's fruit type
//
//                basket = new HashMap<>(); // creating a new basket
//                basket.put(trees[end-1], true); // adding just previous fruit from current position
//                basket.put(treeType, true); // adding current fruit
//
//                start = end-1; // start will also point to the just previous fruit
//
//                // check any of the previous elements are same as start
//                for(int j=start; j>=0; j--){
//                    if(trees[start] == trees[start-1]) start--;
//                }
//
//            }
//        }
//
//        return max;
//    }

    public int fruitIntoBasket(int[] trees) {
        Map<Integer, Integer> basket = new HashMap<>();
        int n = trees.length;
        int start = 0;
        int max = 0;

        for(int end=0; end<n; end++){
            basket.put(trees[end], basket.getOrDefault(trees[end],0)+1);
            if(basket.size()<=2){
                int windowLen = end-start+1;
                max = Math.max(max, windowLen);
            }
            else if(basket.size() > 2){
                while(start<end && basket.size()>2){
                    basket.put(trees[start], basket.get(trees[start])-1);

                    if(basket.get(trees[start]) == 0) basket.remove(trees[start]);
                    start++;
                }
            }


        }

        return max;
    }

    public static void main(String[] args) {
        FruitIntoBasket obj = new FruitIntoBasket();
        System.out.println(obj.fruitIntoBasket(new int[]{1, 2, 1})); // 3
        System.out.println(obj.fruitIntoBasket(new int[]{0, 1, 2, 2})); // 3
        System.out.println(obj.fruitIntoBasket(new int[]{1, 2, 3, 2, 2})); // 4
        System.out.println(obj.fruitIntoBasket(new int[]{0,1,6,6,4,4,6})); // 5
        System.out.println(obj.fruitIntoBasket(new int[]{3,3,3,1,2,1,1,2,3,3,4})); // 5
        System.out.println(obj.fruitIntoBasket(new int[]{4,1,1,1,3,1,7,5})); // 5
    }
}
