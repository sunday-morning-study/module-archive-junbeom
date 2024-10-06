package com.junbeom.hexagonalarchitecture.application.port;

import com.junbeom.hexagonalarchitecture.domain.item.Item;

import java.util.List;

public interface LoadItemPort {

    List<Item> loadAllItems();

    Item loadItemById(Long id);
}
