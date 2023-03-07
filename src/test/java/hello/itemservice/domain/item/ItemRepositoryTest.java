package hello.itemservice.domain.item;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {
    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }
    @Test
    void save() {
        //given
        Item item = new Item("itemA", 10000, 10);
        //when
        Item savedItem = itemRepository.save(item);
        //then
        Item findItem = itemRepository.findById(savedItem.getId());
        assertThat(findItem).isEqualTo(savedItem);
        // itemA, 10000, 10 저장 을 선언 하고 repo에 저장 하고 item id를 통해서 조회
    }

    @Test
    void findAll() {
        // given
        Item item1 = new Item("itemC", 6000, 15);
        Item item2 = new Item("itemB", 5000, 10);
        Item savedItem1 = itemRepository.save(item1);
        Item savedItem2 = itemRepository.save(item2);
        // when
        List<Item> result = itemRepository.findAll();
        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(item1, item2);
    }

    @Test
    void updateItem() {
        // given
        Item item1 = new Item("itemA", 10000,10);
        Item savedItem = itemRepository.save(item1);
        Long itemId = savedItem.getId();
        // when
        Item updateParam = new Item("itemB", 20000, 10);
        itemRepository.update(itemId, updateParam);
        // then
        Item findItem = itemRepository.findById(itemId);
        assertThat(updateParam.getItemName()).isEqualTo(findItem.getItemName());
        assertThat(updateParam.getQuantity()).isEqualTo(findItem.getQuantity());
        // item1 에 대한 repo 저장을 하고 , itemid를 통해서 가져오고 update를
    }
}