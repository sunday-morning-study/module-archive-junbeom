package com.junbeom.hexagonalarchitecture.application.in;

import com.junbeom.hexagonalarchitecture.application.dto.ItemResponse;
import com.junbeom.hexagonalarchitecture.application.dto.ItemUpdateRequest;

public interface UpdateItemUseCase {

    ItemResponse updateItem(Long itemId, ItemUpdateRequest itemUpdateRequest);
}
