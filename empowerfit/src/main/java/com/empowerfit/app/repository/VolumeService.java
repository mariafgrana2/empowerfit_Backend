package com.empowerfit.app.repository;

import com.empowerfit.app.model.Volume;

import java.util.List;
import java.util.Optional;

public interface VolumeService {
    // Crea un nuevo volumen.
    Volume createVolume(Volume volume);
    
    // Obtiene un volumen específico por su ID.
    Optional<Volume> getVolumeById(Long id);

    // Devuelve todos los volúmenes.
    List<Volume> getAllVolumes();

    // Busca volúmenes específicos por su peso en kg.
    List<Volume> getVolumesByKg(Double kg);

    // Actualiza un volumen existente.
    Volume updateVolume(Volume volume, Long id);

    // Elimina un volumen por su ID.
    void deleteVolume(Long id);
}