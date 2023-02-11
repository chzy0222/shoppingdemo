package buyfruit;

import buyfruit.po.FruitPO;
import buyfruit.preferential.PreferentialPrice;
import buyfruit.preferential.TotalPricePreferential;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 4，促销活动效果明显，超市继续加大促销力度，购物满100减10块。
 * 现在顾客D在超市购买了若干斤苹果、草莓和芒果，需计算一共需要多少钱？
 * 请编写函数，对于C购买的水果斤数(水果斤数大于等于0的整数)，计算并返回所购买商品的总价
 */
public class Question4 {
    public static void main(String[] args) {
        FruitPO apple = new FruitPO("苹果", 8.00);
        apple.setWeight(10);
        FruitPO strawberry = new FruitPO("草莓", 13.00);
        strawberry.setWeight(15);
        strawberry.setDiscount(8f);
        FruitPO mango = new FruitPO("芒果", 20.00);
        mango.setWeight(20);

        List<FruitPO> list = new ArrayList<>();
        list.add(apple);
        list.add(strawberry);
        list.add(mango);

        PreferentialPrice preferential = new TotalPricePreferential(100.00, 10.00);

        // 原始结果输出
        System.out.println(PriceCalculator.calPrice(list, Arrays.asList(preferential)));
        // 设置小数位数后的输出
        System.out.println(PriceCalculator.calPrice(list, Arrays.asList(preferential))
                .setScale(2, RoundingMode.HALF_UP));
    }
}
