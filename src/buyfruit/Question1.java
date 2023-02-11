package buyfruit;

import buyfruit.po.FruitPO;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * 1，有一家超市，出售苹果和草莓。其中苹果8元/斤，草莓13元/斤。
 * 现在顾客A在超市购买了若干斤苹果和草莓，需要计算一共多少钱？
 * 请编写函数，对于A购买的水果斤数（水果斤数为大于0的整数），计算并返回所购买商品的总价。
 */
public class Question1 {
    public static void main(String[] args) {
        FruitPO apple = new FruitPO("苹果", 8.99);
        apple.setWeight(33);
        FruitPO strawberry = new FruitPO("草莓", 13.58);
        strawberry.setWeight(77);
        List<FruitPO> list = new ArrayList<>();
        list.add(apple);
        list.add(strawberry);

        // 原始结果输出
        System.out.println(PriceCalculator.calPrice(list, null));
        // 设置小数位数后的输出
        System.out.println(PriceCalculator.calPrice(list, null).setScale(2, RoundingMode.HALF_UP));
    }
}
