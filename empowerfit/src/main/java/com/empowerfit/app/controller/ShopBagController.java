package com.empowerfit.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.empowerfit.app.model.ShopBag;
import com.empowerfit.app.service.ShopBagService;

@RestController
@RequestMapping("/api/v1/shop-bags")
public class ShopBagController {

    private final ShopBagService shopBagService;

    public ShopBagController(ShopBagService shopBagService) {
        this.shopBagService = shopBagService;
    }

    
    @PostMapping
    public ResponseEntity<ShopBag> createShopBag(@RequestBody ShopBag shopBag) {
        ShopBag createdShopBag = shopBagService.createShopBag(shopBag);
        return ResponseEntity.status(201).body(createdShopBag);
    }

   
    @GetMapping
    public ResponseEntity<List<ShopBag>> getAllShopBags() {
        List<ShopBag> shopBags = shopBagService.getAllShopBags();
        return ResponseEntity.ok(shopBags);
    }

   
    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<ShopBag>> getShopBagsByOrderId(@PathVariable Long orderId) {
        List<ShopBag> shopBags = shopBagService.getShopBagsByOrderId(orderId);
        return ResponseEntity.ok(shopBags);
    }

    
    @GetMapping("/date/{date}")
    public ResponseEntity<List<ShopBag>> getShopBagsByDate(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        List<ShopBag> shopBags = shopBagService.getShopBagsByDate(localDate);
        return ResponseEntity.ok(shopBags);
    }

    @PutMapping("/order/{orderId}")
    public ResponseEntity<Void> updateShopBagsForOrder(
            @PathVariable Long orderId,
            @RequestBody List<ShopBag> shopBags) {
        shopBagService.updateShopBagsForOrder(shopBags, orderId);
        return ResponseEntity.noContent().build();
    }


}
