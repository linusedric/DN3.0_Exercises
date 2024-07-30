import java.util.*;

interface Image {
    void display();
}

class RealImage implements Image {
    private String imagePath;

    public RealImage(String imagePath) {
        this.imagePath = imagePath;
        loadImageFromServer();
    }

    private void loadImageFromServer() {
        System.out.println("Loading image from server: " + imagePath);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + imagePath);
    }
}

class ProxyImage implements Image {
    private String imagePath;
    private RealImage realImage;

    public ProxyImage(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(imagePath);
        }
        realImage.display();
    }
}

public class Main {
    public static void main(String[] args) {

        Image image1 = new ProxyImage("test_image_1.jpg");
        Image image2 = new ProxyImage("test_image_2.jpg");

        System.out.println("Displaying image1 first time:");
        image1.display();

        System.out.println("\nDisplaying image1 second time:");
        image1.display();

        System.out.println("\nDisplaying image2 first time:");
        image2.display();
    }
}


