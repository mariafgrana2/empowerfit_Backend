package com.empowerfit.app.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.empowerfit.app.model.Color;
import com.empowerfit.app.service.ColorService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/colors")
public class ColorController {

    private final ColorService colorService;

    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @PostMapping
    public ResponseEntity<Color> createColor(@RequestBody Color newColor) {
        Color createdColor = colorService.createColor(newColor);
        return ResponseEntity.status(201).body(createdColor);
    }

    @GetMapping("{id}")
    public ResponseEntity<Color> getColorById(@PathVariable("id") Long id) {
        Color color = colorService.getColorById(id);
        return ResponseEntity.ok(color);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Color> updateColor(@PathVariable("id") long id, @RequestBody Color updatedColor) {
        Color color = colorService.updateColor(updatedColor, id);
        return ResponseEntity.ok(color);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteColor(@PathVariable("id") long id) {
        colorService.deleteColor(id);
        return ResponseEntity.ok("Color con ID " + id + " eliminado con éxito");
    }
}
