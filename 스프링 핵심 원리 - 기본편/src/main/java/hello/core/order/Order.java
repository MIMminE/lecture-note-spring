package hello.core.order;

public class Order {
    private final Long memberId;
    private final String itemNmae;
    private final int itemPrice;
    private final int discountPrice;

    public Order(Long memberId, String itemNmae, int itemPrice, int discountPrice) {
        this.memberId = memberId;
        this.itemNmae = itemNmae;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }

    public int calculaterPrice(){
        return itemPrice - discountPrice;
    }

    public Long getMemberId() {
        return memberId;
    }

    public String getItemNmae() {
        return itemNmae;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itemNmae='" + itemNmae + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
