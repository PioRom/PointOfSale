import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyTest {

    Purchase purchase;

    @BeforeEach
    void init() {
        purchase = new Purchase();
    }

    @Test
    void purchaseTest() {
        purchase.scanProduct("11");
        purchase.scanProduct("11");
        purchase.scanProduct("12");
        purchase.exit();
        assertEquals(new BigDecimal("700.44"), purchase.totalReceiptValue());
    }

    @Test
    void invalidCode() {
        purchase.scanProduct("11");
        purchase.scanProduct("22");
        purchase.scanProduct("");
        purchase.exit();
        assertEquals(new BigDecimal("100.11"), purchase.totalReceiptValue());
    }

    @Test
    void onlyExit(){
        purchase.exit();
    }

}