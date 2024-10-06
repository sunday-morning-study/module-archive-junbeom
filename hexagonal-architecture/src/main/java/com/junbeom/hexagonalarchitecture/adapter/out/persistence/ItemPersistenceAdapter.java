package com.junbeom.hexagonalarchitecture.adapter.out.persistence;

import com.junbeom.hexagonalarchitecture.application.port.CreateItemPort;
import com.junbeom.hexagonalarchitecture.domain.item.Item;
import com.junbeom.hexagonalarchitecture.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ItemPersistenceAdapter implements CreateItemPort {

    private final ItemRepository itemRepository;

    @Override
    public void createItem(Item item) {
        itemRepository.save(item);
    }
}
