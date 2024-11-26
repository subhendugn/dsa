package wayfair;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

// Round 3
// 1. create a function to get the coupon for a category in O(1) time
// 2. If category has a coupon the coupon with most recent DateModified should be returned
// 3. If a coupon's DateModified is in the future, it should not be returned
// 4. category structure is hierarchical. Categories without coupons inherit their parent's coupons

public class CouponCategory_3 {
    // Map to store coupons for each category
    private static final Map<String, List<Coupon>> categoryCouponMap = new HashMap<>();
    // Map to store parent category for each category
    private static final Map<String, String> categoryParentMap = new HashMap<>();
    // Date format for parsing DateModified
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) throws ParseException {
        // List of coupons with their associated categories
        List<String[]> coupons = List.of(
                new String[]{"CategoryName:Comforter Sets", "CouponName:Comforters Sale", "DateModified:2020-01-01", "Discount:10%"},
                new String[]{"CategoryName:Comforter Sets", "CouponName:Cozy Comforter Coupon", "DateModified:2020-01-01", "Discount:$15"},
                new String[]{"CategoryName:Bedding", "CouponName:Best Bedding Bargains", "DateModified:2019-01-01", "Discount:35%"},
                new String[]{"CategoryName:Bedding", "CouponName:Savings on Bedding", "DateModified:2019-01-01", "Discount:25%"},
                new String[]{"CategoryName:Bed & Bath", "CouponName:Low price for Bed & Bath", "DateModified:2018-01-01", "Discount:50%"},
                new String[]{"CategoryName:Bed & Bath", "CouponName:Bed & Bath extravaganza", "DateModified:2019-01-01", "Discount:75%"}
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

        List<String[]> products = List.of(
                new String[]{"ProductName:Cozy Comforter Sets","Price:100.00", "CategoryName:Comforter Sets"},
                new String[]{"ProductName:All-in-one Bedding Set", "Price:50.00", "CategoryName:Bedding"},
                new String[]{"ProductName:Infinite Soap Dispenser", "Price:500.00" ,"CategoryName:Bathroom Accessories"},
                new String[]{"ProductName:Rainbow Toy Box","Price:257.00", "CategoryName:Baby And Kids"}
        );

        // Initialize the maps with the provided lists
        initializeMaps(coupons, categories);
        // Propagate coupons to all descendant categories
        propagateCoupons();

        // Test cases to check the getCoupon function
        System.out.println(getCoupon("Bed & Bath")); // Bed & Bath extravaganza
        System.out.println(getCoupon("Bedding")); // Savings on Bedding or Best Bedding Bargains
        System.out.println(getCoupon("Bathroom Accessories")); // Bed & Bath extravaganza
        System.out.println(getCoupon("Comforter Sets")); // Comforters Sale or Cozy Comforter Coupon
    }

    // Method to initialize the maps
    private static void initializeMaps(List<String[]> coupons, List<String[]> categories) throws ParseException {
        for (String[] coupon : coupons) {
            String categoryName = coupon[0].split(":")[1];
            String couponName = coupon[1].split(":")[1];
            Date dateModified = dateFormat.parse(coupon[2].split(":")[1]);
            String discount = coupon[3].split(":")[1];

            // Add coupon to the list of coupons for the category
            categoryCouponMap.computeIfAbsent(categoryName, k -> new ArrayList<>())
                    .add(new Coupon(couponName, dateModified, discount));
        }

        for (String[] category : categories) {
            String categoryName = category[0].split(":")[1];
            String categoryParentName = category[1].split(":")[1];
            // Add parent category mapping
            categoryParentMap.put(categoryName, categoryParentName.equals("None") ? null : categoryParentName);
        }
    }

    // Method to propagate coupons to all descendant categories
    private static void propagateCoupons() {
        for (String category : categoryParentMap.keySet()) {
            propagateCouponToDescendants(category);
        }
    }

    // Recursive method to propagate coupons to descendant categories
    private static void propagateCouponToDescendants(String category) {
        if (categoryCouponMap.containsKey(category)) {
            return;
        }

        String parent = categoryParentMap.get(category);
        if (parent != null) {
            propagateCouponToDescendants(parent);
            if (categoryCouponMap.containsKey(parent)) {
                // Inherit coupons from parent category
                categoryCouponMap.put(category, new ArrayList<>(categoryCouponMap.get(parent)));
            }
        }
    }

    // Function to get the coupon for a given category in O(1) time
    private static String getCoupon(String categoryName) {
        List<Coupon> coupons = categoryCouponMap.get(categoryName);
        if (coupons == null) {
            return null;
        }

        Date now = new Date();
        Coupon bestCoupon = null;
        for (Coupon coupon : coupons) {
            if (coupon.dateModified.after(now)) {
                continue;
            }
            if (bestCoupon == null || coupon.dateModified.after(bestCoupon.dateModified)) {
                bestCoupon = coupon;
            }
        }
        return bestCoupon != null ? bestCoupon.couponName : null;
    }

    // Coupon class to store coupon details
    static class Coupon {
        String couponName;
        Date dateModified;
        String discount;

        Coupon(String couponName, Date dateModified, String discount) {
            this.couponName = couponName;
            this.dateModified = dateModified;
            this.discount = discount;
        }
    }
}