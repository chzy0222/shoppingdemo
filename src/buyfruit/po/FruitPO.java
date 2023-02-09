package buyfruit.po;

import java.math.BigDecimal;

public class FruitPO {
    // 名称
    private String name;

    // 单价
    private Double price;

    // 重量
    private Integer weight;

    // 总价
    private BigDecimal totalPrice;

    // 折扣
    private Float discount;

    public FruitPO(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price == null ? 0 : price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getWeight() {
        return weight == null ? 0 : weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Float getDiscount() {
        return discount == null ? 0 : discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public BigDecimal getTotalPrice() {
        if (getWeight() <= 0 || getPrice() <= 0) {
            return new BigDecimal(0);
        }
        BigDecimal priceBD = new BigDecimal(getPrice());
        totalPrice = priceBD.multiply(new BigDecimal(getWeight()));

        if (getDiscount() != null && getDiscount() > 0 && getDiscount() <= 10) {
            totalPrice = totalPrice.multiply(new BigDecimal(getDiscount() / 10));
        }
        return totalPrice;
    }
}
