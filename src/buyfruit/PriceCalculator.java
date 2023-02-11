package buyfruit;

import buyfruit.po.FruitPO;
import buyfruit.preferential.PreferentialPrice;

import java.math.BigDecimal;
import java.util.List;

/**
 * 计算购买商品的总价格
 */
public class PriceCalculator {
    /**
     * 计算购买商品的总价格
     *
     * @param poList       商品条目
     * @param preferentialList 优惠活动
     * @return 计算结果
     */
    protected static BigDecimal calPrice(List<FruitPO> poList, List<PreferentialPrice> preferentialList) {
        if (poList == null || poList.size() == 0) {
            return new BigDecimal(0);
        }

        BigDecimal totalPrice = new BigDecimal(0);
        for (FruitPO po : poList) {
            totalPrice = totalPrice.add(po.getTotalPrice());
        }

        if (preferentialList != null && preferentialList.size() > 0) {
            for(PreferentialPrice preferentialPrice : preferentialList) {
                BigDecimal preferential = preferentialPrice.preferential(totalPrice);
                if(preferential != null){
                    totalPrice = totalPrice.subtract(preferential);
                }
            }
        }

        return totalPrice;
    }
}
