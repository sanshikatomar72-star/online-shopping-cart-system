 import java.util.ArrayList;
public class Cart {
    private ArrayList<Product> items = new ArrayList<>();
    public void addItem(Product product) {
        items.add(product);
        System.out.println(product.getName() + " added to cart!");
    }
    public void removeItem(String productName) {
        for (Product p : items) {
            if (p.getName().equalsIgnoreCase(productName)) {
                items.remove(p);
                System.out.println(productName + " removed from cart.");
                return;
            }
        }
        System.out.println("Item not found in cart.");
    }
    public void viewCart() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("\nYour Cart:");
            for (Product p : items) {
                System.out.println("- " + p);
            }
            System.out.println("Total: ₹" + getTotal());
        }
    }
    public double getTotal() {
        double total = 0;
        for (Product p : items) {
            total += p.getPrice();
        }
        return total;
    }
}


