import java.util.*;

interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}


class StockMarket implements Stock {
    private List<Observer> observers;
    private String stockName;
    private double stockPrice;

    public StockMarket() {
        observers = new ArrayList<>();
    }

    public void setStockData(String stockName, double stockPrice) {
        this.stockName = stockName;
        this.stockPrice = stockPrice;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, stockPrice);
        }
    }
}

interface Observer {
    void update(String stockName, double stockPrice);
}

class MobileApp implements Observer {
    private String name;

    public MobileApp(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println(name + " MobileApp: " + stockName + " is now $" + stockPrice);
    }
}

class WebApp implements Observer {
    private String name;

    public WebApp(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println(name + " WebApp: " + stockName + " is now Rs." + stockPrice);
    }
}

public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        // Create observers
        Observer mobileApp1 = new MobileApp("App1");
        Observer mobileApp2 = new MobileApp("App2");
        Observer webApp1 = new WebApp("Web1");

        // Register observers
        stockMarket.registerObserver(mobileApp1);
        stockMarket.registerObserver(mobileApp2);
        stockMarket.registerObserver(webApp1);

        Scanner scanner = new Scanner(System.in);
        String stockName;
        double stockPrice;

        while (true) {
            System.out.println("Enter stock name (or 'exit' to quit): ");
            stockName = scanner.nextLine();
            if (stockName.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Enter stock price: ");
            stockPrice = scanner.nextDouble();
            scanner.nextLine(); // consume the newline

            // Set stock data and notify observers
            stockMarket.setStockData(stockName, stockPrice);
        }

        scanner.close();
    }
}


