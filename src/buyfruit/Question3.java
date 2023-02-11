package buyfruit;

import buyfruit.po.FruitPO;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * 3，超市做促销活动，草莓限时打8折.
 * 现在顾客C在超市购买了若干斤苹果、草莓和芒果，需计算一共需要多少钱？
 * 请编写函数，对于B购买的水果斤数(水果斤数大于等于0的整数)，计算并返回所购买商品的总价
 */
public class Question3 {
    public static void main(String[] args) {
        FruitPO apple = new FruitPO("苹果", 8.00);
        apple.setWeight(null);
        FruitPO strawberry = new FruitPO("草莓", 13.00);
        strawberry.setWeight(100);
        strawberry.setDiscount(8f);
        FruitPO mango = new FruitPO("芒果", 20.00);
        mango.setWeight(null);

        List<FruitPO> list = new ArrayList<>();
        list.add(apple);
        list.add(strawberry);
        list.add(mango);

        // 原始结果输出
        System.out.println(PriceCalculator.calPrice(list, null));
        // 设置小数位数后的输出
        System.out.println(PriceCalculator.calPrice(list, null)
                .setScale(2, RoundingMode.HALF_UP));
    }
}