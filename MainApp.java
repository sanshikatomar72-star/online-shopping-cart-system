import java.util.*;
public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cart cart = new Cart();
        int choice;

        do {
            System.out.println("\n===== ONLINE SHOPPING CART =====");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    showCategories(sc, cart);
                    break;

                case 2:
                    System.out.print("Enter item name to remove: ");
                    String name = sc.nextLine();
                    cart.removeItem(name);
                    break;

                case 3:
                    cart.viewCart();
                    break;

                case 4:
                    System.out.println("Final Total: ₹" + cart.getTotal());
                    System.out.println("Thank you for shopping!");
                    choice = 5; 
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice, try again!");
            }
        } while (choice != 5);

        sc.close();
    }

    static void showCategories(Scanner sc, Cart cart) {
        System.out.println("\nSelect a Category:");
        System.out.println("1. Electronics");
        System.out.println("2. Clothing");
        System.out.println("3. Groceries");
        System.out.print("Enter choice: ");
        int cat = sc.nextInt();
        sc.nextLine();

        Product[] products;

        switch (cat) {
            case 1:
                products = new Product[]{
                    new Product("Headphones", 999),
                    new Product("Keyboard", 799),
                    new Product("Smartwatch", 1499)
                };
                break;
            case 2:
                products = new Product[]{
                    new Product("T-Shirt", 499),
                    new Product("Jeans", 899),
                    new Product("Jacket", 1499)
                };
                break;
            case 3:
                products = new Product[]{
                    new Product("Rice 1kg", 70),
                    new Product("Milk 1L", 60),
                    new Product("Bread", 45)
                };
                break;
            default:
                System.out.println("Invalid category!");
                return;
        }

        System.out.println("\nAvailable Products:");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i]);
        }

        System.out.print("Select product number to add: ");
        int p = sc.nextInt();
        if (p >= 1 && p <= products.length) {
            cart.addItem(products[p - 1]);
        } else {
            System.out.println("Invalid selection!");
        }
    }
}
 

