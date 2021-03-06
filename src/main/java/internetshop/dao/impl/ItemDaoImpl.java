package internetshop.dao.impl;

import internetshop.dao.ItemDao;
import internetshop.dao.Storage;
import internetshop.lib.Dao;
import internetshop.model.Item;

import java.util.List;
import java.util.NoSuchElementException;

@Dao
public class ItemDaoImpl implements ItemDao {
    @Override
    public Item add(Item item) {
        Storage.items.add(item);
        return item;
    }

    @Override
    public Item get(Long id) {
        return Storage.items.stream()
                .filter(element -> element.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Can't find item with id " + id));
    }

    @Override
    public Item update(Item newItem) {
        Item item = get(newItem.getId());
        item.setName(newItem.getName());
        item.setPrice(newItem.getPrice());
        return item;
    }

    @Override
    public void delete(Long id) {
        Storage.items
                .removeIf(item -> item.getId().equals(id));
    }

    @Override
    public List<Item> getAll() {
        return Storage.items;
    }
}
