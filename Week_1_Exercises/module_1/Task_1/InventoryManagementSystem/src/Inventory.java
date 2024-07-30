import java.util.Scanner;
import java.util.ArrayList;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public void displayProduct() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Product Quantity: " + quantity);
        System.out.println("Product Price: " + price);
    }
}

class Inventory {
    ArrayList<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added: " + product.productName);
    }

    public void updateProduct(int productId, int newQuantity, double newPrice) {
        for (Product product : products) {
            if (product.productId == productId) {
                product.quantity = newQuantity;
                product.price = newPrice;
                System.out.println("Product updated: " + product.productName);
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void deleteProduct(int productId) {
        boolean removed = products.removeIf(product -> product.productId == productId);
        if (removed) {
            System.out.println("Product removed: " + productId);
        } else {
            System.out.println("Product not found");
        }
    }

    public void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("Products are not available in the inventory.");
        } else {
            for (Product product : products) {
                product.displayProduct();
            }
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display All Products");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the product ID: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter the product name: ");
                    String productName = scanner.nextLine();

                    System.out.print("Enter the product quantity: ");
                    int quantity = scanner.nextInt();

                    System.out.print("Enter the product price: ");
                    double price = scanner.nextDouble();

                    Product product = new Product(productId, productName, quantity, price);
                    inventory.addProduct(product);
                    break;

                case 2:
                    System.out.print("Enter the product ID to be updated ");
                    productId = scanner.nextInt();

                    System.out.print("new quantity: ");
                    quantity = scanner.nextInt();

                    System.out.print("new price: ");
                    price = scanner.nextDouble();

                    inventory.updateProduct(productId, quantity, price);
                    break;

                case 3:
                    System.out.print("Enter product ID to be  deleted: ");
                    productId = scanner.nextInt();
                    inventory.deleteProduct(productId);
                    break;

                case 4:
                    System.out.println("\nCurrent inventory: ");
                    inventory.displayAllProducts();
                    break;

                case 5:
                    System.out.println("closing");
                    scanner.close();
                    return;

                default:
                    System.out.println("Choose one of the options above");
            }
        }
    }
}
