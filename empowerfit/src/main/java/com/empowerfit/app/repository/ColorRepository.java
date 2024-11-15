package com.empowerfit.app.repository;
import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.empowerfit.app.model.Color;

public interface ColorRepository extends CrudRepository<Color, Long> {


    List<Color> findByColor(String color); //por nombre
    Color findById(long id); //por color
    Set<Color> findAll(); //todos los colores
}
