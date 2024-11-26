package wayfair;

import java.util.*;

public class CouponCategory_1 {
    // round 1:
    // 1. create a function that when passes a Category name (as string) will return Coupon name (as string)
    // 2. Category structure is hierarchical. Categories without coupons inherit their parent's coupons
    // 3. No coupon should be return if there are no coupons in the Category's hierarchy
    // 4. If a Category has a coupon it should not move up the hierarchy to find its parent's Category ( or the parent's coupon)
    // 5. Beware if the following edge cases:
    //    - bathroom Accessories should receive the coupon for Bed & Bath because there are no coupon for Bathroom Accessories
    // Assumption: Product can only be associated to one category

    private static final Map<String, String> categoryCouponMap = new HashMap<>();
    private static final Map<String, String> categoryParentMap = new HashMap<>();

    public static void main(String[] args) throws java.text.ParseException {
        // List of coupons with their associated categories
        List<String[]> coupons = List.of(
                new String[]{"CategoryName:Comforter Sets", "CouponName:Comforters Sale"},
                new String[]{"CategoryName:Bedding", "CouponName:Savings on Bedding"},
                new String[]{"CategoryName:Bed & Bath", "CouponName:Low price for Bed & Bath"}
        );

        // List of categories with their parent categories
        List<String[]> categories = List.of(
                new String[]{"CategoryName:Comforter Sets", "CategoryParentName:Bedding"},
                new String[]{"CategoryName:Bedding", "CategoryParentName:Bed & Bath"},
                new String[]{"CategoryName:Bed & Bath", "CategoryParentName:None"},
                new String[]{"CategoryName:Soap Dispensers", "CategoryParentName:Bathroom Accessories"},
                new String[]{"CategoryName:Bathroom Accessories", "CategoryParentName:Bed & Bath"},
                new String[]{"CategoryName:Toy Organizers", "CategoryParentName:Baby And Kids"},
                new String[]{"CategoryName:Baby And Kids", "CategoryParentName:None"}
        );

        initializeMaps(coupons, categories);

        // Test cases to check the getCoupon function
        System.out.println(getCoupon("Comforter Sets")); // Comforters Sale
        System.out.println(getCoupon("Bedding")); // Savings on Bedding
        System.out.println(getCoupon("Bathroom Accessories")); // Low price for Bed & Bath
        System.out.println(getCoupon("Soap Dispensers")); // Low price for Bed & Bath
        System.out.println(getCoupon("Toy Organizers")); // null
    }

    // Method to initialize the maps
    private static void initializeMaps(List<String[]> coupons, List<String[]> categories) {
        // Map to store category to coupon mappings
        // first element of the array is the category name and the second element is the coupon name
        for (String[] coupon : coupons) {
            String categoryName = coupon[0].split(":")[1];
            String couponName = coupon[1].split(":")[1];
            categoryCouponMap.put(categoryName, couponName);
        }

        System.out.println(categoryCouponMap);

        // Map to store category to parent category mappings
        // first element of the array is the category name and the second element is the parent category name
        for (String[] category : categories) {
            String categoryName = category[0].split(":")[1];
            String categoryParentName = category[1].split(":")[1];
            categoryParentMap.put(categoryName, categoryParentName);
        }

        System.out.println(categoryParentMap);

        /*
         Method The initializeMaps() method initializes two maps (categoryCouponMap and categoryParentMap) using lists of categories and coupons.
         The first loop processes the coupons list and adds entries to categoryCouponMap.
         The time complexity of this loop is 𝑂 ( 𝑐 ) O(c), where 𝑐 c is the number of coupons.
         The second loop processes the categories list and adds entries to categoryParentMap. The time complexity of this loop is 𝑂 ( 𝑘 ) , where 𝑘  is the number of categories.
         Since both loops are sequential, the overall time complexity of initializeMaps() is: 𝑂 ( 𝑐 + 𝑘 ) O(c+k)

         */
    }

    // Function to get the coupon for a given category, considering the hierarchical structure
    private static String getCoupon(String categoryName) {
        Set<String> visited = new HashSet<>();
        while (categoryCouponMap.get(categoryName) == null) {
            if (categoryParentMap.get(categoryName) == null) {
                return null; // No parent category, return null
            }
            categoryName = categoryParentMap.get(categoryName); // Move to parent category
            if (visited.contains(categoryName)) {
                return null; // Avoid infinite loops
            }
            visited.add(categoryName);
        }
        return categoryCouponMap.get(categoryName); // Return the coupon if found

        /*
        The getCoupon() method attempts to find a coupon for a given category by checking the categoryCouponMap.
        If no coupon is found, it moves up the hierarchy by checking parent categories using the categoryParentMap.

        In the worst case, the method will traverse up the entire hierarchy of categories, which could involve checking each category’s parent.

        For each category, it checks the coupon in the categoryCouponMap, which takes 𝑂 ( 1 ) O(1) time.

        The while loop continues moving up the hierarchy until a coupon is found or no more parents exist.

         If there are 𝑝 p categories in the hierarchy, the worst-case time complexity for the getCoupon() function is 𝑂 ( 𝑝 ) O(p),
         where 𝑝 p is the depth of the category hierarchy.
         */
    }
}