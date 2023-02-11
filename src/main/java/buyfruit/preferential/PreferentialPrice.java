package buyfruit.preferential;

import java.math.BigDecimal;

/**
 * 优惠活动
 * 不同的优惠活动各自实现preferentialMoney方法计算优惠金额后从总金额中扣除
 */
public abstract class PreferentialPrice {
    /**
     * 计算优惠金额
     *
     * @param totalPrice 原金额
     * @return 返回优惠金额
     */
    public abstract BigDecimal preferentialMoney(BigDecimal totalPrice);
}
