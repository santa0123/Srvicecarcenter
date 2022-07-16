package com.it.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.dto.UserDTO;
import com.it.entity.UserEntity;
import com.it.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository;

	public List<UserDTO> findUserAll() {
		List<UserEntity> userEntities = userRepository.findAll();
		return modelMapper.map(userEntities, new TypeToken<List<UserDTO>>() {}.getType());
	}
	
	
	public UserDTO findUserdeByUserId(Integer userId) {
		Optional<UserEntity> userOtn = userRepository.findById(userId);
		if (userOtn.isPresent()) {
			return modelMapper.map(userOtn.get(), new TypeToken<UserDTO>() {}.getType());
		}
		
		return null;
	}
	
	public boolean saveUser(UserDTO userDTO) {
		boolean saveFlg = false;
		try {
			UserEntity entity = modelMapper.map(userDTO, UserEntity.class);
			userRepository.save(entity);
			saveFlg = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFlg;
	}
	
	public boolean updateUser(Integer userId, UserDTO userDTO) {
        boolean updateFlg  = false;
        try {
            Optional<UserEntity> userOtn = userRepository.findById(userId);
            if (userOtn.isPresent()) {
                UserEntity entity = modelMapper.map(userDTO, UserEntity.class);
                userRepository.save(entity);
                updateFlg = true;

            }
        } catch(Exception e) {

        }
        return updateFlg;

    }

	
	public boolean deleteUserById(Integer userId) {
		boolean deleteFlg = false;
		try {
			userRepository.deleteById(userId);
			deleteFlg = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteFlg;
	}
	
	

}

