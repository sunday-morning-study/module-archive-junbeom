package com.junbeom.hexagonalarchitecture.service;

import com.junbeom.hexagonalarchitecture.application.dto.ItemCreateRequest;
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
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(ItemCreateRequest itemCreateRequest) {
        Book book = new Book();
        book.setName(itemCreateRequest.name());
        book.setPrice(itemCreateRequest.price());
        book.setStockQuantity(itemCreateRequest.stockQuantity());
        book.setAuthor(itemCreateRequest.author());
        book.setIsbn(itemCreateRequest.isbn());
        itemRepository.save(book);
    }

    @Transactional
    public void updateItem(Long itemId, String name, int price, int stockQuantity) {
        Item item = itemRepository.findOne(itemId);
        item.setName(name);
        item.setPrice(price);
        item.setStockQuantity(stockQuantity);
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }

}
