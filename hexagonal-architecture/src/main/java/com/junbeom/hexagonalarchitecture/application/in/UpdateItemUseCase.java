package com.junbeom.hexagonalarchitecture.application.in;

import com.junbeom.hexagonalarchitecture.adapter.in.web.dto.ItemResponse;
import com.junbeom.hexagonalarchitecture.adapter.in.web.dto.ItemUpdateRequest;

public interface UpdateItemUseCase {

    ItemResponse updateItem(Long itemId, ItemUpdateRequest itemUpdateRequest);
}
