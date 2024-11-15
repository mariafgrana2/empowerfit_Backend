package com.empowerfit.app.service;
import java.util.Set;

import com.empowerfit.app.model.Color;

public interface ColorService {

    Color createColor(Color color); //Create-Crear
    Color getColorById(Long id); //Read - get - leer
    Set<Color> getAllColors();//Read - get - leer todos
    Color updateColor(Color color, Long id); //update - actualizar
    void deleteColor(Long id); //delete - eliminar
}