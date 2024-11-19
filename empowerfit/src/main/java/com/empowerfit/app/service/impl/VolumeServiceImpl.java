package com.empowerfit.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.empowerfit.app.model.Volume;
import com.empowerfit.app.repository.VolumeRepository;
import com.empowerfit.app.service.VolumeService;

@Service
public class VolumeServiceImpl implements VolumeService {
	public VolumeRepository volumeRepository;
	
	
	public VolumeServiceImpl(VolumeRepository volumeRepository) {
		this.volumeRepository = volumeRepository;
	}


	@Override
	public Volume createVolume(Volume volume) {
	Volume newVolume = volumeRepository.save(volume);
		return newVolume;
	}

	@Override
    public Volume getVolumeById(Long id) {
        Optional<Volume> optionalVolume = volumeRepository.findById(id);
        return optionalVolume.orElseThrow(() -> new IllegalStateException("No existe Volume con Id: " + id));
    }

    @Override
    public List<Volume> getAllVolumes() {
        return volumeRepository.findAll();
    }

    @Override
    public List<Volume> getVolumesByKg(Double kg) {
        return volumeRepository.findByKg(kg);
    }

    @Override
    public Volume updateVolume(Volume volume, Long id) {
        Volume existingVolume = getVolumeById(id);
     
        if (volume.getKg() != null) {
            existingVolume.setKg(volume.getKg());
        }
        return volumeRepository.save(existingVolume);
    }

    @Override
    public void deleteVolume(Long id) {
        Volume existingVolume = getVolumeById(id);
        volumeRepository.delete(existingVolume);
    }
}