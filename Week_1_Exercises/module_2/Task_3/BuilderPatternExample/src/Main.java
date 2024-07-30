import java.util.*;

class Computer {

    private String CPU;
    private String RAM;
    private String storage;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
    }

    public String getCPU() {
        return CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public String getStorage() {
        return storage;
    }

    public void showSpecs() {
        System.out.println("Computer Specifications:");
        System.out.println("CPU: " + CPU);
        System.out.println("RAM: " + RAM);
        System.out.println("Storage: " + storage);
    }


    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter CPU configuration: ");
        String CPU = scanner.nextLine();

        System.out.println("Enter RAM configuration: ");
        String RAM = scanner.nextLine();

        System.out.println("Enter Storage configuration: ");
        String storage = scanner.nextLine();

        Computer computer = new Computer.Builder()
                .setCPU(CPU)
                .setRAM(RAM)
                .setStorage(storage)
                .build();

        computer.showSpecs();

        scanner.close();
    }
}

