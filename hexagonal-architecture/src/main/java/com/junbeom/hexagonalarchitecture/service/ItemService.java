package com.junbeom.hexagonalarchitecture.service;

import com.junbeom.hexagonalarchitecture.application.dto.ItemCreateRequest;
import com.junbeom.hexagonalarchitecture.application.dto.ItemResponse;
import com.junbeom.hexagonalarchitecture.application.in.GetItemUseCase;
import com.junbeom.hexagonalarchitecture.application.in.CreateItemUseCase;
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
public class ItemService implements CreateItemUseCase, GetItemUseCase {

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
        itemRepository.save(book);
    }

    @Override
    public List<Item> findAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public ItemResponse findItemById(Long id) {
        Book item = (Book) itemRepository.findOne(id);

        return ItemResponse.builder()
                .id(item.getId())
                .price(item.getPrice())
                .name(item.getName())
                .stockQuantity(item.getStockQuantity())
                .author(item.getAuthor())
                .isbn(item.getIsbn())
                .build();
    }

    @Transactional
    public void updateItem(Long itemId, String name, int price, int stockQuantity) {
        Item item = itemRepository.findOne(itemId);
        item.setName(name);
        item.setPrice(price);
        item.setStockQuantity(stockQuantity);
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }

}
