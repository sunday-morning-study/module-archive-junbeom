package com.junbeom.hexagonalarchitecture.application.in;

import com.junbeom.hexagonalarchitecture.application.dto.ItemUpdateRequest;

public interface UpdateItemUseCase {

    void updateItem(Long itemId, ItemUpdateRequest itemUpdateRequest);
}
