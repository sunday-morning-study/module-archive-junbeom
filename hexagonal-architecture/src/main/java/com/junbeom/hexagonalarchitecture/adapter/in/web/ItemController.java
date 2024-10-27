package com.junbeom.hexagonalarchitecture.adapter.in.web;

import com.junbeom.hexagonalarchitecture.adapter.in.web.dto.ItemCreateRequest;
import com.junbeom.hexagonalarchitecture.adapter.in.web.dto.ItemResponse;
import com.junbeom.hexagonalarchitecture.adapter.in.web.dto.ItemUpdateRequest;
import com.junbeom.hexagonalarchitecture.domain.item.Item;
import com.junbeom.hexagonalarchitecture.application.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/items/new")
    public ResponseEntity<Void> create(ItemCreateRequest itemCreateRequest) {
        itemService.createItem(itemCreateRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> list() {
        List<Item> items = itemService.findAllItems();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<ItemResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.findItemById(id));
    }

    @PostMapping("items/{itemId}/edit")
    public ResponseEntity<ItemResponse> updateItem(@PathVariable Long itemId, @RequestParam ItemUpdateRequest itemUpdateRequest) {

        ItemResponse itemResponse = itemService.updateItem(itemId, itemUpdateRequest);

        return ResponseEntity.ok(itemResponse);
    }
}





