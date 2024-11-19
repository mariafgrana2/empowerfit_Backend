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


import com.empowerfit.app.model.Volume;
import com.empowerfit.app.service.VolumeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/volumes")
public class VolumeController {

    private final VolumeService volumeService;

    public VolumeController(VolumeService volumeService) {
        this.volumeService = volumeService;
    }

    @PostMapping
    public ResponseEntity<Volume> createVolume(@RequestBody Volume newVolume) {
        Volume createdVolume = volumeService.createVolume(newVolume);
        return ResponseEntity.status(201).body(createdVolume);
    }

    @GetMapping("{id}")
    public ResponseEntity<Volume> getVolumeById(@PathVariable("id") Long id) {
        Volume volume = volumeService.getVolumeById(id);
        return ResponseEntity.ok(volume);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Volume> updateVolume(@PathVariable("id") long id, @RequestBody Volume updatedVolume) {
        Volume volume = volumeService.updateVolume(updatedVolume, id);
        return ResponseEntity.ok(volume);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteVolume(@PathVariable("id") long id) {
        volumeService.deleteVolume(id);
        return ResponseEntity.ok("Volumen con ID " + id + " eliminado con éxito");
    }
}
