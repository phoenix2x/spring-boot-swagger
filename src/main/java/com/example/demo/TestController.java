package com.example.demo;

import com.example.demo.services.ItemSummaryApiWrapper;
import com.example.demo.swagger.ebay.model.ItemSummary;
import com.example.demo.swagger.petstore.api.PetApi;
import com.example.demo.swagger.petstore.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 */

@RestController
public class TestController {

    @Autowired
   	private PetApi petApi;

    @Autowired
    private ItemSummaryApiWrapper itemSummaryApiWrapper;

    @GetMapping("/find-pets")
    public List<Pet> findPets() {
        return petApi.findPetsByStatus(Collections.singletonList("sold"));
    }

    @GetMapping("/search-items")
    public List<ItemSummary> searchItems() {
        return itemSummaryApiWrapper.search("drone");
    }
}
