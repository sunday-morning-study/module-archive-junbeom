package com.junbeom.hexagonalarchitecture.application.port;

import com.junbeom.hexagonalarchitecture.domain.item.Item;

public interface CreateItemPort {

    void createItem(Item item);
}
