package com.it.service;

import java.util.List;
import java.util.Optional;


import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.dto.WorkDto;
import com.it.entity.WorkEntity;
import com.it.repository.WorkRepository;

@Service
public class WorkService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private WorkRepository workRepository;

	public List<WorkDto> findWorkAll() {
		List<WorkEntity> workEntities = workRepository.findAll();
		return modelMapper.map(workEntities, new TypeToken<List<WorkDto>>() {}.getType());
	}
	
	
	public WorkDto findWorkByWorkId(Integer workId) {
		Optional<WorkEntity> workOtn = workRepository.findById(workId);
		if (workOtn.isPresent()) {
			return modelMapper.map(workOtn.get(), new TypeToken<WorkDto>() {}.getType());
		}
		
		return null;
	}
	
	public boolean saveWork(WorkDto workDto) {
		boolean saveFlg = false;
		try {
			WorkEntity entity = modelMapper.map(workDto, WorkEntity.class);
			workRepository.save(entity);
			saveFlg = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFlg;
	}
	
	public boolean updateWorkId(Integer workId, WorkDto workDto) {
        boolean updateFlg  = false;
        try {
            Optional<WorkEntity> workOtn = workRepository.findById(workId);
            if ( workOtn.isPresent()) {
                WorkEntity entity = modelMapper.map(workDto, WorkEntity.class);
                workRepository.save(entity);
                updateFlg = true;

            }
        } catch(Exception e) {

        }
        return updateFlg;

    }

	
	public boolean deleteWorkById(Integer workId) {
		boolean deleteFlg = false;
		try {
			workRepository.deleteById(workId);
			deleteFlg = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteFlg;
	}
	
	

}