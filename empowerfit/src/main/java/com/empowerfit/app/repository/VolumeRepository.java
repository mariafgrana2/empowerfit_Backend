package com.empowerfit.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.empowerfit.app.model.Volume;

public interface VolumeRepository extends CrudRepository<Volume, Long> {

    // Busca todos los volúmenes que coincidan con un valor específico en kg
    List<Volume> findByKg(Double kg);

    // Busca un volumen específico por ID
    Optional<Volume> findById(Long id);

    // Devuelve todos los volúmenes
    List<Volume> findAll();

    // Devuelve todos los volúmenes mayores a un valor específico en kg
    List<Volume> findByKgGreaterThan(Double kg);

    // Devuelve todos los volúmenes menores o iguales a un valor específico en kg
    List<Volume> findByKgLessThanEqual(Double kg);
}

