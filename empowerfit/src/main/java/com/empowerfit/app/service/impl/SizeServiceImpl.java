package com.empowerfit.app.service.impl;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.empowerfit.app.model.Size;

import com.empowerfit.app.repository.SizeRepository;
import com.empowerfit.app.service.SizeService;

@Service
public class SizeServiceImpl implements SizeService {
	public SizeRepository sizeRepository;

	public SizeServiceImpl(SizeRepository sizeRepository) {
		super();
		this.sizeRepository = sizeRepository;
	}

	@Override
	public Size createSize(Size size) {
		Size newSize = sizeRepository.save(size);
		return newSize;
	}

	@Override
	public Size getSizeById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Size> getAllSizes() {
		return Set.copyOf(sizeRepository.findAll());
	}

	@Override
	public Size updateSize(Size size, Long id) {
		Size existingSize = getSizeById(id);
		return sizeRepository.save(existingSize);
	}

	@Override
	public void deleteSize(Long id) {
		Size existingSize = getSizeById(id);
		sizeRepository.delete(existingSize);

	}
}