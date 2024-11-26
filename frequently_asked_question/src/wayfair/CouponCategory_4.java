package wayfair;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

// Round 4
// Function to take a string representing the Product name
// Function returns the discounted price of the product


public class CouponCategory_4 {
    // Map to store coupons for each category
    private static final Map<String, List<Coupon>> categoryCouponMap = new HashMap<>();
    // Map to store parent category for each category
    private static final Map<String, String> categoryParentMap = new HashMap<>();
    // Map to store products with their details
    private static final Map<String, Product> productMap = new HashMap<>();
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

        // List of products with their details
        List<String[]> products = List.of(
                new String[]{"ProductName:Cozy Comforter Sets", "Price:100.00", "CategoryName:Comforter Sets"},
                new String[]{"ProductName:All-in-one Bedding Set", "Price:50.00", "CategoryName:Bedding"},
                new String[]{"ProductName:Infinite Soap Dispenser", "Price:500.00", "CategoryName:Bathroom Accessories"},
                new String[]{"ProductName:Rainbow Toy Box", "Price:257.00", "CategoryName:Baby And Kids"}
        );

        // Initialize the maps with the provided lists
        initializeMaps(coupons, categories, products);
        // Propagate coupons to all descendant categories
        propagateCoupons();

        // Test cases to check the getDiscountedPrice function
        System.out.println(getDiscountedPrice("Cozy Comforter Sets")); // 90.0 0r 85.0
        System.out.println(getDiscountedPrice("All-in-one Bedding Set")); // 32.5 or 37.5
        System.out.println(getDiscountedPrice("Infinite Soap Dispenser")); // 125.0
        System.out.println(getDiscountedPrice("Rainbow Toy Box")); // 257.0
    }

    // Method to initialize the maps
    private static void initializeMaps(List<String[]> coupons, List<String[]> categories, List<String[]> products) throws ParseException {
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

        for (String[] product : products) {
            String productName = product[0].split(":")[1];
            double price = Double.parseDouble(product[1].split(":")[1]);
            String categoryName = product[2].split(":")[1];
            // Add product to the product map
            productMap.put(productName, new Product(productName, price, categoryName));
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

    // Function to get the discounted price of a product
    private static double getDiscountedPrice(String productName) {
        Product product = productMap.get(productName);
        if (product == null) {
            return -1; // Product not found
        }

        String categoryName = product.categoryName;
        String couponName = getCoupon(categoryName);
        if (couponName == null) {
            return product.price; // No discount available
        }

        Coupon coupon = categoryCouponMap.get(categoryName).stream()
                .filter(c -> c.couponName.equals(couponName))
                .findFirst()
                .orElse(null);

        if (coupon == null) {
            return product.price; // No valid coupon found
        }

        if (coupon.discount.endsWith("%")) {
            double discountPercentage = Double.parseDouble(coupon.discount.replace("%", ""));
            return product.price * (1 - discountPercentage / 100);
        } else if (coupon.discount.startsWith("$")) {
            double discountAmount = Double.parseDouble(coupon.discount.replace("$", ""));
            return product.price - discountAmount;
        }

        return product.price; // No valid discount format
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

    // Product class to store product details
    static class Product {
        String productName;
        double price;
        String categoryName;

        Product(String productName, double price, String categoryName) {
            this.productName = productName;
            this.price = price;
            this.categoryName = categoryName;
        }
    }
}