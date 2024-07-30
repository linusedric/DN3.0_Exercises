import java.util.*;

class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public void displayOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Total Price: " + totalPrice);
    }
}

class BubbleSort {
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}


class QuickSort {
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);1
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Order> orderList = new ArrayList<>();


        while (true) {
            System.out.print("Enter the Order ID: ");
            int orderId = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter the Customer Name: ");
            String customerName = scanner.nextLine();

            System.out.print("Enter the Total Price: ");
            double totalPrice = scanner.nextDouble();

            orderList.add(new Order(orderId, customerName, totalPrice));

            System.out.print("Do you want to add another order? (y/n): ");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("y")) {
                break;
            }
        }

        Order[] orders = orderList.toArray(new Order[0]);

        System.out.println("\nChoose sorting method:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Quick Sort");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                BubbleSort.bubbleSort(orders);
                break;
            case 2:
                QuickSort.quickSort(orders, 0, orders.length - 1);
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Bubble Sort.");
                BubbleSort.bubbleSort(orders);
                break;
        }

        System.out.println("\nSorted Orders:");
        for (Order order : orders) {
            order.displayOrder();
        }

        scanner.close();
    }
}

