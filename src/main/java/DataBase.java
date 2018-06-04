import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class DataBase {
    Set<Product> products;

    public DataBase() {
        products = new HashSet<>();
        products.add(new Product("phone", new BigDecimal("100.11"), "11"));
        products.add(new Product("tv", new BigDecimal("500.22").setScale(2), "12"));
    }

    public Set<Product> getProducts() {
        return products;
    }

}
