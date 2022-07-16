package com.it.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.dto.ReserveDetailDto;
import com.it.entity.ReserveDetailEntity;
import com.it.repository.ReserveDetailRepository;


@Service
public class ReservDetailService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ReserveDetailRepository resevedeRepository;

	public List<ReserveDetailDto> findReDeAll() {
		List<ReserveDetailEntity> reservEntities =  resevedeRepository.findAll();
		return modelMapper.map(reservEntities, new TypeToken<List<ReserveDetailDto>>() {}.getType());
	}
	
	
	public ReserveDetailDto findReDeByReDeId(Integer resdeId) {
		Optional<ReserveDetailEntity> resdeOtn = resevedeRepository.findById(resdeId);
		if (resdeOtn.isPresent()) {
			return modelMapper.map(resdeOtn.get(), new TypeToken<ReserveDetailDto>() {}.getType());
		}
		
		return null;
	}
	
	public boolean saveReservede(ReserveDetailDto reservedetailDto) {
		boolean saveFlg = false;
		try {
			ReserveDetailEntity entity = modelMapper.map(reservedetailDto, ReserveDetailEntity.class);
			resevedeRepository.save(entity);
			saveFlg = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFlg;
	}
	
	public boolean updateReservedeId(Integer resdeId, ReserveDetailDto reservedetailDto) {
        boolean updateFlg  = false;
        try {
            Optional<ReserveDetailEntity> resdeOtn = resevedeRepository.findById(resdeId);
            if ( resdeOtn.isPresent()) {
                ReserveDetailEntity entity = modelMapper.map(reservedetailDto, ReserveDetailEntity.class);
                resevedeRepository.save(entity);
                updateFlg = true;

            }
        } catch(Exception e) {

        }
        return updateFlg;

    }

	
	public boolean deletReservedeById(Integer resdeId) {
		boolean deleteFlg = false;
		try {
			resevedeRepository.deleteById(resdeId);
			deleteFlg = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteFlg;
	}
	
	

}


