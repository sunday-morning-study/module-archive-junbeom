package com.junbeom.hexagonalarchitecture.application.in;

import com.junbeom.hexagonalarchitecture.adapter.in.web.dto.ItemCreateRequest;

public interface CreateItemUseCase {

    void createItem(ItemCreateRequest itemCreateRequest);
}
