package com.hamri.java_scripting_01.app.controllers;

import com.hamri.java_scripting_01.app.controllers.dto.ItemDTO;
import com.hamri.java_scripting_01.app.dao.ItemsReposirory;
import com.hamri.java_scripting_01.app.entities.Item;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    private ItemsReposirory itemsReposirory;
    private static int generatedId = 0;

    @PostConstruct
    public void init() {
        List<Item> itemList = Arrays.asList(new Item(generatedId++, "test01"), new Item(generatedId++, "test02"));
        itemsReposirory.saveAll(itemList);
    }

    @GetMapping("/test")
    public String testEndpoint() {
        return "ok";
    }


    @GetMapping("/id")
    public ResponseEntity<ItemDTO> getItemById(@RequestParam Integer id) {
        return ResponseEntity.ok(map(itemsReposirory.findById(id).get()));
    }


    static ItemDTO map(Item item) {
        if(item == null) return null;
        return new ItemDTO(item.getId(), item.getName());
    }
}
