package hello.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data // Data를 쓸거면 Data에 포함된 내용을 다 알고 써야함
// 어지간하면 Getter, Setter를 쓰는 것을 권장
public class Item {

    private Long id;
    private String itemName;
    private Integer price; // Integer로 쓴 이유 = null 표현을 위해서
    private Integer quantity;

    public Item() {

    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
