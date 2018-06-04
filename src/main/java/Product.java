import java.math.BigDecimal;

public class Product {
    private String name;
    private BigDecimal price;
    private String code;

    public Product(String name, BigDecimal price, String code) {
        this.name = name;
        this.price= price;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String  code) {
        this.code = code;
    }
}
