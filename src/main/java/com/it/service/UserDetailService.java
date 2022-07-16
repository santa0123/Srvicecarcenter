package com.it.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.dto.UserDetailDto;
import com.it.entity.UserDetailEntity;
import com.it.repository.UserDetailRepository;

@Service
public class UserDetailService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserDetailRepository userdetailRepository;

	public List<UserDetailDto> findUserdeAll() {
		List<UserDetailEntity> userdeEntities = userdetailRepository.findAll();
		return modelMapper.map(userdeEntities, new TypeToken<List<UserDetailDto>>() {}.getType());
	}
	
	
	public UserDetailDto findUserdeById(Integer userdeId) {
		Optional<UserDetailEntity> userdeOtn = userdetailRepository.findById(userdeId);
		if (userdeOtn.isPresent()) {
			return modelMapper.map(userdeOtn.get(), new TypeToken<UserDetailDto>() {}.getType());
		}
		
		return null;
	}
	
	public boolean saveUserDetail(UserDetailDto userDetailDto) {
		boolean saveFlg = false;
		try {
			UserDetailEntity entity = modelMapper.map(userDetailDto, UserDetailEntity.class);
			userdetailRepository.save(entity);
			saveFlg = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFlg;
	}
	
	public boolean updateUserDetail(Integer userdeId, UserDetailDto userDetailDTO) {
        boolean updateFlg  = false;
        try {
            Optional<UserDetailEntity> userDetailOnt = userdetailRepository.findById(userdeId);
            if (userDetailOnt.isPresent()) {
                UserDetailEntity entity = modelMapper.map(userDetailDTO, UserDetailEntity.class);
                userdetailRepository.save(entity);
                updateFlg = true;

            }
        } catch(Exception e) {

        }
        return updateFlg;

    }

	
	public boolean deleteUserdeById(Integer userdeId) {
		boolean deleteFlg = false;
		try {
			userdetailRepository.deleteById(userdeId);
			deleteFlg = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteFlg;
	}
	
	

}
