import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Receipt {
    List<Product> productList;

    public Receipt() {
        productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public BigDecimal totalReceiptValue() {
        if(productList.isEmpty()) return new BigDecimal("0.0");
        else return countTotalReceiptValue();
    }

    private BigDecimal countTotalReceiptValue() {
        List<BigDecimal> receiptValueList = new ArrayList<>();
        List<BigDecimal> sumReceiptValueList = new ArrayList<>();

        for (Product product : productList) {
            BigDecimal newValueToList = product.getPrice();
            receiptValueList.add(newValueToList);
        }

        int receiptValueListSize = receiptValueList.size();

        if (receiptValueListSize == 1)
            return receiptValueList.get(0);

        else {
            int iterator = 0;
            sumReceiptValueList.add(receiptValueList.get(iterator));
            while (iterator < receiptValueListSize - 1) {
                BigDecimal previousValue = sumReceiptValueList.get(iterator);
                BigDecimal currentValue = receiptValueList.get(iterator + 1);
                BigDecimal newValue = previousValue.add(currentValue);
                sumReceiptValueList.add(newValue);
                iterator++;
            }
            return sumReceiptValueList.get(sumReceiptValueList.size() - 1);
        }
    }


    public String receiptListToString() {
        StringBuilder receiptList = new StringBuilder();
        for (Product product : productList) {
            receiptList
                    .append(product.getName())
                    .append(" ")
                    .append(product.getPrice())
                    .append("\n");
        }
        receiptList.append("\nTotal sum: " + totalReceiptValue());

        return receiptList.toString();
    }
}
