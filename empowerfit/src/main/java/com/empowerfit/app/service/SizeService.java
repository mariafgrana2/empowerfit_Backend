package com.empowerfit.app.service;
import java.util.Set;

import com.empowerfit.app.model.Size;

public interface SizeService {
	

    Size createSize(Size size);//create
    Size getSizeById(Long id);// read/get
    Set<Size> getAllSizes(); //read / get
    Size updateSize(Size size, Long id); //update
    void deleteSize(Long id); //delete

}
