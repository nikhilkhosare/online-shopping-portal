import java.util.*;
// User Class
class User {
    String username, password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
// Product Class
class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    @Override
    public String toString() {
        return id + ". " + name + " - $" + price;
    }
}
// Cart Class
class Cart {
    Map<Product, Integer> items = new HashMap<>();

    void add(Product product, int quantity) {
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }
    void view() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty!");
            return;
        }
        double total = 0;
        for (var entry : items.entrySet()) {
            Product p = entry.getKey();
            int qty = entry.getValue();
            System.out.println(p.name + " x" + qty + " = $" + (p.price * qty));
            total += p.price * qty;
        }
        System.out.println("Total: $" + total);
    }

    void checkout() {
        if (items.isEmpty()) System.out.println("Cart is empty!");
        else {
            view();
            System.out.println("Order placed! Thank you!");
            items.clear();
        }
    }
}
// ShoppingPortal Class
public class ShoppingPortal {
    List<User> users = new ArrayList<>();
    List<Product> products = List.of(
        new Product(1, "Laptop", 800.00),
        new Product(2, "Smartphone", 500.00),
        new Product(3, "Headphones", 50.00),
        new Product(4, "Keyboard", 30.00)
    );
    Cart cart = new Cart();
    Scanner sc = new Scanner(System.in);
    User currentUser;
    void register() {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        users.add(new User(username, password));
        System.out.println("Registration successful!");
    }
    boolean login() {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                currentUser = user;
                System.out.println("Login successful!");
                return true;
            }
        }
        System.out.println("Invalid credentials!");
        return false;
    }

    void showProducts() {
        System.out.println("Available Products:");
        products.forEach(System.out::println);
    }
    void addToCart() {
        showProducts();
        System.out.print("Enter product ID: ");
        int id = sc.nextInt();
        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();
        sc.nextLine(); // Consume newline
        products.stream()
            .filter(p -> p.id == id)
            .findFirst()
            .ifPresentOrElse(
                p -> {
                    cart.add(p, qty);
                    System.out.println("Added to cart!");
                },
                () -> System.out.println("Product not found!")
            );
    }
    void menu() {
        while (true) {
            System.out.println("\n1. View Products\n2. Add to Cart\n3. View Cart\n4. Checkout\n5. Logout");
            switch (sc.nextInt()) {
                case 1 -> showProducts();
                case 2 -> addToCart();
                case 3 -> cart.view();
                case 4 -> cart.checkout();
                case 5 -> { currentUser = null; return; }
                default -> System.out.println("Invalid option!");
            }
        }
    }
    void start() {
        while (true) {
            System.out.println("\n1. Register\n2. Login\n3. Exit");
            switch (sc.nextInt()) {
                case 1 -> { sc.nextLine(); register(); }
                case 2 -> { sc.nextLine(); if (login()) menu(); }
                case 3 -> { System.out.println("Goodbye!"); return; }
                default -> System.out.println("Invalid option!");
            }
        }
    }
    public static void main(String[] args) {
        new ShoppingPortal().start();
    }
}