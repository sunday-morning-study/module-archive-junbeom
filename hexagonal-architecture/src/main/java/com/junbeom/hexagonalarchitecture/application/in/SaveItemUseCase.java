package com.junbeom.hexagonalarchitecture.application.in;

import com.junbeom.hexagonalarchitecture.application.dto.ItemCreateRequest;

public interface SaveItemUseCase {

    void saveItem(ItemCreateRequest itemCreateRequest);
}
