package com.empowerfit.app.service.impl;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.empowerfit.app.model.Color;
import com.empowerfit.app.repository.ColorRepository;
import com.empowerfit.app.service.ColorService;


@Service
public class ColorServiceImpl implements ColorService {
	public ColorRepository colorRepository;
	
	public ColorServiceImpl(ColorRepository colorRepository) {
		this.colorRepository = colorRepository;
	}

	@Override
	public Color createColor(Color color) {
	Color newColor = colorRepository.save(color);
		return newColor;
	}

	@Override
	public Color getColorById(Long id) {
		Optional <Color> optionalColor = colorRepository.findById(id);
		if (optionalColor.isEmpty()) {
			throw new IllegalStateException("no existe Color con Id: " + id);
		}
		Color existingColor = optionalColor.get(); 
		return existingColor;
	}
	


	@Override
	public Set<Color> getAllColors() {
	 return Set.copyOf(colorRepository.findAll());
	}

	@Override
	public Color updateColor(Color color, Long id) {
        Color existingColor = getColorById(id);
        if (color.getColor() != null) {
            existingColor.setColor(color.getColor());
        }
        return colorRepository.save(existingColor);
	}

	@Override
	public void deleteColor(Long id) {
        Color existingColor = getColorById(id);
        colorRepository.delete(existingColor);
	}

}
