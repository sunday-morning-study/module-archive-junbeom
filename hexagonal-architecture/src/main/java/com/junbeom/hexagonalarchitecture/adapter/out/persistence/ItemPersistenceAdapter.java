package com.junbeom.hexagonalarchitecture.adapter.out.persistence;

import com.junbeom.hexagonalarchitecture.application.port.CreateItemPort;
import com.junbeom.hexagonalarchitecture.application.port.LoadItemPort;
import com.junbeom.hexagonalarchitecture.domain.item.Item;
import com.junbeom.hexagonalarchitecture.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ItemPersistenceAdapter implements CreateItemPort, LoadItemPort {

    private final ItemRepository itemRepository;

    @Override
    public void createItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    public List<Item> loadAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item loadItemById(Long id) {
        return itemRepository.findOne(id);
    }
}
