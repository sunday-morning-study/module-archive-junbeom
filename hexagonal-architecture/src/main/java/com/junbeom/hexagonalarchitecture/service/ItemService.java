package com.junbeom.hexagonalarchitecture.service;

import com.junbeom.hexagonalarchitecture.adapter.out.persistence.ItemPersistenceAdapter;
import com.junbeom.hexagonalarchitecture.application.dto.ItemCreateRequest;
import com.junbeom.hexagonalarchitecture.application.dto.ItemResponse;
import com.junbeom.hexagonalarchitecture.application.dto.ItemUpdateRequest;
import com.junbeom.hexagonalarchitecture.application.in.GetItemUseCase;
import com.junbeom.hexagonalarchitecture.application.in.CreateItemUseCase;
import com.junbeom.hexagonalarchitecture.application.in.UpdateItemUseCase;
import com.junbeom.hexagonalarchitecture.domain.item.Book;
import com.junbeom.hexagonalarchitecture.domain.item.Item;
import com.junbeom.hexagonalarchitecture.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService implements CreateItemUseCase, GetItemUseCase, UpdateItemUseCase {

    private final ItemPersistenceAdapter itemPersistenceAdapter;
    private final ItemRepository itemRepository;

    @Override
    @Transactional
    public void createItem(ItemCreateRequest itemCreateRequest) {
        Book book = new Book();
        book.setName(itemCreateRequest.name());
        book.setPrice(itemCreateRequest.price());
        book.setStockQuantity(itemCreateRequest.stockQuantity());
        book.setAuthor(itemCreateRequest.author());
        book.setIsbn(itemCreateRequest.isbn());
        itemPersistenceAdapter.createItem(book);
    }

    @Override
    public List<Item> findAllItems() {
        return itemPersistenceAdapter.loadAllItems();
    }

    @Override
    public ItemResponse findItemById(Long id) {
        Book item = (Book) itemPersistenceAdapter.loadItemById(id);

        return ItemResponse.builder()
                .id(item.getId())
                .price(item.getPrice())
                .name(item.getName())
                .stockQuantity(item.getStockQuantity())
                .author(item.getAuthor())
                .isbn(item.getIsbn())
                .build();
    }

    @Override
    @Transactional
    public ItemResponse updateItem(Long itemId, ItemUpdateRequest itemUpdateRequest) {
        Book item = (Book) itemPersistenceAdapter.loadItemById(itemId);
        item.setName(itemUpdateRequest.name());
        item.setPrice(itemUpdateRequest.price());
        item.setStockQuantity(itemUpdateRequest.stockQuantity());

        return ItemResponse.builder()
                .id(item.getId())
                .price(item.getPrice())
                .name(item.getName())
                .stockQuantity(item.getStockQuantity())
                .author(item.getAuthor())
                .isbn(item.getIsbn())
                .build();
    }

}
