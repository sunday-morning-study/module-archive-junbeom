package com.junbeom.hexagonalarchitecture.adapter.in.web;

import com.junbeom.hexagonalarchitecture.application.dto.ItemCreateRequest;
import com.junbeom.hexagonalarchitecture.controller.BookForm;
import com.junbeom.hexagonalarchitecture.domain.item.Book;
import com.junbeom.hexagonalarchitecture.domain.item.Item;
import com.junbeom.hexagonalarchitecture.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/items/new")
    public ResponseEntity<Void> create(ItemCreateRequest itemCreateRequest) {
        itemService.saveItem(itemCreateRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> list() {
        List<Item> items = itemService.findAllItems();
        return ResponseEntity.ok(items);
    }

    @GetMapping("items/{itemId}/edit")
    public String updateItemForm(@PathVariable("itemId") Long itemId, Model model) {
        Book item = (Book) itemService.findOne(itemId);

        BookForm form = new BookForm();
        form.setId(item.getId());
        form.setName(item.getName());
        form.setPrice(item.getPrice());
        form.setStockQuantity(item.getStockQuantity());
        form.setAuthor(item.getAuthor());
        form.setIsbn(item.getIsbn());

        model.addAttribute("form", form);
        return "items/updateItemForm";
    }

    @PostMapping("items/{itemId}/edit")
    public String updateItem(@PathVariable Long itemId, @ModelAttribute("form") BookForm form) {

        itemService.updateItem(itemId, form.getName(), form.getPrice(), form.getStockQuantity());

        return "redirect:/items";
    }
}





