import java.math.BigDecimal;
import java.util.Set;

public class Purchase implements ICashRegister, IDisplay, IPrinter {

    private Set<Product> products;
    private Receipt receipt;

    public void scanProduct(String scanCode) {
        infoCashRegister();
        System.out.println("Input code: " + scanCode + "\n");
        verifyCode(scanCode);
    }

    public void exit() {
        infoCashRegister();
        printTotalSum();
        printReceipt();
    }

    public void printProduct(Product product) {
        infoDisplay();
        System.out.println("Name: " + product.getName() + ", price: " + product.getPrice() + "\n");
    }

    public void printProductNotFound() {
        infoDisplay();
        System.out.println("Product not found\n");
    }

    public void printInvalidBarCode() {
        infoDisplay();
        System.out.println("Invalid bar-code\n");
    }

    public void printTotalSum() {
        infoDisplay();
        System.out.println("Total value: " + receipt.totalReceiptValue() + "\n");
    }

    public void printReceipt() {
        infoPrinter();
        System.out.println(receipt.receiptListToString());
    }

    private void verifyCode(String scanCode) {
        if (scanCode.isEmpty()) printInvalidBarCode();
        else findProductInDB(scanCode);
    }

    private void findProductInDB(String scanCode) {
        boolean availableProduct = false;
        for (Product product : products) {
            if (scanCode.equals(product.getCode())) {
                printProduct(product);
                receipt.addProduct(product);
                availableProduct = true;
            }
            if (availableProduct) break;
        }
        if (!availableProduct) printProductNotFound();
    }


    public Purchase() {
        products = new DataBase().getProducts();
        receipt = new Receipt();
    }

    public BigDecimal totalReceiptValue() {
        return receipt.totalReceiptValue();
    }

    private void infoCashRegister() {
        System.out.println("Device: Cash Register");
    }

    private void infoPrinter() {
        System.out.println("Device: Printer");
    }

    private void infoDisplay() {
        System.out.println("Device: Display");
    }

}
