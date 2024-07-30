interface PaymentProcessor {
    void processPayment(double amount);
}

class VendorAPayment {
    public void payWithVendorA(double amount) {
        System.out.println("Processing payment of " + amount + " through VendorA");
    }
}

class VendorBPayment {
    public void payWithVendorB(double amount) {
        System.out.println("Processing payment of " + amount + " through VendorB");
    }
}

class VendorCPayment {
    public void payWithVendorC(double amount) {
        System.out.println("Processing payment of " + amount + " through VendorC");
    }
}

class VendorAAdapter implements PaymentProcessor {
    private VendorAPayment vendorAPayment;

    public VendorAAdapter(VendorAPayment vendorAPayment) {
        this.vendorAPayment = vendorAPayment;
    }

    @Override
    public void processPayment(double amount) {
        vendorAPayment.payWithVendorA(amount);
    }
}

class VendorBAdapter implements PaymentProcessor {
    private VendorBPayment vendorBPayment;

    public VendorBAdapter(VendorBPayment vendorBPayment) {
        this.vendorBPayment = vendorBPayment;
    }

    @Override
    public void processPayment(double amount) {
        vendorBPayment.payWithVendorB(amount);
    }
}

class VendorCAdapter implements PaymentProcessor {
    private VendorCPayment vendorCPayment;

    public VendorCAdapter(VendorCPayment vendorCPayment) {
        this.vendorCPayment = vendorCPayment;
    }

    @Override
    public void processPayment(double amount) {
        vendorCPayment.payWithVendorC(amount);
    }
}

public class Main {
    public static void main(String[] args) {

        VendorAPayment vendorAPayment = new VendorAPayment();
        PaymentProcessor vendorAProcessor = new VendorAAdapter(vendorAPayment);
        vendorAProcessor.processPayment(10.0);


        VendorBPayment vendorBPayment = new VendorBPayment();
        PaymentProcessor vendorBProcessor = new VendorBAdapter(vendorBPayment);
        vendorBProcessor.processPayment(10.25);


        VendorCPayment vendorCPayment = new VendorCPayment();
        PaymentProcessor vendorCProcessor = new VendorCAdapter(vendorCPayment);
        vendorCProcessor.processPayment(15.78);
    }
}



