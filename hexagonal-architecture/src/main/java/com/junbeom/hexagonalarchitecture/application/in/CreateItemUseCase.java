package com.junbeom.hexagonalarchitecture.application.in;

import com.junbeom.hexagonalarchitecture.application.dto.ItemCreateRequest;

public interface CreateItemUseCase {

    void createItem(ItemCreateRequest itemCreateRequest);
}
