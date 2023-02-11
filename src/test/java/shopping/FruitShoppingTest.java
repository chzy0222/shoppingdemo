package shopping;


import buyfruit.PriceCalculator;
import buyfruit.po.FruitPO;
import buyfruit.preferential.PreferentialPrice;
import buyfruit.preferential.TotalPricePreferential;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FruitShoppingTest {

    /**
     * 1，有一家超市，出售苹果和草莓。其中苹果8元/斤，草莓13元/斤。
     * 现在顾客A在超市购买了若干斤苹果和草莓，需要计算一共多少钱？
     * 请编写函数，对于A购买的水果斤数（水果斤数为大于0的整数），计算并返回所购买商品的总价。
     */
    @Test
    public void testQuestion1() {
        FruitPO apple = new FruitPO("苹果", 8.00);
        apple.setWeight(33);
        FruitPO strawberry = new FruitPO("草莓", 13.00);
        strawberry.setWeight(77);
        List<FruitPO> list = new ArrayList<>();
        list.add(apple);
        list.add(strawberry);

        // 原始结果
        BigDecimal result = PriceCalculator.calPrice(list, null);

        // 设置小数位数后的输出
        System.out.println(result.setScale(2, RoundingMode.HALF_UP));

        Assert.assertNotNull(result);
    }

    /**
     * 2，超市增加了一种水果芒果，其定价为20元/斤。
     * 现在顾客B在超市购买了若干斤苹果、草莓和芒果，需计算一共需要多少钱？
     * 请编写函数，对于B购买的水果斤数(水果斤数大于等于0的整数)，计算并返回所购买商品的总价
     */
    @Test
    public void testQuestion2() {
        FruitPO apple = new FruitPO("苹果", 8.00);
        apple.setWeight(33);
        FruitPO strawberry = new FruitPO("草莓", 13.00);
        strawberry.setWeight(77);
        FruitPO mango = new FruitPO("芒果", 20.00);
        mango.setWeight(11);

        List<FruitPO> list = new ArrayList<>();
        list.add(apple);
        list.add(strawberry);
        list.add(mango);

        // 原始结果输出
        BigDecimal result = PriceCalculator.calPrice(list, null);
        // 设置小数位数后的输出
        System.out.println(result.setScale(2, RoundingMode.HALF_UP));

        Assert.assertNotNull(result);
    }

    /**
     * 3，超市做促销活动，草莓限时打8折.
     * 现在顾客C在超市购买了若干斤苹果、草莓和芒果，需计算一共需要多少钱？
     * 请编写函数，对于B购买的水果斤数(水果斤数大于等于0的整数)，计算并返回所购买商品的总价
     */
    @Test
    public void testQuestion3() {
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
        BigDecimal result = PriceCalculator.calPrice(list, null);
        // 设置小数位数后的输出
        System.out.println(result.setScale(2, RoundingMode.HALF_UP));

        Assert.assertNotNull(result);
    }

    /**
     * 4，促销活动效果明显，超市继续加大促销力度，购物满100减10块。
     * 现在顾客D在超市购买了若干斤苹果、草莓和芒果，需计算一共需要多少钱？
     * 请编写函数，对于C购买的水果斤数(水果斤数大于等于0的整数)，计算并返回所购买商品的总价
     */
    @Test
    public void testQuestion4() {
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

        // 优惠策略，满100减10
        PreferentialPrice preferential = new TotalPricePreferential(100.00, 10.00);

        // 原始结果输出
        BigDecimal result = PriceCalculator.calPrice(list, Arrays.asList(preferential));
        // 设置小数位数后的输出
        System.out.println(result.setScale(2, RoundingMode.HALF_UP));

        Assert.assertNotNull(result);
    }
}
