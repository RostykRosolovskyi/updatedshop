package internetshop.dao;

import internetshop.model.Item;

import java.util.List;

public interface ItemDao {
    Item add(Item item);

    Item get(Long id);

    Item update(Item item);

    void delete(Long id);

    void delete(Item item);

    List<Item> getAll();
}
