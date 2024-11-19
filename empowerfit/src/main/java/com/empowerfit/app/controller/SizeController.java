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


import com.empowerfit.app.model.Size;
import com.empowerfit.app.service.SizeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/sizes")
public class SizeController {

    private final SizeService sizeService;

    public SizeController(SizeService sizeService) {
        this.sizeService = sizeService;
    }

    @PostMapping
    public ResponseEntity<Size> createSize(@RequestBody Size newSize) {
        Size createdSize = sizeService.createSize(newSize);
        return ResponseEntity.status(201).body(createdSize);
    }

    @GetMapping("{id}")
    public ResponseEntity<Size> getSizeById(@PathVariable("id") Long id) {
        Size size = sizeService.getSizeById(id);
        return ResponseEntity.ok(size);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Size> updateSize(@PathVariable("id") long id, @RequestBody Size updatedSize) {
        Size size = sizeService.updateSize(updatedSize, id);
        return ResponseEntity.ok(size);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSize(@PathVariable("id") long id) {
        sizeService.deleteSize(id);
        return ResponseEntity.ok("Tamaño con ID " + id + " eliminado con éxito");
    }
}
