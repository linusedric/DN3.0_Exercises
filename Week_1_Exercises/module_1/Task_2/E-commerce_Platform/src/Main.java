import java.util.*;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public void displayProduct() {
        System.out.println("ID: " + productId);
        System.out.println("Name: "+productName);
        System.out.println("Category: " + category);
    }
}


class LinearSearch {
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }
}

class BinarySearch {
    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].productName.compareToIgnoreCase(targetName);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void sortProducts(Product[] products) {
        Arrays.sort(products, (p1, p2) -> p1.productName.compareToIgnoreCase(p2.productName));
    }
}


public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> productList = new ArrayList<>();

        while (true) {
            System.out.print("Enter the product ID: ");
            int productId = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter the product name: ");
            String productName = scanner.nextLine();

            System.out.print("Enter the product category: ");
            String category = scanner.nextLine();

            productList.add(new Product(productId, productName, category));

            System.out.print("Do you want to add another product? (y/n): ");
            String response = scanner.nextLine();

            if (!response.equalsIgnoreCase("y")) {
                break;
            }
        }

        Product[] products = productList.toArray(new Product[0]);
        BinarySearch.sortProducts(products);

        System.out.println("\nProduct List:");
        for (Product product : products) {
            product.displayProduct();
        }

        System.out.println("\nChoose search method:");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the product name to be searched: ");
        String targetName = scanner.nextLine();

        Product foundProduct = null;

        switch (choice) {
            case 1:
                foundProduct = LinearSearch.linearSearch(products, targetName);
                break;
            case 2:
                foundProduct = BinarySearch.binarySearch(products, targetName);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

        if (foundProduct != null) {
            System.out.println("\nProduct found:");
            foundProduct.displayProduct();
        } else {
            System.out.println("\nProduct not found.");
        }

        scanner.close();
    }
}
