package com.junbeom.hexagonalarchitecture.application.in;

import com.junbeom.hexagonalarchitecture.domain.item.Item;

import java.util.List;

public interface GetItemUseCase {

    List<Item> findAllItems();
}
