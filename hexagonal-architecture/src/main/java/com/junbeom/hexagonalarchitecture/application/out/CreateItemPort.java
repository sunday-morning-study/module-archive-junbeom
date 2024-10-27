package com.junbeom.hexagonalarchitecture.application.out;

import com.junbeom.hexagonalarchitecture.domain.item.Item;

public interface CreateItemPort {

    void createItem(Item item);
}
