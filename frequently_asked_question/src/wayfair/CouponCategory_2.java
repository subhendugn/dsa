package wayfair;

import java.util.*;

public class CouponCategory_2 {
    // round 2:
    // O(1) time to get coupon for a category

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

        // Initialize the maps with the provided lists
        initializeMaps(coupons, categories);

        // Propagate coupons to all descendant categories
        propagateCoupons();


//        // Test cases to check the getCoupon function
        System.out.println(getCoupon("Comforter Sets")); // Comforters Sale
        System.out.println(getCoupon("Bedding")); // Savings on Bedding
        System.out.println(getCoupon("Bathroom Accessories")); // Low price for Bed & Bath
        System.out.println(getCoupon("Soap Dispensers")); // Low price for Bed & Bath
        System.out.println(getCoupon("Toy Organizers")); // null
    }

    // Method to initialize the maps
    private static void initializeMaps(List<String[]> coupons, List<String[]> categories) {
        // Populate categoryCouponMap with category to coupon mappings
        for (String[] coupon : coupons) {
            String categoryName = coupon[0].split(":")[1];
            String couponName = coupon[1].split(":")[1];
            categoryCouponMap.put(categoryName, couponName);
        }

        // Populate categoryParentMap with category to parent category mappings
        for (String[] category : categories) {
            String categoryName = category[0].split(":")[1];
            String categoryParentName = category[1].split(":")[1];
            categoryParentMap.put(categoryName, categoryParentName);
        }
    }

    // Method to propagate coupons to all descendant categories
    private static void propagateCoupons() {
        // Iterate over all categories and propagate coupons
        for (String category : categoryParentMap.keySet()) {
            propagateCouponToDescendants(category);
        }
    }

    // Recursive method to propagate coupons to descendant categories
    private static void propagateCouponToDescendants(String category) {
        // If the category already has a coupon, return
        if (categoryCouponMap.containsKey(category)) {
            return;
        }

        // Get the parent category
        String parent = categoryParentMap.get(category);
        if (parent != null) {
            // Recursively propagate the coupon from the parent category
            propagateCouponToDescendants(parent);
            // If the parent category has a coupon, assign it to the current category
            if (categoryCouponMap.containsKey(parent)) {
                categoryCouponMap.put(category, categoryCouponMap.get(parent));
            }
        }
    }

    // Function to get the coupon for a given category in O(1) time
    private static String getCoupon(String categoryName) {
        // Directly retrieve the coupon from the map
        return categoryCouponMap.get(categoryName);
    }
}
