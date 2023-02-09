package buyfruit.preferential;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TotalPricePreferential extends PreferentialPrice {

    // 满减价
    private Double price;

    // 减金额
    private Double preferential;

    public TotalPricePreferential(Double price, Double preferential) {
        this.price = price;
        this.preferential = preferential;
    }

    @Override
    public BigDecimal preferential(BigDecimal totalPrice) {
        if (totalPrice != null && price != null && price > 0
                && preferential != null && preferential > 0) {
            // 优惠扣减金额
            BigDecimal referential = totalPrice.divide(new BigDecimal(price));
            referential = referential.setScale(0, RoundingMode.HALF_DOWN)
                    .multiply(new BigDecimal(preferential));
            return referential;
        }

        return null;
    }
}
