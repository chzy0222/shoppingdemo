package buyfruit.preferential;

import java.math.BigDecimal;

/**
 * 优惠活动
 */
public abstract class PreferentialPrice {
    /**
     * 计算优惠金额
     *
     * @param totalPrice 原金额
     * @return 返回优惠金额
     */
    public abstract BigDecimal preferential(BigDecimal totalPrice);
}
